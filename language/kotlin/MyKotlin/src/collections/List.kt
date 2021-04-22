package collections

import java.util.*

/**
 * List 元素(包括空值)可以重复:List 可以包含任意数量的相同对象或单个对象的出现。
 * 如果两个 List 在相同的位置具有相同大小和相同结构的元素，则认为它们是相等的。
 */

data class Person(var name: String, var age: Int)

/**
 * MutableList 是可以进行写的List:
 *
 * 如你所见，在某些方面，List 与数组(Array)非常相似。 但是，有一个重要的区别:数组的 大小是在初始化时定义的，永远不会改变; 反之，List 没有预定义的大小;作为写操作的结 果，可以更改 List 的大小:添加，更新或删除元素。
 * 在 Kotlin 中， List 的默认实现是 ArrayList ，可以将其视为可调整大小的数组。
 */

/**
 * 对于List来说：有初始化容量和初始化器两个参数：
 */

val list = List(3) { it * 2}

fun main() {
    val bob = Person("Bob", 31)
    val people = listOf<Person>(Person("Adam", 20), bob, bob)
    val people2 = listOf<Person>(Person("Adam", 20), Person("Bob", 31), bob)
    println(people == people2)
    println(people === people2) // 引用
    bob.age = 32
    println(people == people2)

    //sampleStart
    val numbers = mutableListOf(1, 2, 3, 4)
    numbers.add(5)
    numbers.removeAt(1)
    numbers[0] = 0
    numbers.shuffle() // 打乱
    println(numbers)
    //sampleEnd


    val linkedList = LinkedList(listOf("one", "two", "three"))


}
