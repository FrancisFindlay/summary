package collections

/**
 * 当 Iterable 的处理包含多个步骤时，它们会优先执行:每个处理步骤完成并返回其结果 ——中间集合。
 * 在此集合上执行以下步骤。反过来，序列的多步处理在可能的情况下会延迟 执行:仅当请求整个处理链的结果时才进行实际计算。
 * 操作执行的顺序也不同: Sequence 对每个元素逐个执行所有处理步骤。 反过来， Iterable 完成整个集合的每个步骤，然后进行下一步。
 * 因此，这些序列可避免生成中间步骤的结果，从而提高了整个集合处理链的性能。
 * 但是，序列的延迟性质增加了一些开销，这些开销在处理较小的集合或进行更简单的计算时可能很重要。 因此，应该同时考虑使用 Sequence 与 Iterable ，并确定在哪种情况更适合。
 */

fun main() {
    /**
     * 构造序列：
     */
    val numberSequence = sequenceOf("one", "two", "three", "four")

    // 如果已经有了List或者Set：
    val list = listOf("one", "Two", "three")
    val numberFromIterator = list.asSequence()

    // 可以通过函数构造：
    val oddNumbers = generateSequence(1) { it + 2 } // it是上一个元素，当提供的函数返回null时，序列停止生成
    println(oddNumbers.take(5).toList())

    // 通过generateSequence()创建有限序列时，需要提供一个函数。该函数在需要的最后一个元素 之后返回 null 。
    val oddNumList = generateSequence(1) { if (it < 10) it + 2 else null }
    println(oddNumList.count())

    /**
     *  chunks
     */
    val oddNums = sequence {
        yield(1)
        yieldAll(listOf(3, 5))
        yieldAll(generateSequence(7) { it + 2 }) // 必须放在最后一个，否则上面的两个yield不会执行。
    }
    println(oddNums.take(5).toList())

    /**
     * Sequence 和 Iterator 的区别：
     */

    // iterator:
    val words = "The quick brown fox jumps over the lazy dog".split(" ")
    val lengthsList = words
            .filter { println("filter: $it"); it.length > 3 }
            .map { println("length: ${it.length}"); it.length } // map 将 list 映射为另一个 list
            .take(4)
    println("Lengths of first 4 words longer than 3 chars:")
    println(lengthsList)

    // 现在用 sequence 写相同的逻辑：
    val wordsSequence = words.asSequence()

    val lengthsSequence = wordsSequence
            .filter { println("filter: $it"); it.length > 3 }
            .map { println("length: ${it.length}"); it.length }
            .take(4)
    println("Lengths of first 4 words longer than 3 chars") // 末端操作:以列表形式获取结果。
    println(lengthsSequence.toList())

    /**
     * 此代码的输出表明，仅在构建结果列表时才调用 filter() 与 map() 函数。
     * 因此，首先看 到文本 “Lengths of..” 的行，然后开始进行序列处理。
     * 请注意，对于过滤后剩余的元素， 映射在过滤下一个元素之前执行。
     * 当结果大小达到 4 时，处理将停止，因为它是 take(4) 可以返回的最大大小。
     */

    /**
     * sequence 需要18个操作，Iterator 须需要 23 个操作。
     * 因此。sequence 是更高效的方式。
     */

    val numList = listOf<Int>(1, 2, 3 ,4 ,5 )
    numList.filter { it > 2 } // 不在原来list修改
    println(numList)

}