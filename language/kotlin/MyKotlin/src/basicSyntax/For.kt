package basicSyntax

/**
 * for 可以对任何提供了迭代器的对象进行遍历
 * 迭代器提供了iterator（），next（）和hasNext（）三个函数，并且这三个函数都需要声明为operator
 */

fun main() {
    val items = listOf<Any>("Apple", "Banana", "kiwifruit", 1)
    for (item in items) {
        print("$item ")
        println(item.javaClass.name)
    }

    for (index in items.indices) { // items.indices : 列表index
        println("item at $index is ${items[index]}")
    }

    // 对区间或者数组的 for 循环会被编译为并不创建迭代器的基于索引的循环。
    val array = arrayOf("a", "b", "")
    for (i in array.indices) {
        println(array[i])
    }

    // 库函数withIndex()
    for ((index, value) in array.withIndex()) {
        println("index is $index, value is $value...")
    }

}