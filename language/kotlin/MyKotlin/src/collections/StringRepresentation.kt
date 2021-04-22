package collections

/**
 * 如果需要以可读格式检索集合内容，请使用将集合转换为字符串的函数: joinToString() 与joinTo() 。
 * joinToString() 根据提供的参数从集合元素构建单个 String 。 joinTo() 执行相同的操作，但将结果附加到给定的 Appendable 对象。
 * 当使用默认参数调用时，函数返回的结果类似于在集合上调用 toString() :各元素的字符串表示形式以空格分隔而成的 String 。
 */

/**
 * 要构建自定义字符串表示形式，可以在函数参数 separator 、 prefix 与 postfix 中指定其 参数。
 * 结果字符串将以 prefix 开头，以 postfix 结尾。除最后一个元素外， separator 将位于每个元素之后。
 */

fun main() {
    val numbers = listOf("one", "two", "three", "four")
    println(numbers)
    println(numbers.joinToString(", "))
    val listString = StringBuffer("The list of numbers: ")
    numbers.joinTo(listString, ", ")
    println(listString)

    println(numbers.joinToString(separator = " | ", prefix = "start: ", postfix = ": end")) // prefix, postfix 只会在String的最开始和最后面生效

    /**
     * 对于较大的集合，可能需要指定 limit ——将包含在结果中元素的数量。
     * 如果集合大小超出limit ，所有其他元素将被 truncated 参数的单个值替换。
     */
    val number = (1..100).toList()
    println(number.joinToString(limit = 10, truncated = "<...>")) // truncated: 截去


}
