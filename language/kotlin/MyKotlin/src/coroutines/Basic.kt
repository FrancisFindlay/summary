package coroutines

import javax.xml.bind.JAXBElement

/**
 *
 */

import kotlinx.coroutines.*
import usedSyntax.test
import kotlin.concurrent.thread

fun main() {
    GlobalScope.launch {
        delay(1000) // delay : non-blocking,
        println(", World")
    }
    print("Hello")
    Thread.sleep(2000) // blocking function


    GlobalScope.launch {
        // launch a new coroutine in background and continue
        delay(1000L)
        println("World!")
    }
    print("Hello,") // main thread continues here immediately
    runBlocking {
        // but this expression blocks the main thread
        delay(2000L)  // ... while we delay for 2 seconds to keep JVM alive
    } // 非阻塞的delay需要用到阻塞的 runBlocking 来实现阻塞主线程

    /**
     * This example can be also rewritten in a more idiomatic way,
     * using runBlocking to wrap the execution of the main function:
     */
    fun test1() = runBlocking<Unit> {
        GlobalScope.launch {
            delay(1000)
            print(" World!")
        }
        println("Hello, ")
        delay(2000)
    }


    /**
     * Delaying for a time while another coroutine is working is not a good approach.
     * Let's explicitly wait (in a non-blocking way) until the background Job that we have launched is complete:
     */
    fun test2() = runBlocking {
        val job = GlobalScope.launch {
            // launch a new coroutine and keep a reference to its Job
            delay(5000L)
            println("World!")
        }
        print("Hello,")
        job.join() // wait until child coroutine completes then execute ...
        println("test2 has finish...")
    }
    test2()

    /**
     * 当我们使用 GlobalScope.launch 时，我们会创建 一个顶层协程。虽然它很轻量，但它运行时仍会消耗一些内存资源。
     *
     * 在我们的示例中，我们使用 runBlocking 协程构建器将 main 函数转换为协程。
     *
     * 包括 runBlocking 在内的每个协程构建器都会在作用域中构建一个 CoroutineScope。我们可以在这个作用域中启动协程而无需显式 join ，
     * 因为外部协程(示例中的 runBlocking )直到在其作用域中启动的所有协程都执行完毕后才会结束。
     */
    fun test3() = runBlocking {
        // this: CoroutineScope
        launch {
            // launch a new coroutine in the scope of runBlocking
            delay(1000L)
            println("World!")
        }
        print("Hello,") // runBlocking 是阻塞的， 因此会等待子协程执行完毕才会结束，World会正常输出。
    }
    test3()

    /**
     * runBlocking 与 coroutineScope 可能看起来很类似，因为它们都会等待其协程体以及所有子协程结束。
     *
     * 这两者的主要区别在于，runBlocking 方法会阻塞当前线程来等待， 而 coroutineScope 只是挂起，会释放底层线程用于其他用途。
     * 由于存在这点差异，runBlocking 是常规函数，而 coroutineScope 是挂起函数。
     */

    fun test4() = runBlocking {
        launch {
            delay(200)
            println("task from runBlocking...")
        }

        coroutineScope {
            launch {
                delay(500)
                println("Task from nested launch...")
            }
            delay(100)
            println("task from coroutine scope...") // 即使coroutineScope没有执行完， 也会执行task from runBlocking， 因为coroutineScope 不阻塞当前线程；
        }

        println("coroutine scope is over...")
    }
    test4()


    /**
     * 协程是轻量级的：
     * 它启动了 10 万个协程，并且在一秒钟后，每个协程都输出一个点。 现在，尝试使用线程来实现。会发生什么?
     * (很可能你的代码会产生某种内存不足的错误)
     */
    runBlocking {
        repeat(100_000) {
            // launch a lot of coroutines
            launch {
                delay(1000L)
                print(".")
            }
        }


    }

}
