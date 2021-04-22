package coroutines

import kotlinx.coroutines.*

fun main() = runBlocking {
    var job = launch {
        repeat(1000) { i ->
            println("job: I'm sleeping $i ...")
            delay(500L)
        }
    }
    delay(1300L) // delay a bit
    println("main: I'm tired of waiting!")
    job.cancel() // cancels the job
    job.join() // waits for job's completion
    println("main: Now I can quit.")


    println()
    println()


    /**
     * 协程的取消是 协作 的。一段协程代码必须协作才能被取消。
     * 所有 kotlinx.coroutines 中的 挂起函数都是可被取消的 。它们检查协程的取消，并在取消时抛出 CancellationException。
     * 然而，如果协程正在执行计算任务，并且没有检查取消的话，那么 它是不能被取消的。
     * 就如如下示例代码所示:
     */

    var startTime = System.currentTimeMillis()
    job = launch(Dispatchers.Default) {
        var nextPrintTime = startTime
        var i = 0
        while (i < 5) { // computation loop, just wastes CPU
            // print a message twice a second
            if (System.currentTimeMillis() >= nextPrintTime) {
                println("job: I'm sleeping ${i++} ...")
                nextPrintTime += 500L
            }
        }
    }
    delay(1300L) // delay a bit
    println("main: I'm tired of waiting!")
    // 无法取消计算代码
    job.cancelAndJoin() // cancels the job and waits for its completion
    println("main: Now I can quit.")

    println()
    println()

    /**
     * 使计算代码可以取消:
     * 我们有两种方法来使执行计算的代码可以被取消。第一种方法是定期调用挂起函数来检查取消。对于这种目的 yield 是一个好的选择。
     * 另一种方法是显式的检查取消状态。让我们试试第二种方法。
     *
     * 你可以看到，现在循环被取消了。isActive 是一个可以被使用在 CoroutineScope 中的扩展属性。
     */

    startTime = System.currentTimeMillis()
    job = launch(Dispatchers.Default) {
        var nextPrintTime = startTime
        var i = 0
        while (isActive) { // cancellable computation loop
            // print a message twice a second
            if (System.currentTimeMillis() >= nextPrintTime) {
                println("job: I'm sleeping ${i++} ...")
                nextPrintTime += 500L
            }
        }
    }
    delay(1300L) // delay a bit
    println("main: I'm tired of waiting!")
    job.cancelAndJoin() // cancels the job and waits for its completion
    println("main: Now I can quit.")


    println()
    println()


    /**
     *
     */
    job = launch {
        try {
            repeat(1000) { i ->
                println("job: I'm sleeping $i ...")
                delay(500L)
            }
        } finally {
            println("job: I'm running finally")
        }
    }
    delay(1300L) // delay a bit
    println("main: I'm tired of waiting!")
    job.cancelAndJoin() // cancels the job and waits for its completion
    println("main: Now I can quit.")

    println()
    println()

    job = launch {
        try {
            repeat(1000) { i ->
                println("job: I'm sleeping $i ...")
                delay(500L)
            }
        } finally {
            withContext(NonCancellable) {
                println("job: I'm running finally")
                delay(1000L)
                println("job: And I've just delayed for 1 sec because I'm non-cancellable")
            }
        }
    }
    delay(1300L) // delay a bit
    println("main: I'm tired of waiting!")
    job.cancelAndJoin() // cancels the job and waits for its completion
    println("main: Now I can quit.")

    println()
    println()

    /**
     * 在实践中绝大多数取消一个协程的理由是它有可能超时。
     * 当你手动追踪一个相关 Job 的引用 并启动了一个单独的协程在延迟后取消追踪，这里已经准备好使用 withTimeout 函数来做这件 事。来看看示例代码:
     *
     *
     * withTimeout 抛出了 TimeoutCancellationException ，它是 CancellationException 的子类。
     * 我们之前没有在控制台上看到堆栈跟踪信息的打印。
     * 这是因为在被取消的协程中CancellationException 被认为是协程执行结束的正常原因。
     * 然而，在这个示例中我们在 main 函数中正确地使用了 withTimeout 。
     */


    println()
    println()

    /**
     * withTimeoutOrNull 通过返回 null 来进行超时操作，从而替代抛出一个异常:
     */

    val result = withTimeoutOrNull(1300L) {
        repeat(1000) { i ->
            println("I'm sleeping $i ...")
            delay(500L)
        }
        "Done" // will get cancelled before it produces this result

    }
    println("Result is $result")

}