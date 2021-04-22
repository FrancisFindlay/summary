data class Area(val value: Double)

operator fun Area.plus(that: Area): Area {
    return Area(this.value + that.value)
}

data class User(val name: String, val age: Int)


fun test(): Int {
    return 1
}

fun test1(i: Int) = 1

fun test2(i: Int, unit: (Int) -> Int): Int {
    return unit(i)
}


fun main() {
    println(Area(1.0) + Area(2.0))
    test2(2, ::test1)
}