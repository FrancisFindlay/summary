package coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Thread.sleep(): 阻塞,挂起线程;
 * delay(): 非阻塞, 不会挂起 线程， 只会挂起 协程;
 */

fun main() {
    GlobalScope.launch {
        delay(2000)
        println("before")
    }
    GlobalScope.launch {
        delay(1000)
        println("after")
    }
    Thread.sleep(3000)
    GlobalScope.launch {
        Thread.sleep(20000) // 为什么没有 blocking main thread...
    }
    println("...")


}