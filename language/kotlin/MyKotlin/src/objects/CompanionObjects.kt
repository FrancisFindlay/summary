package objects

/**
 * 伴生对象：
 * 伴生对象的成员可以只通过类名来访问。
 * 一个类只能有一个伴生对象。
 */

private class MyClass {
    companion object Factory {
        fun create() {
            println("out...")
        }
    }

    fun foo() {
        MyClass.Factory.create()
        MyClass.create()
    }

    class Inner {
        companion object {
            fun create() {
                println("inner...")
            }
        }

        fun innerFoo() {
            MyClass.create() // 优先调用外部...
            val x = Inner.Companion.create()
        }
    }
}

/**
 * 可以省略伴生对象的名称，在这种情况下将使用名称 Companion :
 */

/**
 * 请注意，即使伴生对象的成员看起来像其他语言的静态成员，在运行时他们仍然是真实对象的实例成员，而且，例如还可以实现接口:
 *
 *
 */

private interface Factory<T> {
    fun create(): T
}

class MyClassAnother {
    companion object : Factory<MyClassAnother> {
        override fun create(): MyClassAnother {
            return MyClassAnother()
        }
    }
}



fun main() {
    val inner = MyClass.Inner().innerFoo() // 外部的create


}