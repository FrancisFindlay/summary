package collections


fun main() {
    /**
     * 对于集合操作，可以指定目标对象。
     */

    //sampleStart
    val numbers = listOf("one", "two", "three", "four")
    val filterResults = mutableListOf<String>() // 目标对象
    numbers.filterTo(filterResults) { it.length > 3 }
    numbers.filterIndexedTo(filterResults) { index, _ -> index < 2 }
    println(filterResults) // 包含两个操作的结果
    //sampleEnd

    val result = numbers.mapTo(HashSet()) { it.length }
    println("distinct item lengths are $result")
    numbers.sorted() // 没有 sort

    /**
     * 对于可变集合，还存在可更改集合状态的 写操作 。这些操作包括添加、删除和更新元素。
     * 写 操作在集合写操作以及 List 写操作与 Map 写操作的相应部分中列出。
     * 对于某些操作，有成对的函数可以执行相同的操作:一个函数就地应用该操作，另一个函数 将结果作为单独的集合返回。 例如， sort() 就地对可变集合进行排序，因此其状态发生了 变化; sorted() 创建一个新集合，该集合包含按排序顺序相同的元素。
     */

    val number = mutableListOf("one", "two", "three", "four")
    val sortedNumbers = number.sorted() // 新生成了 list
    println(number == sortedNumbers) // false
    number.sort()
    println(number == sortedNumbers)  // true

}