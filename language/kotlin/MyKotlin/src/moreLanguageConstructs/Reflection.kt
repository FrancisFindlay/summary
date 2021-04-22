package moreLanguageConstructs

/**
 * https://stackoverflow.com/questions/47400942/what-does-mean-in-kotlin
 */

/**
 * 反射是这样的一组语言和库功能，它允许在运行时自省你的程序的结构。
 * Kotlin 让语言中的 函数和属性做为一等公民、并对其自省(即在运行时获悉一个名称或者一个属性或函数的类 型)与简单地使用函数式或响应式风格紧密相关。
 */

/**
 * 类引用：
 * 最基本的反射功能是获取 Kotlin 类的运行时引用。要获取对静态已知的 Kotlin 类的引用，可 以使用 类字面值 语法:
 * 请注意，Kotlin 类引用与 Java 类引用不同。要获得 Java 类引用， 请在 KClass 实例上使用.java 属性。
 */

val x = 1 // private static final int x = 1

var y = 1

fun main() {
    class MyClass

    val c = MyClass::class
    println(c)

    /**
     * 函数引用：
     */
    fun isOdd(x: Int) = x % 2 != 0

    isOdd(5) // 可以很容易调用这样调用

    /**
     * 可以将其作为一个函数类型的值， 例如将其传给另一个函数。为此，我们使用 :: 操作符:
     * :: 创造一个函数引用或者类引用。
     * 函数引用属于 KFunction<out R> 的子类型之一，取决于参数个数，例如 KFunction3<T1, T2,T3, R> 。
     *
     *
     */
    val number = listOf(1, 2, 3, 4, 5)
    println(number.filter(::isOdd))

    /**
     * 当上下文中已知函数期望的类型时， :: 可以用于重载函数。 例如:
     */

    fun isOdd(s: String) = s == "brillig" || s == "slithy" || s == "tove"

    val numbers = listOf(1, 2, 3)
    println(numbers.filter(::isOdd)) // 引用到 isOdd(x: Int)

    /**
     * 或者，你可以通过将方法引用存储在具有显式指定类型的变量中来提供必要的上下文:
     */
    val predicate: (String) -> Boolean = ::isOdd


    /**
     * 函数组合：
     */
    fun <A, B, C> compose(f: (B) -> C, g: (A) -> B): (A) -> C {
        return { x -> f(g(x)) }
    }

    fun length(s: String) = s.length

    val oddLength = compose(::isOdd, ::length)
    val strings = listOf("a", "ab", "abc")
    println(strings.filter(oddLength))


    /**
     * 属性引用：
     * 要把属性作为 Kotlin中 的一等对象来访问，我们也可以使用 :: 运算符。
     * 表达式 ::x 求值为 KProperty<Int> 类型的属性对象，它允许我们使用 get() 读取它的 值，
     * 或者使用 name 属性来获取属性名。更多信息请参见关于 KProperty 类的文档
     *
     * 对于可变属性，例如 var y = 1 ， ::y 返回 KMutableProperty<Int> 类型的一个值， 该类型 有一个 set() 方法。
     */

    println(::x.get())
    println(::x.name)

    println(::y.set(2))
    println(y)

    /**
     * 属性引用可以用在预期具有单个泛型参数的函数的地方:
     */

    val strs = listOf("a", "bc", "def")
    println(strs.map(String::length))


    /**
     * 要访问属于类的成员的属性，我们这样限定它:
     */
    class A(val p: Int)
    val prop = A::p // 属于对象的属性
    println(prop.get(A(1)))


    /**
     * inner:
     */
    class Outer {
        inner class Inner
    }
    val o = Outer()
    val bound = o::Inner
    val b = bound()


    /**
     * :: 还可以用作构造函数的方法引用：
     */

    class Book(val name: String)
    val getBook = ::Book // getBook 的类型是 (name: String) -> Book
    println(getBook("dive into kotlin").name)
    val bookNames = listOf(
            Book("thinking in java"),
            Book("dive into kotlin")
    ).map(Book::name) // Book:name 的类型是 (Book) -> String
    println(bookNames)


}