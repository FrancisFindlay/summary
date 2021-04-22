package classAbout

/**
 * 嵌套类:
 */

class OuterClass {
    private val bar: Int = 1

    class NestedClass {
        fun foo(): Int {
            println(OuterClass().bar) // 访问外部对象必须通过实例
            return 2
        }
    }
}

/**
 * 内部类:
 * 标记为 inner 的嵌套类能够访问其外部类的成员。内部类会带有一个对外部类的对象的引用:
 */

class OuterClassAnother {
    private val bar: Int = 1

    inner class InnerClass {
        fun foo() = bar // 内部类可以直接访问外部属性

    }
}

/**
 * 嵌套类属于类，不属于对象。内部类属于对象，不属于类。
 */

/**
 * Anonymous inner classes: 匿名内部类
 */

interface TestInterFace {
    fun test()
}

class AnonymousClass {
    val v: Int = 1
    fun setTestInterface(test: TestInterFace) {
        test.test()
    }
}




fun main() {
    val nestedDemo = OuterClass.NestedClass().foo()
    // val demo = OuterClass().NestedDemo().foo() 报错，嵌套类属于类，不属于对象。内部类属于对象，不属于类。
    println(nestedDemo)
    val innerDemo = OuterClassAnother().InnerClass().foo()
    println(innerDemo)
    /**
     * 匿名内部类:
     */
    val anonymousDemo = AnonymousClass()
    anonymousDemo.setTestInterface(object : TestInterFace{
        override fun test() {
            println("anon test...")
        }
    })
}