package moreLanguageConstructs

/**
 * 上下文对象作为 lambda 表达式的参数( it )来访问。 返回值是上下文对象本身。
 * also 对于执行一些将上下文对象作为参数的操作很有用。 对于不会改变上下文对象的操 作，可使用 also ，例如记录或打印调试信息。 通常，你可以在不破坏程序逻辑的情况下从 调用链中删除 also 的调用。
 */

fun main() {
    val numbers = mutableListOf("one", "two", "three")
    numbers.also { println("The list elements before adding new one: $it") }.add("four")

}