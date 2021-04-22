package collections

/**
 * plus 的结果包含原始集合 和 第二个操作数中的元素。
 * minus 的结果包含原始集合中的元素，但第二个操作数中的元素除外。 如果第二个操作数是一个元素，那么 minus 移除其在原始集合中的 第一次 出现;如果是一个集合， 那么移除其元素在原始集合中的 所有 出现。
 */

fun main() {
    val numbers = listOf("one", "two", "three", "four")
    val plusList = numbers + "five"
    val minusList = numbers - listOf("three", "four")
    println(plusList)
    println(minusList)

    val list = listOf("one", "one", "one")
    val list1 = list - listOf("one") // 集合，因此移除所有 one
    val list2 = list - "one" // 只移除第一个出现的
    println(list1)
    println(list2)


}