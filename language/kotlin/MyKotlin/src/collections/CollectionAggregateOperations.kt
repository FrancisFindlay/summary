package collections

/**
 * 集合聚合操作：
 * Kotlin 集合包含用于常用的 聚合操作 (基于集合内容返回单个值的操作)的函数 。 其中大多 数是众所周知的，并且其工作方式与在其他语言中相同。
 */

fun main() {
    val numbers = listOf(6, 10, 42, 3)
    println("Count: ${numbers.count()}")
    println("Max: ${numbers.max()}")
    println("Min: ${numbers.min()}")
    println("Average: ${numbers.average()}")
    println("Sum: ${numbers.sum()}")

    /**
     * 还有一些通过某些选择器函数或自定义 Comparator 来检索最小和最大元素的函数。
     */
    val min3Remainder = numbers.minBy { it % 100 } // 对list中每个element都执行 predicate, 形成一个新 list ，返回新 list 的min
    println(min3Remainder)
    val strings = listOf("one", "two", "three", "four")
    val longestString = strings.maxWith(compareBy { it.length })
    println(longestString)
    println(numbers.sumBy { it * 2 })
    println(numbers.sumByDouble { it.toDouble() / 2 })

    /**
     * fold() and reduce():
     *
     * 这两个函数的区别在于: fold() 接受一个初始值并将其用作第一步的累积值，而 reduce() 的第一步则将第一个和第二个元素作为第一步的操作参数。
     */
    val sum = numbers.reduce { sum, element -> sum + element }
    println(sum)

    val sumDoubled = numbers.fold(0) { sum, element -> sum + element * 2 } // 122
    println(sumDoubled)
    val sumDoubledReduce = numbers.reduce { sum, element -> sum + element * 2 } //错 误:第一个元素在结果中没有加倍 116
    println(sumDoubledReduce)

    /**
     * 如需将函数以相反的顺序应用于元素，可以使用函数 reduceRight() 和 foldRight() 它们的 工作方式类似于 fold() 和 reduce() ，
     * 但从最后一个元素开始，然后再继续到前一个元素。
     *
     * 记住，在使用 foldRight 或 reduceRight 时，操作参数会更改其顺序:第一个参数变为元素， 然后第二个参数变为累积值。
     */

    // 6 10 42 3
    val sumDoubledRight = numbers.foldRight(0) { element, sum -> sum + element * 2 } // element 和 sum
    println(sumDoubledRight)
    val sumDoubledLeft = numbers.reduceRight { element, sum -> element * 2 + sum }
    println(sumDoubledLeft)

    /**
     * 你还可以使用将元素索引作为参数的操作。 为此，使用函数 reduceIndexed() 和 foldIndexed() 传递元素索引作为操作的第一个参数。
     *
     * 最后，还有将这些操作从右到左应用于集合元素的函数—— reduceRightIndexed() 与 foldRightIndexed() 。
     */
    val sumEven = numbers.foldIndexed(0) { idx, sum, element -> if (idx % 2 == 0) sum + element else sum }
    println(sumEven)
    val sumEvenRight = numbers.foldRightIndexed(0) { idx, element, sum -> if (idx % 2 == 0) sum + element else sum }
    println(sumEvenRight)

}