package moreLanguageConstructs

fun foo(a: Int) = when (a) {
    1 -> 1
    2 -> 2
    else -> 0
}



fun main() {
    println(foo(1))
    when {
        true -> 1 // when 没有参数的情况下，左侧需要是boolean
    }
}