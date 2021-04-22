package collections

/**
 *
 */

fun main() {

    /**
     * 映射：
     */
    val numbers = setOf(1, 2, 3)
    println(numbers.map { it * 3 })
    println(numbers.mapIndexed { idx, value -> value * idx })
    /**
     * 如果转换在某些元素上产生 null 值，
     * 则可以通过调用 mapNotNull() 函数取代 map() 或 mapIndexedNotNull() 取代 mapIndexed() 来从结果集中过滤掉 null 值。
     */
    println(numbers.mapNotNull { if (it == 2) null else it * 3 })
    println(numbers.mapIndexedNotNull { idx, value ->
        if (idx == 0) null else value * idx
    })

    /**
     * map转换时，有两个选择:转换键，使值保持不变，反之亦然。 要将指定转换应用于键，请 使用 mapKeys() ;反过来， mapValues() 转换值。 这两个函数都使用将映射条目作为参数的 转换，因此可以操作其键与值。
     */

    val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key11" to 11)
    println(numbersMap.mapKeys { it.key.toUpperCase() })
    println(numbersMap.mapValues { it.value + it.key.length })

    /**
     * 双路合并:
     * 根据两个集合中具有相同位置的元素构建配对。
     * 在 Kotlin 标准库中，这是通 过 zip() 扩展函数完成的。 在一个集合(或数组)上以另一个集合(或数组)作为参数调 用时，
     * zip() 返回 Pair 对象的列表( List )。 接收者集合的元素是这些配对中的第一个 元素。
     * 如果集合的大小不同，则 zip() 的结果为较小集合的大小;结果中不包含较大集合 的后续元素。 zip() 也可以中缀形式调用 a zip b 。
     */

    val colors = listOf("red", "brown", "grey")
    val animals = listOf("fox", "bear", "wolf")
    println(colors zip animals)
    val twoAnimals = listOf("fox", "bear")
    println(colors.zip(twoAnimals)) // 较小集合的大小

    /**
     * 也可以使用带有两个参数的转换函数来调用 zip() :接收者元素和参数元素。
     * 在这种情况下，结果 List 包含在具有相同位置的接收者对和参数元素对上调用的转换函数的返回值。
     */

    println(colors.zip(animals) { color, animal -> "The ${animal.capitalize()} is $color" }) // capitalize 首字符大写

    /**
     * unzip:
     */

    val numberPairs = listOf("one" to 1, "two" to 2, "three" to 3, "four" to 4)
    println(numberPairs.unzip().first)
    println(numberPairs.unzip().second)

    /**
     * 关联：
     * 关联 转换允许从集合元素和与其关联的某些值构建 Map。 在不同的关联类型中，元素可以是关联 Map 中的键或值。
     * 基本的关联函数 associateWith() 创建一个 Map ，其中原始集合的元素是键，并通过给定的转换函数从中产生值。
     *
     * 如果两个元素相等，则仅 最后一个 保留在 Map 中。
     */


    val number = listOf("one", "two", "three", "four")
    println(number.associateWith { it.length })


    /**
     * 为了使用集合元素作为 值 来构建 Map，有一个函数 associateBy() 。
     * 它需要一个函数，该函 数根据元素的值返回键。如果两个元素相等，则仅最后一个保留在 Map 中。
     * 还可以使用值转 换函数来调用 associateBy() 。
     */

    println(number.associateBy { it.first().toUpperCase() }) // 集合元素为 value， lambda 决定 key
    println(number.associateBy(
            keySelector = { it.first().toUpperCase() },
            valueTransform = { it.length }))


    /**
     * 另一种构建 Map 的方法是使用函数 associate() ，其中 Map 键和值都是通过集合元素生成 的。
     * 它需要一个 lambda 函数，该函数返回 Pair :键和相应 Map 条目的值。
     * 请注意， associate() 会生成临时的 Pair 对象，这可能会影响性能。
     * 因此，当性能不是很关键或比其他选项更可取时，应使用 associate() 。
     */
    data class FullName(val firstName: String, val lastName: String)

    fun parseFullName(fullName: String): FullName {
        val nameParts = fullName.split(" ")
        if (nameParts.size == 2) {
            return FullName(nameParts[0], nameParts[1])
        } else throw Exception("Wrong name format")
    }

    //sampleStart
    val names = listOf("Alice Adams", "Brian Brown", "Clara Campbell")
    println(names.associate {
        name -> parseFullName(name).let { it.lastName to it.firstName }
    })
    //sampleEnd

}