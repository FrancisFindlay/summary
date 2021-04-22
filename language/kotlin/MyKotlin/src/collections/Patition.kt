package collections

/**
 * 另一个过滤函数 – partition() – 通过一个谓词过滤集合并且将不匹配的元素存放在一个单 独的列表中。
 * 因此，你得到一个 List 的 Pair 作为返回值:
 * 第一个列表包含与谓词匹配的 元素并且第二个列表包含原始集合中的所有其他元素。
 */

fun main() {
    val numbers = listOf("one", "two", "three", "four")
    val (match, rest) = numbers.partition { it.length > 3 } // return a pair that first list contains match elements, not match another.
    println(match)
    println(rest)
    
}