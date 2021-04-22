package coroutines

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis


fun main() = runBlocking {
    /**
     * 顺序执行：
     */
    var time = measureTimeMillis {
        val one = doSomethingUsefulOne()
        println(one.javaClass) // int
        val two = doSomethingUsefulTwo()
        println("The answer is ${one + two}")
    }
    println("Completed in $time ms")

    println()
    println()

    /**
     * 异步执行：
     * 在概念上，async 就类似于 launch。它启动了一个单独的协程，这是一个轻量级的线程并与其它所有的协程一起并发的工作。
     * 不同之处在于 launch 返回一个 Job 并且不附带任何结果值，而 async 返回一个 Deferred —— 一个轻量级的非阻塞 future，
     * 这代表了一个将会在稍 后提供结果的 promise。
     * 你可以使用 .await() 在一个延期的值上得到它的最终结果， 但是 Deferred 也是一个 Job ，所以如果需要的话，你可以取消它。
     */
    time = measureTimeMillis {
        val one = async { doSomethingUsefulOne() }
        val two = async { doSomethingUsefulTwo() }
        // one.cancel()
        println(one.javaClass) // DeferredCoroutine
        println("The answer is ${one.await() + two.await()}")
    }
    println("Completed in $time ms")
    // 这里快了两倍，因为两个协程并发执行。 请注意，使用协程进行并发总是显式的。


    println()
    println()

    /**
     * 惰性启动async:
     *
     * 可选的，async 可以通过将 start 参数设置为 CoroutineStart.LAZY 而变为惰性的。
     * 在这个模式下，只有结果通过 await 获取的时候协程才会启动，或者在 Job 的 start 函数调用的时 候。运行下面的示例:
     */
    time = measureTimeMillis {
        val one = async(start = CoroutineStart.LAZY) { doSomethingUsefulOne() }
        val two = async(start = CoroutineStart.LAZY) { doSomethingUsefulTwo() }
        // some computation
        one.start() // start the first one
        two.start() // start the second one
        println("The answer is ${one.await() + two.await()}")
    }
    println("Completed in $time ms")

    println()
    println()


    /**
     * async 风格的函数:
     * 注意，这些 xxxAsync 函数不是挂起函数。它们可以在任何地方使用。
     * 然而，它们总是在调用它们的代码中意味着异步(这里的意思是并发)执行。
     */
    time = measureTimeMillis {
        // we can initiate async actions outside of a coroutine
        val one = somethingUsefulOneAsync()
        val two = somethingUsefulTwoAsync()
        // but waiting for a result must involve either suspending or blocking.
        // here we use `runBlocking { ... }` to block the main thread while waiting for the result
        runBlocking {
            println("The answer is ${one.await() + two.await()}")
        }
    }
    println("Completed in $time ms")

    println()
    println()

    time = measureTimeMillis {
        println("The answer is ${concurrentSum()}")
    }
    println("Completed in $time ms")

    println()
    println()

    /**
     * 取消始终通过协程的层级结构来传递：
     * 请注意，如果其中一个子协程(即 two )失败，第一个 async 以及等待中的父协程都会被取消:
     */


    suspend fun failedConcurrentSum(): Int = coroutineScope {
        val one = async<Int> {
            try {
                delay(Long.MAX_VALUE) // Emulates very long computation
                42
            } finally {
                println("First child was cancelled")
            }
        }
        val two = async<Int> {
            println("Second child throws an exception")
            throw ArithmeticException()
        }
        one.await() + two.await()
    }

    fun Cancellation() = runBlocking<Unit> {
        try {
            failedConcurrentSum()
        } catch (e: ArithmeticException) {
            println("Computation failed with ArithmeticException")
        }
    }

    Cancellation()

}

suspend fun concurrentSum(): Int = coroutineScope {
    val one = async {
        doSomethingUsefulOne()
    }
    val two = async {
        doSomethingUsefulTwo()
    }
    one.await() + two.await()
}


suspend fun doSomethingUsefulOne(): Int {
    delay(1000L) // pretend we are doing something useful here
    return 13
}

suspend fun doSomethingUsefulTwo(): Int {
    delay(1000L) // pretend we are doing something useful here, too
    return 29
}


// The result type of somethingUsefulOneAsync is Deferred<Int>
fun somethingUsefulOneAsync() = GlobalScope.async {
    doSomethingUsefulOne()
}

// The result type of somethingUsefulTwoAsync is Deferred<Int>
fun somethingUsefulTwoAsync() = GlobalScope.async {
    doSomethingUsefulTwo()
}