package basicSyntax

/**
 * if 在Kotlin中是一个表达式，也就是会返回一个值。
**/

/**
 * 使用if作为表达式（返回值或者赋值）需要有else分支
 */

fun main() {
    // 传统用法
    val a = 123
    var b = 234
    var max = a
    if (a < b)
        max = b

    var max1: Int
    if (a > b) {
        max = a
    } else {
        max = b
    }


    // 作为表达式
    val max2 = if (a > b) a else b

    // if的代码块中，最后一行可以作为表达式的值
    val max3 = if (a > b) {
        println("choose a")
        a
    } else {
        println("choose b")
        b
    }
    println(max3)

    val max4 = if (a > b){
        a
    } else {
        b
    }
    println(max4)
}