package FunctionAndlambda

/**
 * Lambda 表达式或者匿名函数(以及局部函数和对象表达式) 可以访问其 闭包 ，即在外部作用域中声明的变量。
 * 在 lambda 表达式中可以修改闭包中捕获的变量:
 */



fun main() {
    val ints = arrayOf(1, 2, 3)
    var sum = 0
    ints.filter { it > 0 }.forEach {
        sum += it }
    print(sum)
}