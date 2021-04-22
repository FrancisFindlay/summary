package basicSyntax


/*
    顶层变量
*/
val PI = 3.14
var t = 0

fun incrementX() {
    t += 1
}




fun main() {

/*
    定义只读局部变量使用val，只能赋值一次。
*/
    val a: Int = 1 // 立即赋值
    val b = 2 // 自动推导为Int类型
    val c: Int // 如果没有初始值不能省略类型
    c = 3 // 显式赋值


/*
可以重新赋值的使用var
*/
    var x = 5
    x += 1
    println("x = ${x}")

    println("t = ${t}, PI = ${PI}")
    incrementX()
    println("t = ${t}, PI = ${PI}")

}