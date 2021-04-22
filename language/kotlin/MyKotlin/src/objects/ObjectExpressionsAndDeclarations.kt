package objects

/**
 * 有时候，我们需要创建一个对某个类做了轻微改动的类的对象，而不用为之显式声明新的子类。 Kotlin 用对象表达式和对象声明处理这种情况。
 */

private open class A(x: Int) {
    public open val y: Int = x
}

interface B {

}

private val ab: A = object : A(1), B {
    override val y: Int = 30
}

/**
 * 匿名对象：
 *
 * 任何时候，如果我们只需要“一个对象而已”，并不需要特殊超类型，那么我们可以简单地写:
 */

private fun foo() {
    val adHoc = object {
        var x: Int = 1
        var y: Int = 2
    }
    println(adHoc.x)
    println(adHoc.y)
}

/**
 * 使用匿名对象作为 公有函数的返回类型或者用作公有属性的类型，那么该函数或属性的实际类型会是匿名对象声明的超类型，
 * 如果你没有声明任何超类型，就会是 Any , 在匿名对象中添加的成员将无法访问。
 */

private class C {



    companion object Static {
        val staticNum = 1
    }

    // 私有函数，返回匿名对象的类型
    private fun foo() = object {
        val x: String = "x"
    }

    // 公有函数，返回Any
    fun publicFoo() = object {
        val x: String = "x"

    }

    fun bar() {
        val x1 = foo().x
        // val x2 = publicFoo().x 错误，不能解析
    }
}

/**
 * 对象声明：总是在 object 关键字后跟一个名称。 就像变量声明一样，对象声明不是一个表达式，不能用在赋值语句的右边。
 * 对象声明的初始化过程是线程安全的并且在首次访问时进行。
 * 如需引用该对象，我们直接使用其名称即可:
 *
 * 这些对象可以有超类型。
 *
 * 注意:对象声明不能在局部作用域(即直接嵌套在函数内部)，但是它们可以嵌套到其他对象声明或非内部类中。
 *
 * 实现单例。
 */

open class TempClass {
    open fun f() {}
}

object DataProviderManager : TempClass() {

    object innerData {

    }


    fun registerDataProvider() {
        DataProviderManager.allDataProviders
    }

    val allDataProviders: Collection<Int>
        get() = ArrayList()

    override fun f() {
    }

}

/**
 * 对象表达式和对象声明的区别：
 * 对象表达式是在使用他们的地方立即执行(及初始化)的;
 * 对象声明是在第一次被访问到时延迟初始化的;
 * 伴生对象的初始化是在相应的类被加载(解析)时，与 Java 静态初始化器的语义相匹配。
 */

fun main() {

}