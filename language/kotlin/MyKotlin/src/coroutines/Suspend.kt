package coroutines

import kotlinx.coroutines.*

/**
 * suspend 函数可以像常规函数一样在协程内部使用，但是它们的附加功能是它们可以依次使用其他 suspend 函数（例如本示例中的延迟）来暂停协程的执行。
 */

fun main() = runBlocking {
    launch {
        doWorld()
    }
    println("Hello, ")


    /**
     * 在 GlobalScope 中启动的活动协程并不会使进程保活。它们就像守护线程。
     */
    GlobalScope.launch {
        repeat(1000) { i ->
            delay(500)
            println("I'm sleeping in $i")
        }
    }
    delay(1300)
}

suspend fun doWorld() {
    delay(1000L)
    println("World!")
}