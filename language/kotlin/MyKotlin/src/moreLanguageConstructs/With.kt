package moreLanguageConstructs

/**
 * with:
 * 一个非扩展函数:上下文对象作为参数传递，但是在 lambda 表达式内部，它可以作为接收者 ( this )使用。 返回值是 lambda 表达式结果。
 */

fun main() {
    val numbers = listOf("one", "two", "three")
    with(numbers) {
        println("'with' is called with argument $this")
        println("it contains $numbers.size elements")
    }
    // with 的另一个使用场景是引入一个辅助对象，其属性或函数将用于计算一个值。
    val number = mutableListOf("one", "two", "three")
    val firstAndLast = with(numbers) {
        "The first element is ${first()}," +
                " the last element is ${last()}"
    }
    println(firstAndLast)

}