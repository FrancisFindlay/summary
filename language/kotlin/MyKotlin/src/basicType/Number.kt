package basicType

/**
 *
 * kotlin有类型推导，对于数字来说，所有没有超过 Int 最大值的整数都会初始化为 Int，如果超过，那么就会初始化为Long。
 *
 * 需要注意的是，kotlin的数字没有隐式转换。例如，对于Double类型的参数，不能把 Int 和 Float 作为参数。
 */

fun printDouble(d: Double) {
    println(d)
}

fun main() {
    val i = 1
    val d = 1.1
    val f = 1.1f
    var str = "Abc"
    str.forEach {
        when(it) {

        }
    }
    printDouble(d)
    // printDouble(i) 错误:类型不匹配
    // printDouble(f) 错误:类型不匹配

    val a: Int = 1
    // val b: Long? = a 错误，没有隐式转换
    val b: Long? = a.toLong()
    val l = 1L + 3 // 算术运算符被重载了，因此可以 Long + Int = Long 这样操作

    // 整数间除法总是返回整数
    val x = 5 / 2
    println("x = $x")

    // 需要返回浮点数，将被除数和除数其中一个转换位浮点数
    val xx = 5 / 2.toDouble()
    println(xx)
    
}