package classAbout

/**
 * 内联类：
 * 内联类必须含有唯一的一个 val 修饰的属性在主构造函数中初始化。在运行时，将使用这个唯一属性来 表示内联类的实例。
 *
 * https://kotlinexpertise.com/kotlin-inline-classes/
 *
 */

private inline class Password(val value: String)

private val securePassword = Password("Don't try this...") // 不存在 password 类的真实实例对象。运行时，securePassword只包括"string"

inline class Name(val name: String) {
    val length: Int
        get() = name.length

    fun greet() {
        println("Hello, $name")
    }
}

/**
 * 内联函数的限制：
 * 内联类不能有 init 代码块
 * 内联类不能有幕后字段，因此，内联类只能含有简单的计算属性(不能含有延迟初始化/委托属性)。
 */

/**
 * 继承：
 * 内联类允许去继承接口,但是不能继承类。
 * 禁止内联类参与到类的继承关系结构中。这就意味着内联类不能继承其他的类而且必须是 final 。
 *
 */

interface Printable {
    fun prettyPrint(): String
}


inline class NameAnother(val s: String) : Printable { // 默认为final
    override fun prettyPrint(): String {
        return "Let's go, $s!"
    }
}

/**
 * 内联类的表示方式：
 * 在生成的代码中，Kotlin 编译器为每个内联类保留一个包装器。内联类的实例可以在运行时表 示为包装器或者基础类型。这就类似于 Int 可以表示为原生类型 int 或者包装器Integer 。
 * 为了生成性能最优的代码，Kotlin 编译更倾向于使用基础类型而不是包装器。 然而，有时候使用包装器是必要的。一般来说，只要将内联类用作另一种类型，它们就会被装箱。
 */

interface I

inline class Foo(val i: Int) : I

fun asInline(f: Foo) {}

fun <T> asGeneric(x: T) {}

fun asInterface(i: I) {}

fun Nullable(i: Foo?) {}

fun <T> id(x: T): T = x

/**
 * 名字修饰：
 * 由于内联类被编译为其基础类型，因此可能会导致各种模糊的错误，例如意想不到的平台签名冲突：
 */

inline class UInt(val t: Int) {
    fun compute(t: Int) {} // 在 JVM 平台上被表示为'public final void compute(int x)'

    fun compute(x: UInt) {} // 在 JVM 平台上被表示为'public final void compute(int x)'
}

/**
 * 内联类和类型别名：初看起来，内联类似乎与类型别名非常相似。实际上，两者似乎都引入了一种新的类型，并且都在运行时表示为基础类型。、
 *
 * 然而，关键的区别在于类型别名与其基础类型(以及具有相同基础类型的其他类型别名)是 赋 值兼容 的，而内联类却不是这样。
 * 换句话说，内联类引入了一个真实的新类型，与类型别名正好相反，类型别名仅仅是为现有 的类型取了个新的替代名称(别名):
 */


typealias NameTypeAlias = String

inline class NameInlineClass(val s: String)

fun acceptString(s: String) {}
fun acceptNameTypeAlias(n: NameTypeAlias) {}
fun acceptNameInlineClass(p: NameInlineClass) {}


fun main() {
    val name = Name("Kotlin")
    name.greet() // greet()作为静态函数
    println(name.length) // 属性的get()也作为静态属性

    val nameAnother = NameAnother("Kotlin")
    nameAnother.prettyPrint() // 仍然作为一个静态函数

    println("=====")
    val f = Foo(42)
    println(f.javaClass)
    asInline(f) // 拆箱，foo本身
    asGeneric(f)
    asInterface(f)
    Nullable(f)
    val c = id(f) // 经过了一次装箱，一次拆箱。

    val nameAlias: NameTypeAlias = ""
    val nameInlineClass: NameInlineClass = NameInlineClass("")
    val string: String = ""
    acceptString(nameAlias) // 正确: 传递别名类型的实参替代函数中基础类型的形参
    // acceptString(nameInlineClass) // 错误: 不能传递内联类的实参替代函数中基础类型的形参
    // And vice versa:
    acceptNameTypeAlias(string) // 正确: 传递基础类型的实参替代函数中别名类型的形参
    // acceptNameInlineClass(string) // 错误: 不能传递基础类型的实参替代函数中内联类类型的形参


}