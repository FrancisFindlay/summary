package classAbout

/**
 * 一般地，属性声明为非空类型必须在构造函数中初始化。
 * 然而，这经常不方便。例如:属性 可以通过依赖注入来初始化， 或者在单元测试的 setup 方法中初始化。
 * 这种情况下，你不能 在构造函数内提供一个非空初始器。 但你仍然想在类体中引用该属性时避免空检测。
 * 为处理这种情况，你可以用 lateinit 修饰符标记该属性:
 *
 * 该修饰符只能用于在类体中的属性(不是在主构造函数中声明的 var 属性，并且仅当该属性 没有自定义 getter 或 setter 时)，
 * 而自 Kotlin 1.2 起，也用于顶层属性与局部变量。该属性或 变量必须为非空类型，并且不能是原生类型。
 *
 *
 * 在初始化前访问一个 lateinit 属性会抛出一个特定异常，该异常明确标识该属性被访问及 它没有初始化的事实。
 */


public class MyTest {
    lateinit var subject: String // lateinit 只能用于var
}


fun main() {

    /**
     * by lazy:
     * 必须是val；
     * 首次调用时才会被赋值；
     * 系统会给lazy属性加上同步锁，是线程安全的。
     */
    class Bird(weight: Double, age: Int, val color: String) {
        val sex: String by lazy {
            if (color == "yellow") "male" else "female"
        }
    }

    /**
     * lateinit:
     * 主要用于var,但是不能用于基本类型，如Int;
     */
    class Bird1(weight: Double, age: Int, val color: String) {
        lateinit var sex: String
        fun printSex() {
            sex = if (this.color == "yellow") "male" else "female"
        }
    }

}