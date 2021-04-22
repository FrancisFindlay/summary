package moreLanguageConstructs


/**
 * 安全调用符 ？.
 */

fun main() {
    val a = "Kotlin"
    val b: String? = "Kotlin"
    // println(b.length) 编译错误
    println(b?.length)
    println(a.length)

    /**
     * 安全调用也可以出现在赋值的左侧。这样，如果调用链中的任何一个接收者为空都会跳过赋值，而右侧的表达式根本不会求值:
     */
    class person() {
        inner class i(var x: Int) {
        }
    }
    val p = person()
    p?.i(1)?.x = a.toInt() // 如果调用链任何一个接受者为 null， 右侧表达式不会调用


}