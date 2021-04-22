package basicSyntax

fun sum(x: Int, y: Int) : Int {
    return x + y
}

/*
 将表达式作为函数体
 */
fun sum1(a: Int, b: Int) = a + b

/*
 函数返回无意义的值
 Unit:和void类似，但Unit是一个类型
 Unit返回类型可以省略
 */
fun sum2(a: Int, b: Int) : Unit {
    print("sum of ${a} and ${b} is ${a + b}")
}

fun sum3(a: Int, b: Int) {
    print("sum of ${a} and ${b} is ${a + b}")
}

fun main() {
    print("sum of 3 and 5 is : ")
    println(sum(3, 5))
    println("sum of 19 and 25 is ${sum1(19, 25)}") // ${}
    sum2(10, 30)
}