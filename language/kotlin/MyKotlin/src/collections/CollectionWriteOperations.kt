package collections

/**
 * 集合写操作：
 */

fun main() {
    /**
     * 取集合的一部分：
     */
    val numbers = mutableListOf<Int>(1, 2, 3, 4, 5)
    println(numbers.subList(0, 4)) // return a view
    numbers.remove(1)
    println(numbers.subList(0, 4)) // return a view

    /**
     * 查找元素：
     * 在任何列表中，都可以使用 indexOf() 或 lastIndexOf() 函数找到元素的位置。
     * 它们返回 与列表中给定参数相等的元素的第一个或最后一个位置。 如果没有这样的元素，则两个函数 均返回 -1 。
     */

    println(numbers.indexOf(2))
    println(numbers.lastIndexOf(2))
    println(numbers.indexOfFirst { it > 2 })
    println(numbers.indexOfLast { it % 2 == 1 })

    /**
     * 二分查找：
     */
    val strs = mutableListOf("one", "two", "three", "four")
    strs.sort()
    println(strs)
    println(strs.binarySearch("two")) // 3
    println(strs.binarySearch("z")) // -5
    println(strs.binarySearch("two", 0, 2)) // -3

    data class Product(val name: String, val price: Double)

    val productList = listOf(
            Product("WebStorm", 49.0),
            Product("AppCode", 99.0),
            Product("DotTrace", 129.0),
            Product("ReSharper", 149.0))
    println(productList
            .binarySearch(Product("AppCode", 99.0),
                    compareBy<Product> { it.price }.thenBy { it.name })
    )

}