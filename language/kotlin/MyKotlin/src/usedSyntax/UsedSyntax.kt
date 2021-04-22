package usedSyntax

import java.io.File

/*
创建一个DTOs：
kotlin会为Customer类提供所有属性的get、set方法，equals、hashcode、toString，copy方法;
 */
data class Customer(val name: String, val email: String)

/*
函数设置默认参数
 */
fun foo(a: Int = 0, b: String = "") {

}

fun main() {
    // 过滤list
    val items = listOf(-1, 0, 1, 2, 3)
    val positives = items.filter { x -> x > 0 } // 新创建了一个列表
    println(positives)
    println(items)
    // 更简洁的写法
    val positives2 = items.filter { it > 0 }
    println(positives2)

    // 检测元素是否在集合中
    val list = listOf<String>("apple", "orange")
    if ("apple" in list) {
        println("i have an apple")
    }

    // 字符串内插
    val name = "hfz"
    println("name: $name")
    var x = 1

    //类型判断
    when (x) {
        is Int -> println("x is Int")
        2 -> println("x is 2")
        else -> println("nothing...")
    }

    //遍历map/pair型list
    val map = mapOf("apple" to 1, "orange" to 10)
    for ((k, v) in map) {
        println("$k -> $v")
    }

    //使用区间
    for (i in 1..100) {
        //println(i)
    }

    for (i in 1..100 step 2) {
        //println(i)
    }

    for (i in 1 until 100) { // 左闭右开，不包括100
        println(i)
    }

    for (i in 100 downTo 10 step 10) { // 包含10
        println(i)
    }

    // 访问map
    println(map["apple"])
    println(map.get("apple"))

    /*
     延迟属性
     lazy用于val
     lateinit用于var

     */
    val p: String by lazy {

        println("lazy...")
        println("lazy again...")
        println("lazy again again...")
        "Hello"
    }

    println(p)
    println(p)

    // 扩展函数

    // 创建单例
    /*
    object Resource {
        val name = "Name"
    }
    */

    // if not null 的缩写
    val files = File("Test").listFiles()
    println(files?.size) // if file !is null

    // if not null and else 的缩写
    println(files?.size ?: "empty")

    // 取可能为空的集合的第一个元素
    var emails = emptyList<Any>()
    // emails += 1
    val main = emails.firstOrNull() ?: "empty...."
    println(main)

    // 返回when表达式
    println(transform("Red"))

    // if 表达式
    println(foo(1))

    // with
    val myTurtle = Turtle()
    with(myTurtle) {
        penDown()
        penUp()
    }

    // also 交换两个值
    var a = 1
    var b = 2
    a = b.also { b = a } // also 返回调用对象
    print("a = $a, b = $b")


    // TODO


}

/*
返回when表达式
 */

fun transform(color: String): Int {
    return when (color) {
        "Red" -> 0
        "Green" -> 1
        "Blue" -> 2
        else -> throw IllegalArgumentException("Invalid color parm valiue")
    }
}

/*
try/catch 表达式
 */

fun test() {
    val result = try {
        //count()
    } catch (e: ArithmeticException) {
        throw IllegalArgumentException(e)
    }
}

/*
 if 表达式
 */

fun foo(param: Int): String {
    val result = if (param == 1) {
        "one"
    } else if (param == 2) {
        "two"
    } else {
        "three"
    }
    return result
}

/*
返回类型为Unit的Builder风格用法
 */

/*
单表达式函数
 */

fun theAnswer() = 5

/*
对一个对象实例调用多个方法 （with）
 */

class Turtle {
    fun penDown() {}
    fun penUp() {}
    fun turn(depress: Double) {}
    fun forward(pixels: Double) {}
    

}