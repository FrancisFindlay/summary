package moreLanguageConstructs

/**
 * run:
 * 上下文对象 作为接收者( this )来访问。 返回值 是 lambda 表达式结果。
 * run 和 with 做同样的事情，但是run是扩展函数。
 * 当 lambda 表达式同时包含对象初始化和返回值的计算时， run 很有用。
 */

fun main() {
    class MultiportService(var url: String, var port: Int) {
        fun prepareRequest(): String = "Default request"
        fun query(request: String): String = "Result for query '$request'"
    }

    val service = MultiportService("https://example.kotlinlang.org", 80)
    val result = service.run {
        port = 8080
        query(prepareRequest() + " to port $port")
    }
    // 同样的代码如果用 let() 函数来写:
    val letResult = service.let {
        it.port = 8080
        it.query(it.prepareRequest() + " to port ${it.port}")
    }
    println(result)
    println(letResult)
    // 除了在接收者对象上调用 run 之外，还可以将其用作非扩展函数。 非扩展 需要表达式的地方执行一个由多个语句组成的块。
    val hexNumberRegex = run {
        val digits = "0-9"
        val hexDigits = "A-Fa-f"
        val sign = "+-"
        Regex("[$sign]?[$digits$hexDigits]+")
    }
    for (match in hexNumberRegex.findAll("+1234 -FFFF not-a-number")) {
        println(match.value)
    }
}