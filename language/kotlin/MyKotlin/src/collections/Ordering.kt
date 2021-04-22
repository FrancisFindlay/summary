package collections

/**
 * 在 Kotlin 中，可以通过多种方式定义对象的顺序。
 * 首先，有 自然 顺序。它是为 Comparable 接口的继承者定义的。 当没有指定其他顺序时，使用自然顺序为它们排序。 大多数内置类型是可比较的:
 * 数值类型使用传统的数值顺序: 1 大于 0 ; -3.4f 大于 -5f ，以此类推。 Char 和 String 使用字典顺序: b 大于 a ; world 大于 hello 。
 * 如需为用户定义的类型定义一个自然顺序，可以让这个类型继承 Comparable 。
 * 这需要实现 compareTo() 函数。 compareTo() 必须将另一个具有相同类型的对象作为参数并返回一个整数值来显示哪个对象更大:
 * 正值表明接收者对象更大, 负值表明它小于参数, 0 说明对象相等。
 */
fun main() {
    class Version(val major: Int, val minor: Int) : Comparable<Version> {
        override fun compareTo(other: Version): Int {
            if (this.major != other.major) {
                return this.major - other.major
            } else if (this.minor != other.minor) {
                return this.minor - other.minor
            } else return 0
        }
    }
    println(Version(1, 2) > Version(1, 3))
    println(Version(2, 0) > Version(1, 5))

    val lengthComparator = Comparator { str1: String, str2: String ->
        str1.length - str2.length
    }
    println(listOf("aaa", "bb", "c").sortedWith(lengthComparator))

    /**
     * 定义一个 Comparator 的一种比较简短的方式是标准库中的 compareBy() 函数。
     * compareBy() 接受一个 lambda 表达式，该表达式从一个实例产生一个 Comparable 值，
     * 并将自定义顺序定义为生成值的自然顺序。 使用 compareBy() ，上面示例中的长度比较器如下所 示:
     */
    println(listOf("aaa", "bb", "c", "C").sortedWith(compareBy({ it.length })))

    /**
     * 自然顺序:
     * 基本的函数 sorted() 和 sortedDescending() 返回集合的元素，这些元素按照其自然顺序升序和降序排序。
     * 这些函数适用于 Comparable 元素的集合。
     */
    val numbers = listOf("one", "two", "three", "four")
    println("Sorted ascending: ${numbers.sorted()}")
    println("Sorted descending: ${numbers.sortedDescending()}")

    /**
     * 自定义排序：
     * 为了按照自定义顺序排序或者对不可比较对象排序，可以使用函数 sortedBy() 和 sortedByDescending() 。
     * 它们接受一个将集合元素映射为 Comparable 值的选择器函数，并以该值的自然顺序对集合排序。
     */

    val sortedNumbers = numbers.sortedBy { it.length }
    println("Sorted by length ascending: $sortedNumbers")
    val sortedByLast = numbers.sortedByDescending { it.last() }
    println("Sorted by the last letter descending: $sortedByLast")

    /**
     * 如需为集合排序定义自定义顺序，可以提供自己的 Comparator 。
     * 为此，调用传入 Comparator 的 sortedWith() 函数。 使用此函数，按照字符串长度排序如下所示:
     */

    println(numbers.sortedWith(compareBy { it.length }))

    /**
     * 倒序：
     */
    println(numbers.reversed()) // 不会原地修改

    /**
     *另一个反向函数 asReversed() :
     * 返回相同集合实例的一个反向视图，因此，如果原始 列表不会发生变化，那么它会比 reversed() 更轻量，更合适。
     *
     */
    println(numbers.asReversed())

    /**
     * 如果原始列表是可变的，那么其所有更改都会反映在其反向视图中，反之亦然。
     * 但是，如果列表的可变性未知或者源根本不是一个列表，那么 reversed() 更合适，因为其 结果是一个未来不会更改的副本。
     */
    val numberS = mutableListOf("one", "two", "three", "four")
    val reversedNumbers = numberS.asReversed()
    println(reversedNumbers)
    numberS.add("five")
    println(reversedNumbers)

    /**
     * 随机顺序:
     *
     */
    println(numbers.shuffled())

}
