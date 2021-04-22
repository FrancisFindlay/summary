package moreLanguageConstructs

import basicSyntax.parseInt
import java.lang.Exception
import kotlin.NumberFormatException

/**
 * Kotlin 中所有异常类都是 Throwable 类的子孙类。 每个异常都有消息、堆栈回溯信息以及可 选的原因。
 */

/**
 * 可以有零到多个 catch 块。 finally 块可以省略。 但是 catch 与 finally 块至少应该存 在一个。
 */

/**
 * Try 是一个表达式, 即它可以有一个返回值:
 * try -表达式的返回值是 try 块中的最后一个表达式或者是(所有) catch 块中的最后一个 表达式。 finally 块中的内容不会影响表达式的结果。
 */

fun main() {
    val input = "123"
    val a: Int? = try {
        parseInt(input)
    } catch (e: NumberFormatException) {
        null
    } finally {
        4
    }
    println(a)

    /**
     * nothing:
     * 在 Kotlin 中 throw 是表达式，所以你可以使用它(比如)作为 Elvis 表达式的一部分:
     *
     * throw 表达式的类型是特殊类型 Nothing 。 该类型没有值，而是用于标记永远不能达到的 代码位置。
     * 在你自己的代码中，你可以使用 Nothing 来标记一个永远不会返回的函数:
     */
    class Person() {
        val name: String? = "hello"
    }
    val person = Person()
    val s = person.name ?: throw IllegalArgumentException("Name required")
}