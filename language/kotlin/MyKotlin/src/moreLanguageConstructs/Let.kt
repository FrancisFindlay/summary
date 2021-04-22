package moreLanguageConstructs

/**
 * 上下文对象作为 lambda 表达式的参数( it )来访问。返回值是 lambda 表达式的结果。
 */

fun main() {
    val numbers = mutableListOf("one", "two", "three", "four", "five")
    val result = numbers.map { it.length }.filter { it > 3 }
    println(result)

    /**
     * 使用let
     */
    numbers.map { it.length }.filter { it > 3 }.let { println(it) }

    /**
     * 若代码块仅包含以 it 作为参数的单个函数，则可以使用方法引用( :: )代替 lambda 表达 式:
     */
    numbers.map { it.length }.filter { it > 3 }.let(::println)

    /**
     * let 经常用于仅使用非空值执行代码块。
     * 如需对非空对象执行操作，可对其使用安全调用操 作符 ?. 并调用 let 在 lambda 表达式中执行操作。
     */
    fun processNonNullString(str: String) {}

    val str: String? = "hello"
    // processNonNullString(str) 编译错误
    val length = str?.let {
        println("let() called on $it")
        processNonNullString(it)
        it.length
    }

    /**
     * 使用 let 的另一种情况是引入作用域受限的局部变量以提高代码的可读性。
     * 如需为上下文对 象定义一个新变量，可提供其名称作为 lambda 表达式参数来替默认的 it 。
     */
    val number = listOf("one", "two", "three", "four")
    val modifiedFirstItem = number.first().let { firstItem ->
        println("The first item of the list is '$firstItem'")
        if (firstItem.length > 5) firstItem else "!$firstItem!"
    }.toUpperCase()
    println("First item after modifications: '$modifiedFirstItem'")
}

