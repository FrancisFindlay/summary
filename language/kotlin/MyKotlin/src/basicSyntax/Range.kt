package basicSyntax

/*
 使用in运算符来检测某个值是否在给定区间内
 */

fun main() {
    val x = 10
    val y = 9
    if (x in 1..y + 1) { // a .. b 表示[a, b]
        println("$x fits in range")
    }

    // 检测某个数字是否在区间之外
    val list = listOf<String>("a", "b", "")
    if (-1 !in list.indices) {
        println("-1 is out of range")
    }
    if (list.size !in list.indices) {
        println("list size is out of range")
    }

    //区间迭代
    for (x in 1..5) {
        println("$x, ")
    }

    //数列迭代
    for (x in 1..10 step 2) {
        println("$x, ")
    }
    for (x in 9 downTo 0 step 3) { // 递减到0，步长为-3
        println("$x, ")
    }


}