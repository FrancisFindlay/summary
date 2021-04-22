package moreLanguageConstructs

/**
 * Kotlin 中有两种类型的相等性:
 * 结构相等(用 equals() 检测) == ;
 * 引用相等(两个引用指向同一对象) === ;
 * 也就是说如果 a 不是 null 则调用 equals(Any?) 函数，否则(即 a 是 null )检测 b 是否与 null 引用相等。
 * 请注意，当与 null 显式比较时完全没必要优化你的代码: a == null 会被自动转换为 a === null 。
 */

fun main() {
    /**
     * 结构相等：
     * a == b 会被翻译为,
     * a?.equals(b) ?: (b === null)
     */

    /**
     * 浮点相等: 遵循 IEEE754;
     */


    val a = 1
    println(+a)
    println(a)

}