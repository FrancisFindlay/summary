package collections

/**
 * Iterable<T> 接口的继承者(包括 Set 与 List )可以通过调用 iterator() 函数获得迭代器。
 * 一旦获得迭代器它就指向集合的第一个元素;调用 next() 函数将返回此元素，并将迭代器指向下一个元素(如果下一个元素存在)。
 * 一旦迭代器通过了最后一个元素，它就不能 再用于检索元素;也无法重新指向到以前的任何位置。要再次遍历集合，请创建一个新的迭代器。
 */

/**
 * 对于List有一个特殊的迭代器，ListIterator，它支持双向迭代，反向迭代由 hasPrevious() 和 previous() 来实现。
 * 此外， ListIterator 通过 nextIndex() 与 previousIndex() 函数提供有关元素索引的信息。
 */

/**
 * 为了迭代可变集合，于是有了 MutableIterator 来扩展 Iterator 使其具有元素删除函数 remove() 。
 * 因此，可以在迭代时从集合中删除元素。
 */

fun main() {
    val numbers = listOf("one", "two", "three")
    val numberIterator = numbers.iterator()
    while (numberIterator.hasNext()) {
        print(numberIterator.next())
    }
    println()

    // for 循环会隐式使用迭代器
    for (item in numbers) {
        print(item)
    }
    println()

    /**
     * 最后，有一个好用的 forEach() 函数，可自动迭代集合并为每个元素执行给定的代码:
     */
    numbers.forEach {
        print(it.toUpperCase())
    }
    println()

    /**
     * ListIterator:
     */
    val listIterator = numbers.listIterator()
    while (listIterator.hasNext()) {
        listIterator.next()
    }
    println(listIterator.previousIndex())
    println(listIterator.previous())
    while (listIterator.hasPrevious()) {
        listIterator.previous()
    }
    println(listIterator.nextIndex())
    println(listIterator.next())

    /**
     * 可变迭代器:
     * 可以删除，插入和替换
     */
    val number = mutableListOf("one", "two", "three")
    val mutableIterator = number.iterator()
    while (mutableIterator.hasNext()) {
        mutableIterator.next()
        mutableIterator.remove() // 删除了one，并且指向two
    }

    val list = mutableListOf("one", "two", "three")
    val iterator = list.listIterator()
    iterator.add("insert in head")
    iterator.next()
    iterator.set("insert in head then modify")


}

