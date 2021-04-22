package collections


/**
 * Kotlin 标准库提供了基本集合类型的接口: set、list 以及 map。 每一个接口都有两种类型:
 *      一个只读接口，提供访问集合元素的操作。
 *      一个可变接口，通过写操作扩展相应的只读接口:添加、删除和更新其元素。
 *
 * 请注意，更改可变集合不需要它是以 var 定义的变量:写操作修改同一个可变集合对象，因 此引用不会改变。
 * 但是，如果尝试对 val 集合重新赋值，你将收到编译错误。
 */

/**
 * 只读集合类型是型变的。 这意味着，如果类 Rectangle 继承自 Shape ，则可以在需要 List <Shape> 的任何地方使用 List <Rectangle> 。
 * 换句话说，集合类型与元素类型具有相同的子 类型关系。 map 在值(value)类型上是型变的，但在键(key)类型上不是。
 */


open class Shape

class C : Shape()

fun printAll(strings: Collection<String>) {
    for (s in strings) {
        print("$s ")
    }
    println()
}


fun List<String>.getShortWordsTo(shortWords: MutableCollection<String>, maxLength: Int) {
    this.filterTo(shortWords) { it.length <= maxLength }
    // throwing away the articles
    val articles = setOf("a", "A", "an", "An", "the", "The")
    shortWords -= articles // shortWords被修改了。
}


fun main() {
    val list = ArrayList<Shape>()
    list.add(C())
    list.add(Shape())

    val stringList = listOf("one", "two", "three")
    printAll(stringList)
    val stringSet = setOf("one", "two", "three")
    printAll(stringSet)

    val words = "A long time ago in a galaxy far far away".split(" ")
    val shortWords = mutableListOf<String>()
    words.getShortWordsTo(shortWords, 3)
    println(shortWords)

}