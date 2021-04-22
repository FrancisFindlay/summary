package classAbout

/**
 * 如果你需要写一个可以无需用一个类的实例来调用、但需要访问类内部的函数(例如，工厂方法)，你可以把它写成该类内对象声明中的一员。
 * 更具体地讲，如果在你的类内声明了一个伴生对象， 你就可以访问其成员，只是以类名作为 限定符。
 *
 * 也就是说，伴生对象中的属性和方法绑定在类上，而不是对象上。
 */

private class Companion {

    val x = 1

    companion object Factory {
        val y = 2
    }
}

fun main() {
    Companion.y

    val c = Companion()
    print(c.x) // 无法访问到y
    
}