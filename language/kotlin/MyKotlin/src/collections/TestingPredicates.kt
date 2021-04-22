package collections

/**
 * 如果至少有一个元素匹配给定谓词，那么 any() 返回 true 。
 * 如果没有元素与给定谓词匹配，那么 none() 返回 true 。
 * 如果所有元素都匹配给定谓词，那么 all() 返回 true 。
 * 注意，在一个空集合上使用任 何有效的谓词去调用 all() 都会返回 true 。这种行为在逻辑上被称为 vacuous truth。
 */

fun main() {
    val numbers = listOf("one", "two", "three", "four")
    println(numbers.any { it.endsWith("e") })
    println(numbers.none { it.endsWith("a") })
    println(numbers.all { it.endsWith("e") })
    println(emptyList<Int>().all { it > 5 })

    /**
     * any() 和 none() 也可以不带谓词使用:在这种情况下它们只是用来检查集合是否为空。
     * 如果集合中有元素， any() 返回 true ，否则返回 false ; none() 则相反。
     */
    val empty = emptyList<String>()
    println(numbers.any())
    println(empty.any())
    println(numbers.none())
    println(empty.none())
}
