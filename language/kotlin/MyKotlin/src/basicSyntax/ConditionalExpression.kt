package basicSyntax

fun max(a: Int, b: Int) : Int {
    if (a > b) {
        return a
    }
    return b
}

/*
 Kotlin中，if可以用作表达式
 */

fun max1(a: Int, b: Int) : Int = if (a > b) a else b

fun main() {
    println("max of 0 and 5 is ${max(0, 5)}")
    println("max of 0 and 5 is ${max1(0, 5)}")
}
