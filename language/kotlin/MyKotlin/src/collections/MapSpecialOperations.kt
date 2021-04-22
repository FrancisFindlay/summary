package collections

/**
 * 要从 Map 中检索值，必须提供其键作为 get() 函数的参数。 还支持简写 [key] 语法。 如 果找不到给定的键，则返回 null 。
 * 还有一个函数 getValue() ，它的行为略有不同:如果 在 Map 中找不到键，则抛出异常。
 * 此外，还有两个选项可以解决键缺失的问题:
 * getOrElse() 与 list 的工作方式相同:对于不存在的键，其值由给定的 lambda 表达式返 回。
 * getOrDefault() 如果找不到键，则返回指定的默认值。
 */

fun main() {
    val numbersMap = mapOf("one" to 1, "two" to 2, "three" to 3)
    println(numbersMap.get("one"))
    println(numbersMap["one"])
    println(numbersMap.getOrDefault("four", 10))
    println(numbersMap["five"]) // null //
    // numbersMap.getValue("six") // exception!

    /**
     * 要对 map 的所有键或所有值执行操作，可以从属性 keys 和 values 中相应地检索它们。
     * keys 是 Map 中所有键的集合， values 是 Map 中所有值的集合。
     */

    println(numbersMap.keys)
    println(numbersMap.values)
}