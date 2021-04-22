package classAbout

fun baz() {

}

internal var fuckingField = 0

class bbbbb {

}

/**
 * 类、对象、接口、构造函数、方法、属性和它们的 setter 都可以有 可见性修饰符。
 * (getter 总是与属性有着相同的可见性。) 在 Kotlin 中有这四个可见性修饰符: private 、protected 、 internal 和 public 。
 *
 * 如果没有显式指定修饰符的话，默认可见性是 public 。
 */

/**
 * 包:
 *
 * 函数、属性、类、对象和接口都可以在顶部声明，也就是直接在包内。
 *
 * 如果你不指定任何可见性修饰符，默认为 public ，这意味着你的声明将随处可见;
 * 如果你声明为 private ，它只会在声明它的文件内可见;
 * 如果你声明为 internal ，它会在相同模块内随处可见 (module之间不能访问);
 * protected 不适用于顶层声明。
 *
 */


/**
 * 类和接口：
 * private：类内可见
 * protected：类内以及子类可见
 * internal：能见到类声明的模块内任意客户端都可见
 * public：能见到类声明的任意客户端都可见
 * 请注意在 Kotlin 中，外部类不能访问内部类的 private 成员。如果你覆盖一个 protected 成员并且没有显式指定其可见性，该成员还会是 protected 可见性。
 */


open class Outer {
    private val a = 1
    protected open val b = 2
    internal val c = 3
    val d = 4 //默认public

    protected class Nested {
        public val e: Int = 5
    }
}

class Subclass : Outer() { // a 不可见
    // b、c、d 可见
    // Nested 和 e 可见
    override val b = 5 // “b”为 protected
    fun print() {
        // println(super.a) a对子类不可见
    }
}

class Unrelated(o: Outer) {
    // o.a、o.b 不可见
    val o = Outer()
    fun print() {
        println(o.c)
        println(o.d)
    }
    // o.c 和 o.d 可见(相同模块)
    // Outer.Nested 不可见，Nested::e 也不可见
}


fun main() {
    println(fuckingField)
}