package collections

/**
 * 过滤是最常用的集合处理任务之一。
 * 在Kotlin中，过滤条件由 谓词 定义——接受一个集合元素并且返回布尔值的 lambda 表达式: true 说明给定元素与谓词匹配， false 则表示不匹配。
 * 标准库包含了一组让你能够通过单个调用就可以过滤集合的扩展函数。
 * 这些函数不会改变原始集合，因此它们既可用于可变集合也可用于只读集合。为了操作过滤结果，应该在过滤后将其赋值给变量或链接其他函数。
 */

fun main() {
    val numbers = listOf("one", "two", "three", "four")
    val longerThan3 = numbers.filter { it.length > 3 }
    println(longerThan3)
    val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key11" to 11)
    val filteredMap = numbersMap
            .filter { (key, value) ->
                key.endsWith("1") && value > 10
            }
    println(filteredMap)

    /**
     * filter() 中的谓词只能检查元素的值。如果想在过滤中使用元素在集合中的位置，应该使用 filterIndexed() 。
     * 它接受一个带有两个参数的谓词:元素的索引和元素的值。
     */

    /**
     * 如果想使用否定条件来过滤集合，请使用 filterNot() 。它返回一个让谓词产生 false 的元 素列表。
     */


    val filteredIdx = numbers
            .filterIndexed { index, s ->
                (index != 0) && (s.length < 5)
            }
    val filteredNot = numbers.filterNot { it.length <= 3 }
    println(filteredIdx)
    println(filteredNot)

    /**
     * filterIsInstance()
     */
    val list = listOf(null, 1, "two", 3.0, "four")
    println("All String elements in upper case:")
    list.filterIsInstance<String>()
            .forEach {
                println(it.toUpperCase())
            }

    /**
     * filterNotNull() 返回所有的非空元素。在一个 List<T?> 上被调用时，
     * filterNotNull() 返回一个 List<T: Any> ，从而让你能够将所有元素视为非空对 象。
     */

    list.filterNotNull()
            .forEach {
                println(it)
            }
    
}