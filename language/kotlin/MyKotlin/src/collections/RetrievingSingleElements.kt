package collections

/**
 * 取单个元素:
 *
 */

fun main() {
    var numbers = linkedSetOf("one", "two", "three", "four", "five")
    println(numbers.elementAt(3))
    val numbersSortedSet = sortedSetOf("one", "two", "three", "four")
    println(numbersSortedSet.elementAt(0)) // 元素以升序存储

    println(numbers.first())
    println(numbers.last())

    /**
     * 为了避免在检索位置不存在的元素时出现异常，请使用 elementAt() 的安全变体:
     */
    var list = listOf("one", "two", "three", "four")
    println(list.elementAtOrNull(4))
    println(list.elementAtOrElse(4, { index ->
        "The value for index $index is undefined"
    }))

    println(list.first { it.length > 3 })
    println(list.last { it.startsWith("f") })
    /**
     * 如果没有元素与谓词匹配，两个函数都会抛异常。 为了避免它们，请改用 lastOrNull() 和 firstOrNull() ;
     * 如果找不到匹配的元素，它们将返回 null 。
     */
    println(list.firstOrNull { it.length > 6 })

    /**
     * 或者，如果别名更适合你的情况，那么可以使用别名:
     * 使用 find() 代替 firstOrNull() 使用 findLast() 代替 lastOrNull()
     */
    val numberList = listOf(1, 2, 3, 4)
    println(numberList.find { it % 2 == 0 }) // firstOrNull
    println(numberList.findLast { it % 2 == 0 }) // lastOrNull


    /**
     * 随机取元素：
     */
    println(numberList.random()) // 从集合随机取一个元素


    /**
     * 检测是否存在:
     */
    list = listOf("one", "two", "three", "four", "five", "six")
    println(list.contains("four"))
    println("zero" in list)
    println(list.containsAll(listOf("four", "two")))
    println(list.containsAll(listOf("one", "zero")))


}