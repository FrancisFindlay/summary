package collections

/**
 * 无论键值对的顺序如何，包含相同键值对的两个 Map 是相等的。
 *
 * Map 的默认实现 – LinkedHashMap – 迭代 Map 时保留元素插入的顺序。 反之，另一种实现 – HashMap – 不声明元素的顺序。
 */

fun main() {

    //sampleStart
    val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key4" to 1)
    println("All keys: ${numbersMap.keys}")
    println("All values: ${numbersMap.values}")
    if ("key2" in numbersMap)
        println("Value by key \"key2\": ${numbersMap["key2"]}")
    if (1 in numbersMap.values)
        println("The value 1 is in the map")
    if (numbersMap.containsValue(1))
        println("The value 1 is in the map")
    // 同上 //sampleEnd

    //sampleStart
    val numbersMap2 = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key4" to 1)
    val anotherMap = mapOf("key2" to 2, "key1" to 1, "key4" to 1, "key3" to 3)
    println("The maps are equal: ${numbersMap2 == anotherMap}")
    //sampleEnd


    //sampleStart
    val numbersMap3 = mutableMapOf("one" to 1, "two" to 2)
    numbersMap3.put("three", 3)
    numbersMap3["one"] = 11
    println(numbersMap3)
    //sampleEnd




}