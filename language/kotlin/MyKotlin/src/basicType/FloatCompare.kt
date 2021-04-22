package basicType

fun main() {
    println(1 == 1)
    println(1 === 1)
    println(1.equals(1))
    val x: Int? = 10
    val y: Int? = 10

    // === 比较地址， == 比较值
    println(x == y)
    println(x === y)
    println("=======")
    val f1: Float = 1000.0F
    val f2: Float = 1000.0F
    println(f1 == f2)
    println(f1 === f2)
    println(f1.compareTo(f2))

    val f3: Float = 0F
    val f4: Float = -0F
    println(f3.compareTo(f4)) // 出错，出现了+0比-0大的问题
}