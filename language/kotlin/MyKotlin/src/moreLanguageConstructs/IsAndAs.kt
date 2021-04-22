package moreLanguageConstructs

/**
 * 类型检测与类型转换: is 与 as :
 */

/**
 * 智能转换：
 */

fun convert(a: Any) {
    if (a is String) {
        println(a.length) // 在这里就可以断言 a 是一个字符串
    }
}

/**
 * 请注意，当编译器不能保证变量在检测和使用之间不可改变时，智能转换不能用。 更具体 地，智能转换能否适用根据以下规则:
 *  val 局部变量——总是可以，局部委托属性除外;
 *  val 属性——如果属性是 private 或 internal，或者该检测在声明属性的同一模块中执行。智能转换不适用于 open 的属性或者具有自定义 getter 的属性;
 *  var 局部变量——如果变量在检测和使用之间没有修改、没有在会修改它的 lambda 中 捕获、并且不是局部委托属性;
 *  var 属性——决不可能(因为该变量可以随时被其他代码修改)。
 */

fun main() {
    val obj = "string"
    if (obj is String) {
        println(obj.length)
    }
    if (obj !is String) {
        println("there is not a string")
    } else
        println(obj.length)

    /**
     * 不安全的类型操作： as
     */
    // val y = null 抛出异常
    val y = 1
    val x: String = y as String
    // val x: String? = y as String 这样就可以接收 null 了

    /**
     * 安全的类型操作：
     */
    val t = null
    val s: String? = t as? String
}