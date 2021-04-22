package collections

/**
 * Set<T> 存储唯一的元素;它们的顺序通常是未定义的。
 * null 元素也是唯一的:一个 Set 只能包含一个 null 。
 * 当两个 set 具有相同的大小并且对于一个 set 中的每个元素都能在 另一个 set 中存在相同元素，则两个 set 相等。
 */

/**
 * MutableSet 是一个带有来自 MutableCollection 的写操作接口的 Set 。
 * Set 的默认实现 - LinkedHashSet – 保留元素插入的顺序。 因此，依赖于顺序的函数，例如first() 或 last() ，会在这些 set 上返回可预测的结果。
 */

/**
 * 另一种实现方式 – HashSet – 不声明元素的顺序，所以在它上面调用这些函数会返回不可预 测的结果。
 * 但是， HashSet 只需要较少的内存来存储相同数量的元素。
 */

fun main() {
    //sampleStart
    val numbers = setOf(1, 2, 3, 4)
    println("Number of elements: ${numbers.size}")
    println(numbers)
    if (numbers.contains(1)) println("1 is in the set")
    val numbersBackwards = setOf(4, 3, 2, 1)
    println("The sets are equal: ${numbers == numbersBackwards}") // true
    //sampleEnd

    //sampleStart
    val numbers2 = setOf(1, 2, 3, 4)  // LinkedHashSet is the default implementation
    val numbersBackwards2 = setOf(4, 3, 2, 1)
    println(numbers2.first() == numbersBackwards2.first()) // false
    println(numbers2.first() == numbersBackwards2.last()) // true
    //sampleEnd


}