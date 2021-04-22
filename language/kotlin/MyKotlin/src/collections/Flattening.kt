package collections

/**
 *
 */

data class StringContainer(val values: List<String>)

fun main() {

    /**
     * 第一个函数为 flatten() 。可以在一个集合的集合(例如，一个 Set 组成的 List )上调 用它。 该函数返回嵌套集合中的所有元素的一个 List 。
     */
    val numberSets = listOf<Set<Int>>(setOf(1, 2, 3), setOf(4, 5, 6), setOf(1, 2))
    println(numberSets.flatten()) // 把所有元素放在一个List中。

    /**
     * 另一个函数 flatMap() 提供了一种灵活的方式来处理嵌套的集合。 它需要一个函数将一 个集合元素映射到另一个集合。
     * 因此， flatMap() 返回单个列表其中包含所有元素的值。 所 以， flatMap() 表现为 map() (以集合作为映射结果)与 flatten() 的连续调用。
     */

    //sampleStart
    val containers = listOf(
            StringContainer(listOf("one", "two", "three")),
            StringContainer(listOf("four", "five", "six")),
            StringContainer(listOf("seven", "eight"))
    )
    println(containers.flatMap { it.values })
    //sampleEnd

    // You can view flatMap(identity) as map(identity).flatten.
    // (Of course it is not implemented that way, since it would take two iterations).


}