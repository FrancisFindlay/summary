package collections

/**
 * 创建集合的最常用方法是使用标准库函数 listOf<T>() 、 setOf<T>() 、 mutableListOf<T> () 、 mutableSetOf<T>() 。
 * 如果以逗号分隔的集合元素列表作为参数，编译器会自动检测元 素类型。创建空集合时，须明确指定类型。
 */

/**
 * map 的 to 方法是 kotlin 的中缀表示法，但实际上创建了一个 Pair 对象短暂存在。为了避免过多的内存引用，应该在性能不重要的时候使用。
 *
 */

fun main() {
    val list = mutableListOf(1, 2)
    val numberList = listOf(1, 2, 3, 4)
    // 创建空集合必须指定类型
    val nullList = mutableListOf<String>()

    val numberMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key4".to(1)).apply {
    } // key to value 是kotlin的中缀表示法
    // public infix fun <A, B> A.to(that: B): Pair<A, B> = Pair(this, that)
    // to 创建了一个Pair对象，

    val numbersMap = mutableMapOf<String, String>().apply { this["one"] = "1"; this["two"] = "2" }
    numbersMap.apply {
        this["three"] = "3"
    }




}