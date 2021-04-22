package basicType


/**
 * 对于位运算，没有特殊字符表示，只可以用中缀方法调用
 * shl 有符号左移
 * shr 有符号右移
 * ushr 无符号右移
 * and 与
 * or 或
 * xor 异或
 * inv 非
 */

fun main() {
    val x = -1 ushr 1
    println(x)
}