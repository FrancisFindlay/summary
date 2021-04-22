package delegation

import classAbout.Foo
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/**
 * 属性委托:
 * 委托模式已经证明是实现继承的一个很好的替代方式， 而 Kotlin 可以零样板代码地原生支持它。
 *
 * the compiler will generate all the methods of Base that forward to b.
 */
interface Base {
    fun printMessage()
    fun printMessageLine()
}

class BaseImpl(val x: Int) : Base {
    override fun printMessage() {
        print(x)
    }

    override fun printMessageLine() {
        println(x)
    }
}

class Derived(b: Base) : Base by b {
    override fun printMessage() {
        print("abc")
    }

    val x = 1 // b访问不到 x
}


/**
 * 覆盖委托的父类函数:
 *
 * 但请注意，以这种方式重写的成员不会在委托对象的成员中调用 ，委托对象的成员只能访问 其自身对接口成员实现:
 */


/**
 * 委托属性：
 * 有一些常见的属性类型，虽然我们可以在每次需要的时候手动实现它们， 但是如果能够把他们只实现一次并放入一个库会更好。例如包括:
 * 延迟属性(lazy properties): 其值只在首次访问时计算;
 * 可观察属性(observable properties): 监听器会收到有关此属性变更的通知;
 * 把多个属性储存在一个映射(map)中，而不是每个存在单独的字段中。
 *
 * 语法是: val/var <属性名>: <类型> by <表达式> 。在 by 后面的表达式是该 委托， 因为属性 对应的 get() (与 set() )会被委托给它的 getValue() 与 setValue() 方法。
 * 属性的委 托不必实现任何的接口，但是需要提供一个 getValue() 函数(与 setValue() ——对于var 属性)。 例如:
 *
 *  当我们从委托到一个 Delegate 实例的 p 读取时，将调用 Delegate 中的 getValue() 函 数，
 *  所以它第一个参数是读出 p 的对象、第二个参数保存了对 p 自身的描述 (例如你可 以取它的名字)。 例如:
 *
 *
 *  类似地，当我们给 p 赋值时，将调用 setValue() 函数。前两个参数相同，第三个参数保存 将要被赋予的值:
 */

class Delegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name}' in $thisRef.")
    }
}

class Example {
    var p: String by Delegate()
}

/**
 * 延迟委托：
 *
 */


val lazyValue: String by lazy {
    println("computed!")
    "Hello"
}


/**
 * 可观察委托：
 *
 */

class User {
    var name: String by Delegates.observable("<no name>") { prop, old, new ->
        println("$old -> $new")
    }
}

/**
 * 把属性储存在映射中:
 *
 * 一个常见的用例是在一个映射(map)里存储属性的值。
 * 这经常出现在像解析 JSON 或者做 其他“动态”事情的应用中。 在这种情况下，你可以使用映射实例自身作为委托来实现委托属 性。
 */

class UserAnother(val map: Map<String, Any?>) {
    val name: String by map
    val age: Int by map
}


/**
 * 局部委托属性：
 *
 */


/**
 * 委托属性的要求：
 *
对于一个只读属性(即 val 声明的)，委托必须提供一个操作符函数 getValue() ，该函数 具有以下参数:

thisRef —— 必须与 属性所有者 类型(对于扩展属性——指被扩展的类型)相同或者 是其超类型。
property —— 必须是类型 KProperty<*> 或其超类型。 getValue() 必须返回与属性相同的类型(或其子类型)。

对于一个可变属性(即 var 声明的)，委托必须额外提供一个操作符函数 setValue() ， 该 函数具有以下参数:

thisRef —— 必须与 属性所有者 类型(对于扩展属性——指被扩展的类型)相同或者 是其超类型。
property —— 必须是类型 KProperty<*> 或其超类型。
value --- 必须与属性类型相同(或者是其超类型)。

 * getValue() 或/与 setValue() 函数可以通过委托类的成员函数提供或者由扩展函数提供。
 * 当你需要委托属性到原本未提供的这些函数的对象时后者会更便利。 两函数都需要用operator 关键字来进行标记。
 *
 *
 */

/**
 * 委托属性的翻译规则：
 * 在每个委托属性的实现的背后，Kotlin 编译器都会生成辅助属性并委托给它。
 * 例如，对于属 性 prop ，生成隐藏属性 prop$delegate ，而访问器的代码只是简单地委托给这个附加属 性:

class C {
    var prop: Type by MyDelegate()
}

// 这段是由编译器生成的相应代码:

class C {
    private val prop$delegate = MyDelegate()
    var prop: Type
        get() = prop$delegate.getValue(this, this::prop)
        set(value: Type) = prop$delegate.setValue(this, this::prop, value)
}

 */


/**
 * 提供委托：
    @todo:
 */



fun main() {
    val b = BaseImpl(10)
    b.printMessage() // 如果由委托对象调用，仍然是父类函数
    b.printMessageLine()
    Derived(b).printMessage()
    Derived(b).printMessageLine()

    val e = Example()
    println(e.p)
    e.p = "NEW"
    println(e.p)

    println(lazyValue)
    println(lazyValue)


    val user = User()
    user.name = "first"
    user.name = "second"

    val userAnother = UserAnother(mapOf(
            "name" to "Francis",
            "age" to 10
    ))
    println(userAnother.name + " : " + userAnother.age)
}

