package FunctionAndlambda

import java.awt.Point
import kotlin.math.abs
import kotlin.math.cos

/**
 * 尾递归函数：
 * Kotlin 支持一种称为尾递归的函数式编程风格。
 * 这允许一些通常用循环写的算法改用递归函 数来写，而无堆栈溢出的风险。
 * 当一个函数用 tailrec 修饰符标记并满足所需的形式时，编 译器会优化该递归，留下一个快速而高效的基于循环的版本:
 *
 * 符合 tailrec 修饰符的条件的话，函数必须将其自身调用作为它执行的最后一个操作。
 * 在 递归调用后有更多代码时，不能使用尾递归，并且不能用在 try/catch/finally 块中。
 * 目前在 Kotlin for JVM 与 Kotlin/Native 中支持尾递归。
 */

val eps = 1E-10

tailrec fun find(x: Double = 1.0): Double
        = if (abs(x - cos(x)) < eps) x else find(cos(x))


tailrec fun findJava(x: Double = 1.0): Double
        = if (Math.abs(x - Math.cos(x)) < eps) x else findJava(Math.cos(x))


fun main() {
    println(find())
    println(findJava())
}