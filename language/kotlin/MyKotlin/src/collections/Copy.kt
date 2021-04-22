package collections

/**
 *  To create a collection with the same elements as an existing collection, you can use copying operations.
 *  Collection copying operations from the standard library create shallow copy collections with references to the same elements.
 *  Thus, a change made to a collection element reflects in all its copies.
 *
 *
 *  Collection copying functions, such as toList(), toMutableList(), toSet() and others,
 *  create a snapshot of a collection at a specific moment.
 *  Their result is a new collection of the same elements.
 *  If you add or remove elements from the original collection, this won't affect the copies.
 *  Copies may be changed independently of the source as well.
 */

/**
 * 也可以创建指向sourceList的引用:
 */

fun main() {
    val sourceList = mutableListOf(1, 2, 3)
    val copyList = sourceList.toMutableList()
    val readOnlyCopyList = sourceList.toList()
    sourceList.add(4) // 不会反应在copyList
    println(readOnlyCopyList)

    val referenceList = sourceList
    sourceList.add(5)
    println(sourceList)

    val referenceListAnother: List<Int> = sourceList
    // referenceListAnother.add() 编译错误
    sourceList.add(6)
    println(referenceListAnother)


    /**
     * 可以通过其他集合各种操作的结果来创建集合。filter 操作会 新创建一个 list：
     */
    val numbers = listOf("one", "two", "three")
    val longThan3 = numbers.filter { it.length > 3 }

    /**
     * 映射转换生成列表：
     */
    val numberSet = setOf(1, 2, 3)
    println(numberSet.map { it * 3 }.javaClass)
    println(numberSet.mapIndexed { idx, value -> value * idx })

    /**
     * 关联生成Map：
     */
    val num = listOf<String>("one", "two", "three")
    println(num.associateWith { it.length }) // 生成linkedhashMap


    val l = listOf(1, 2, 3)
    // val ll: MutableList<Int> = l 编译错误，子类可以转为父类，父类不能转为子类


}