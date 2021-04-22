package collections

/**
 * Slice:
 *  slice() returns a list of the collection elements with given indices.
 *  The indices may be passed either as a range or as a collection of integer values.
 */

/**
 * Chunk:
 */


/**
 * Windowed:
 *
 * step 定义两个相邻窗口的第一个元素之间的距离。默认情况下，该值为 1，因此结果包 含从所有元素开始的窗口。
 * 如果将 step 增加到 2，将只收到以奇数元素开头的窗口:第 一个、第三个等。
 * partialWindows 包含从集合末尾的元素开始的较小的窗口。例如，如果请求三个元素的 窗口，就不能为最后两个元素构建它们。
 * 在本例中，启用 partialWindows 将包括两个大 小为2与1的列表。
 */

fun main() {
    val numbers = listOf("one", "two", "three", "four", "five", "six")
    println(numbers.slice(1..3))
    println(numbers.slice(0..4 step 2)) // as a range
    println(numbers.slice(setOf(3, 5, 0, 0))) // a collection of integer values
    println(numbers.take(3)) // returns a list containing first n elements
    println(numbers.takeLast(3)) // returns a list containing last n elements
    println(numbers.drop(2)) // return a list containing all elements except first n elements
    println(numbers.dropLast(5)) // return a list containing all elements except last n elements
    println(numbers.takeWhile { !it.startsWith('f') }) // 匹配元素，直到不满足谓词
    println(numbers.takeLastWhile { it != "three" })
    println(numbers.dropWhile { it.length == 3 })
    println(numbers.dropLastWhile { it.contains('i') })

    val list = (0..10).toList()
    println(list.chunked(5))
    println(list.chunked(3) { it.sum() })

    println(numbers.windowed(3, step = 1, partialWindows = true))

    /**
     * 最后，可以立即对返回的区间应用转换。 为此，在调用 windowed() 时将转换作为 lambda 函数提供。
     */
    println(list.windowed(3) { it.sum() })

    /**
     * 要构建两个元素的窗口，有一个单独的函数—— zipWithNext() 。
     * 它创建接收器集合的相邻 元素对。 请注意， zipWithNext() 不会将集合分成几对;它为 每个 元素创建除最后一个元素 外的对，因此它在 [1, 2, 3, 4] 上的结果为 [[1, 2], [2, 3], [3, 4]] ，而不是 [[1,2 ]， [3, 4]] 。 zipWithNext() 也可以通过转换函数来调用;它应该以接收者集合的两个元 素作为参数。
     */
    println(numbers.zipWithNext())
    println(numbers.zipWithNext() { s1, s2 -> s1.length > s2.length})


}