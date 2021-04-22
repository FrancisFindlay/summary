package FunctionAndlambda

import com.sun.corba.se.impl.orbutil.graph.Graph
import sun.security.provider.certpath.Vertex
import kotlin.reflect.jvm.internal.impl.utils.DFS


/**

 */

/**
 * 覆盖方法总是使用与基类型方法相同的默认参数值。 当覆盖一个带有默认参数值的方法时， 必须从签名中省略默认参数值:
 */


private open class A {
    open fun foo(i: Int = 10) { /*......*/
    }
}

private class B : A() {
    override fun foo(i: Int) { /*......*/
    } // 不能有默认值
}

/**
 * 如果一个默认参数在一个无默认值的参数之前，那么该默认值只能通过使用具名参数调用该 函数来使用:
 */

fun foo(bar: Int = 0, baz: Int) {
}

/**
 * 如果在默认参数之后的最后一个参数是 lambda 表达式，那么它既可以作为具名参数在括号内 传入，也可以在括号外传入:
 */

fun fooAnother(bar: Int = 0, baz: Int = 1, qux: () -> Unit) {
}

/**
 * 具名参数：
 *
 */

fun reformat(str: String,
             normalizeCase: Boolean = true,
             upperCaseFirstLetter: Boolean = true,
             divideByCamelHumps: Boolean = false,
             wordSeparator: Char = ' ',
             x: Int) {
}

/**
 * 当一个函数调用混用位置参数与具名参数时，所有位置参数都要放在第一个具名参数之前。 例如，允许调用f(1,y=2) 但不允许f(x=1,2)。
 */


/**
 * 可以通过使用星号操作符将可变数量参数( vararg ) 以具名形式传入:
 */

fun foo(vararg strings: String) {}

/**
 * 返回 Unit 的函数：
 * 如果一个函数不返回任何有用的值，它的返回类型是 Unit 。 Unit 是一种只有一个值 —— Unit 的类型。这个值不需要显式返回。
 */

fun printHello(name: String): Unit {
    if (name != null) {
        println("hello, $name")
    } else {
        println("who are you?")
    }
}


/**
 * 具有块代码体的函数必须始终显式指定返回类型，除非他们旨在返回 Unit ，在这种情况下 它是可选的。
 * Kotlin 不推断具有块代码体的函数的返回类型，因为这样的函数在代码体中可 能有复杂的控制流，并且返回类型对于读者(有时甚至对于编译器)是不明显的。
 */

fun f(): Int? {
    return 1
    return null
}

/**
 * vararg：可变数量的参数。
 * 函数的参数(通常是最后一个)可以用 vararg 修饰符标记:
 *
 * 在函数内部，类型 T 的 vararg 参数的可见方式是作为 T 数组，即 ts 变量具 有类型 Array <out T> 。
 *
 * 只有一个参数可以标注为 vararg 。如果 vararg 参数不是列表中的最后一个参数，
 * 可以使 用具名参数语法传递其后的参数的值，或者，如果参数具有函数类型，则通过在括号外部传 一个 lambda。
 *
 * 当我们调用 vararg -函数时，我们可以一个接一个地传参，例如 asList(1, 2, 3) ，
 * 或者， 如果我们已经有一个数组并希望将其内容传给该函数，我们使用伸展(spread)操作符(在 数组前面加 * ):
 */

fun <T> asList(vararg ts: T): List<T> {
    val result = ArrayList<T>()
    for (t in ts) {
        result.add(t)
    }
    println(result)
    return result
}

/**
 * 中缀表示法：
 * 标有 infix 关键字的函数也可以使用中缀表示法(忽略该调用的点与圆括号)调用。中缀函 数必须满足以下要求:
 * 它们必须是成员函数或扩展函数;
 * 它们必须只有一个参数;
 * 其参数不得接受可变数量的参数且不能有默认值。
 *
 * 用中缀表示法调用该函数
1 shl 2
 * 等同于这样
1.shl(2)

 * 中缀函数调用的优先级高于布尔操作符,in, 以及 is， 但是低于算术运算符，类型转换以及rangeTo
 * 1 shl 2 + 3 等价于 1 shl (2 + 3)
 * 0 until n * 2 等价于0 until (n * 2)
 * xs union ys as Set<*> 等价于 xs union (ys as Set<*>)
 * a && b xor c 等价于a &&(b xor c) a xor b in c 等价于(a xor b) in c
 */

infix fun Int.shl(x: Int): Int {
    return this.shl(x)

}

/**
 * 请注意，中缀函数总是要求指定接收者与参数。当使用中缀表示法在当前接收者上调用方法时，需要显式使用 this ;不能像常规方法调用那样省略。
 * 这是确保非模糊解析所必需的。
 */

class MyStringCollection {

    infix fun add(s: String) {}

    fun build() {
        this add "abc"
        add("abc")
        // add "abc" 错误
    }
}

/**
 * kotlin支持局部函数，即一个函数在另一个函数内部:
 */
/*

fun dfs(graph: Graph) {

    var fuckingField = 1
    fun dfs(current: Vertex, visited: MutableSet<Vertex>) {
        fuckingField++ // 局部函数可以访问外部闭包
        if (!visited.add(current)) return
        for (v in current.neighbors) {
            dfs(v, visited)
        }
    }
    dfs(graph.vertices[0], HashSet())
}


 */

fun outer() {
    var count = 1
    fun inner() {
        count++
        println(count)
    }
    inner()
    inner()
}

fun main() {
    // foo(1) 报错
    foo(baz = 1) // 具名函数可以实现只对没有默认值的参数赋值

    fooAnother { println("Hello") }
    fooAnother(1) { println("Hello") }
    fooAnother(qux = { println("Hello") })

    // 使用具名参数代码更具有可读性：
    val str = "abc"
    reformat(str,
            normalizeCase = true,
            upperCaseFirstLetter = true,
            divideByCamelHumps = false,
            wordSeparator = '_',
            x = 1
    )

    // 如果不需要所有的参数:
    reformat(str, wordSeparator = '-', x = 1)

    foo(strings = *arrayOf("a", "b", "c"))
    foo("string", "string1")
    // foo("string", "string1", 1234) 报错，vararg 只能用做同一类型


    var list = asList(1, 2, 3)

    var a = arrayOf(1, 2, 3)
    var list1 = asList(-1, 0, "abc", a, *a, 4)

    println(1 shl 2)
    println(1.shl(2)) // 等同于上面

    outer()
}