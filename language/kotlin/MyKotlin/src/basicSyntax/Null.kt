package basicSyntax

/*
 某个变量值可以为null，必须在声明处的类型后添加？来表示该引用可以为空。
 如果str不为数字返回null

 fun parseInt(str: String) : Int? {
    //...
}

 */

fun parseInt(str: String) : Int? {
    return str.toIntOrNull()
}

fun printProduct(arg1: String, arg2: String) {
    val x = parseInt(arg1)
    val y = parseInt(arg2)
    if (x != null && y != null) {
        println(x * y)
    } else {
        println("'$arg1' or '$arg2' is not a number")
    }

}


fun main() {
    printProduct("6", "7")
    printProduct("a", "7")
}