package basicType

/**
 * Kotlin中，数组是不可变型的，不能把Array<String>赋值给Array<Any>
 */

fun main() {
    // 创建了一个大小为0的空数组，实际上是调用了arrayofNulls
    val array1 = emptyArray<String>()


    val array2 = arrayOfNulls<String>(0)

    val array3 = Array(10) { i -> i * i }

    val array4 = arrayOf("string", 1, 'c')

    val array5 = intArrayOf(2)

    array4
            .forEach { println(it) }
    array3
            .forEach { println(it) }
    array3
            .sortedArrayDescending() // 逆序
            .forEach { println(it) }


    // 原生数组

    val x: IntArray = intArrayOf(1, 2, 3)
    x[0] = x[1] + x[2]

    val array6 = IntArray(5)  // 大小为5，值为0
    val array7 = IntArray(5) { 111 } // 大小为5，值为111
    val array8 = IntArray(5) { it -> it * 2 } // it * 2   ==   it -> it * 2
    val array9 = IntArray(5) { it * 2 }
    array8.forEach { print(it) }
    array9.forEach { print(it) }

}
