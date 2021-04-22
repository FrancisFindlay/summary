package coroutines

import kotlinx.coroutines.*

/**
 * 当调用 launch { ...... } 时不传参数，它从启动了它的 CoroutineScope 中承袭了上下文(以 及调度器)。
 * 在这个案例中，它从 main 线程中的 runBlocking 主协程承袭了上下文。
 *
 * Dispatchers.Unconfined 是一个特殊的调度器且似乎也运行在 main 线程中，但实际上， 它 是一种不同的机制，这会在后文中讲到。
 *
 * 默认调度器，当协程在 GlobalScope 中启动的时候使用， 它代表 Dispatchers.Default 使用了共享的后台线程池，
 * 所以 GlobalScope.launch { ...... } 也可以使用相同的调度器——launch(Dispatchers.Default) { ...... } 。
 *
 * newSingleThreadContext 为协程的运行启动了一个线程。 一个专用的线程是一种非常昂贵的资源。
 * 在真实的应用程序中两者都必须被释放，当不再需要的时候，使用 close 函数，或存 储在一个顶层变量中使它在整个应用程序中被重用。
 */

fun main() {
    runBlocking {
        launch {
            // context of the parent, main runBlocking coroutine
            println("main runBlocking      : I'm working in thread ${Thread.currentThread().name}")
        }
        launch(Dispatchers.Unconfined) {
            // not confined -- will work with main thread
            println("Unconfined            : I'm working in thread ${Thread.currentThread().name}")
        }
        launch(Dispatchers.Default) {
            // will get dispatched to DefaultDispatcher
            println("Default               : I'm working in thread ${Thread.currentThread().name}")
        }
        launch(newSingleThreadContext("MyOwnThread")) {
            // will get its own new thread
            println("newSingleThreadContext: I'm working in thread ${Thread.currentThread().name}")
        }
    }
}
