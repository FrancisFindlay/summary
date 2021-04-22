package moreLanguageConstructs


/**
 * 把对象解析为其成员属性有时候是非常有用的：
 */

/**
 * 函数参数不能加val 或者var ；
 * 主构造函数的属性， 不加val 或者 var 就不会在对应的java代码中生成对应属性，因此，就不可见。也不会生成对应的get 和 set;
 */


class Person(val name: String, val age: Int) {
    operator fun component1(): Any {
        return name
    }

    operator fun component2(): Any {
        return age
    }

}

fun main() {
    val person = Person("franacis", 10)
    val (name, age) = person
    /**
     * 一个解构声明会被编译成以下代码:
     */
    val nameComp = person.component1()
    val ageComp = person.component2()

    /**
     * 请注意， componentN() 函数需要用 operator 关键字标记，以允许在解构声明中使用它们。 解构声明也可以用在 for -循环中:
     */
    val map = mapOf("key1" to 1, "key2" to 2)
    for ((key, value) in map) {
        println(key + " : " + value)
    }
    /**
     * 从函数返回两个变量：
     * 一个结果对象和一个某种状态。 在 Kotlin 中一个简洁的实现方式是声明一个数据类 并返回其实例:
     * 因为数据类自动声明 componentN() 函数，所以这里可以用解构声明。
     */

    class Status

    data class Result(val result: Int, val status: Status)

    fun function(): Result {
        val result = 0
        val status = Status()
        return Result(result, status)
    }
    val (result, status) = function()

    /**
     * 在lambda中解构：
     */
    map.mapValues { entry -> "${entry.value}" }
    map.mapValues { (key, value) -> "${value}" }
    println(map.mapValues { entry -> "${entry.value}" })
    println(map.mapValues { entry -> "$entry" })
    println(map.mapValues { (key, value) -> "$value" })
}