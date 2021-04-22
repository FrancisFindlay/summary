package classAbout

/**
 * 派生类的代码可以使用super关键字来实现对父类的函数和属性访问
 *
 * 内部类访问外部类的超类，可以通过外部类名限定的 super@Outer 来实现
 */


open class Rectangle {

    open fun draw() {
        println("父类的draw...")
    }

    val borderColor: String get() = "black" // var 用 get 无法初始化？
}

class FilledRectangle : Rectangle() {
    override fun draw() {
        super.draw()
        println("子类的draw...")
    }

    val fillColor: String get() = super.borderColor

    inner class Filler { // 非静态内部类，如果不使用inner就是静态内部类。
        fun fill() {
            println("inner fill...")
        }
        fun drawAll() {
            super@FilledRectangle.draw() // 调用了父类
            fill()
            println("draw a filled rectangle with color ${super@FilledRectangle.borderColor}")
        }
    }
}


/**
 *
 */

interface Polygon {
    fun draw() { // 接口成员默认 open
    }

    fun another()
}

class Square : Rectangle(), Polygon {
    override fun draw() {
        super<Rectangle>.draw()
        super<Polygon>.draw()
    }
    override fun another() {

    }

}
fun main() {

    val filledRectangle = FilledRectangle()
    filledRectangle.draw()
    println(filledRectangle.fillColor)

    val inner = FilledRectangle().Filler() // 内部类
    inner.drawAll()


    println(fuckingField)

}