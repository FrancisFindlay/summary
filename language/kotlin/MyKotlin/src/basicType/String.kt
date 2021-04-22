package basicType

import classAbout.fuckingField

/**
 * 字符串不可变性,可以使用索引访问字符
 */

fun main() {
    val str = "hello"
    println(str[1])

    for (c in str) {
        print(c)
    }

    println()

    str.forEach { print(it) }

    println()

    // 可以使用 + 连接字符串，只要表达式第一个类型是字符串
    // val s = 1 + "abc" 报错
    val ss = "abc" + 1
    println(ss)


    // 字符串字面值
    val str1 = "Hello, world!\n"
    val str2 = """
        for (c in "foo")
            print(c)
    """
    val str3 = """
        for (c in "foo") {
            print(c)
    """.trimIndent() // trimIndent() 去除前面的空格

    println(str2)

    val text = """
        |Tell me and i forget
        |Teach me and i remember
    """.trimMargin()
    println(text)

    // 字符串模板，如果需要表示 $9.99
    val price = """
        ${'$'}9.99
        
        $9.99
    """.trimIndent()
    println(price)

}