package FunctionAndlambda

import com.sun.xml.internal.fastinfoset.util.StringArray
import java.lang.reflect.Field

fun foo(int: Int) = {
    println(int)
}

fun fooRun(int: Int) = {
}

/**
 * foo函数的返回值类型是 Function()，调用foo(n)实际是构造了一个Function对象，不等价于我们调用了过程本身。
 *
 * 通过源码可以发现，需要调用Function()的invoke()才等价于执行了println。因此foo(1)不会输出1；
 * 必须执行foo(1).invoke()
 *
 * 每个Function类型都有一个invoke()
 */


/**
 * 高阶函数：高阶函数是将函数用作参数或返回值的函数。
 * 一个不错的示例是集合的函数式风格的 fold )， 它接受一个初始累积值与一个接合函数，通过将当前累积值与每个集合元素连续接合起来代入累积值来构建返回值:
 */

fun <T, R> Collection<T>.fold(
        initial: R,
        combine: (acc: R, nextElement: T) -> R
        // 为了调用 fold ，需要传给它一个函数类型的实例作为参数，而在高阶函数调用处，(下文 详述的)lambda 表达 式广泛用于此目的。
): R {
    var accumulator: R = initial
    for (element: T in this) {
        accumulator = combine(accumulator, element)
    }
    return accumulator
}

/**
 * 函数类型：
 * Kotlin 使用类似 (Int) -> String 的一系列函数类型来处理函数的声明: val onClick: () -> Unit = ......
 *
 * 这些类型具有与函数签名相对应的特殊表示法，即它们的参数和返回值:
 *
 * 所有函数类型都有一个圆括号括起来的参数类型列表以及一个返回类型: (A, B) -> C 表示接受类型分别为 A 与 B 两个参数并返回一个 C 类型值的函数类型。
 *      参数类型 列表可以为空，如 () -> A 。 Unit 返回类型不可省略。
 *
 * 函数类型可以有一个额外的接收者类型，它在表示法中的点之前指定:
 *      类型 A.(B) -> C 表示可以在 A 的接收者对象上以一个 B 类型参数来调用并返回一个 C 类型值的函 数。 带有接收者的函数字面值通常与这些类型一起使用。
 *
 * 挂起函数属于特殊种类的函数类型，它的表示法中有一个 suspend 修饰符 ，例如 suspend () -> Unit 或者 suspend A.(B) -> C 。
 *
 * 如需将函数类型指定为可空，请使用圆括号: ((Int, Int) -> Int)?
 *
 * 函数类型可以使用圆括号进行接合: (Int) -> ((Int) -> Unit)
 *
 * 箭头表示法是右结合的， (Int) -> (Int) -> Unit 与前述示例等价，但不等于 ((Int) - > (Int)) -> Unit 。
 *
 * 还可以通过使用类型别名给函数类型起一个别称:
 *
 * typealias ClickHandler = (Button, ClickEvent) -> Unit
 */

/**
 * 函数类型实例化：
 *
 * lambda表达式: { a, b -> a + b } ,
 *
 * 匿名函数: fun(s: String): Int { return s.toIntOrNull() ?: 0 }
 *
 * 顶层、局部、成员、扩展函数: ::isOdd 、 String::toInt ，
 *
 * 顶层、成员、扩展属性: List<Int>::size ，
 *
 * 构造函数: ::Regex
 *
 *
 */

/**
 * 实现函数类型接口的自定义类的实例：
 * ?????
 */


class IntTransformer : (Int) -> Int {
    override fun invoke(p1: Int): Int {
        return p1 * 10
    }
}

val intFunction: (Int) -> Int = IntTransformer() // intFunction 是 int -> int ?

fun main() {
    var items = listOf<Int>(1, 2, 3, 4, 5)
    println(items.size)
    val get = items::get

    // lambda 是花括号括起来的代码块
    items.fold(0, { acc: Int, i: Int ->
        // 如果一个 lambda 表达式有参数，前面是参数，后跟“->”
        print("acc = $acc, i = $i")
        val result = acc + i
        println("result = $result")
        result // lambda 最后一个表达式表示返回值
    })


    // lambda 表达式的参数类型是可选的，如果能够推断出来的话:
    val joinedToString = items.fold("Elements:", { acc, i -> acc + " " + i })
    println(joinedToString)
    // 函数引用也可以用来高阶函数调用：
    val product = items.fold(1, Int::times)
    println(product)

    println(intFunction(1))

    /**
     * 带与不带接收者的函数类型非字面值可以互换，其中接收者可以替代第一个参数，反之亦 然。
     * 例如， (A, B) -> C 类型的值可以传给或赋值给期待 A.(B) -> C 的地方，反之亦然:
     */

    /**
     * 函数类型可以有一个额外的接收者类型，它在表示法中的点之前指定: 类型 A.(B) -> C
     * 表示可以在 A 的接收者对象上以一个 B 类型参数来调用并返回一个 C 类型值的函 数。 带有接收者的函数字面值通常与这些类型一起使用。
     */

    val repeatFunction: String.(Int) -> String = {
        times -> this.repeat(times) // this 就是String
    }
    val twoParameter: (String, Int) -> String = repeatFunction

    fun runTransformation(f: String.(Int) -> String): String {
        return f("hello", 3)
    }

    fun runTransformationAnother(f: (String, Int) -> String): String { // 和上面是等价的
        return f("hello", 3)
    }

    val result = runTransformation(repeatFunction)
    println("result = $result")

    /**
     * 函数类型实例调用：
     * 如果该值具有接收者类型，那么应该将接收者对象作为第一个参数传递。 调用带有接收者的 函数类型值的另一个方式是在其前面加上接收者对象，
     * 就好比该值是一个扩展函数: 1.foo(2)
     *
     */

    val stringPlus: String.(String)  -> String = String::plus
    val stringPlusAnother: (String, String)  -> String = String::plus // 上面的另外一种写法
    val intPlus: Int.(Int) -> Int = Int::plus
    println(stringPlus.invoke("<- ", " ->"))
    println(stringPlus("Hello", "world!"))
    println("hello".stringPlus("1"))
    println(intPlus.invoke(19, 21))
    println(intPlus(19, 21))
    println(19.intPlus(21))


    /**
     * lambda 表达式和匿名函数：
     * lambda 表达式与匿名函数是“函数字面值”，即未声明的函数，但立即做为表达式传递。
     * { a, b -> a.length < b.length } 等价于
     *      fun compare(a: String, b: String): Boolean = a.length < b.length
     */


    /**
     * lambda 表达式总是括在花括号中， 完整语法形式的参数声明放在花括号内，并有可选的类型 标注， 函数体跟在一个 -> 符号之后。
     * 如果推断出的该 lambda 的返回类型不是 Unit ，那 么该 lambda 主体中的最后一个(或可能是单个) 表达式会视为返回值。
     */

    val sum: (Int, Int) -> Int = { a: Int, b: Int -> a + b}

    /**
     * 传递末尾的 lambda 表达式:
     * 在 Kotlin 中有一个约定:如果函数的最后一个参数是函数，那么作为相应参数传入的 lambda表达式可以放在圆括号之外:
     *
     */
    val fuckingTailLambda = items.fold(1) {acc, e -> acc * e}

    /**
     * 如果该 lambda 表达式是调用时唯一的参数，那么圆括号可以完全省略:
     */

    fun lambdaNoParameter(f: () -> Unit) {

    }

    lambdaNoParameter { // run 就是上面的函数
        println("lambda no parameter...")
    }

    lambdaNoParameter( {} )

    /**
     * it:
     * 一个 lambda 表达式只有一个参数是很常见的。
     * 如果编译器自己可以识别出签名，也可以不用声明唯一的参数并忽略 -> 。 该参数会隐式声明为 it :
     *
     */
    val ints = arrayOf(1, 2, 3)
            //.filter { it > 1 }


    /**
     * 从lambda表达式返回一个值：
     * 我们可以使用限定的返回语法从 lambda 显式返回一个值。 否则，将隐式返回最后一个表达式的值。
     */

    val x = ints.filter {
        val shouldFilter = it > 1
        shouldFilter
    }


    val y = ints.filter {
        val shouldFilter = it > 1
        return@filter shouldFilter
    } // 与上面等价

    /**
     * 下划线：表示没有使用的变量：
     */

    val map = HashMap<String, Int>()
            .forEach {
                _, value -> println("$value!")
            }

    /**
     * lambda缺少明确指定函数返回值类型的能力，这可以通过匿名函数来实现。
     */

    fun(x: Int, y: Int): Int = x + y

    fun(x: Int, y: Int): Int {
        return x + y
    }

    /**
     * 请注意，匿名函数参数总是在括号内传递。 允许将函数留在圆括号外的简写语法仅适用于 lambda 表达式。
     * Lambda表达式与匿名函数之间的另一个区别是非局部返回的行为。一个不带标签的 return 语句总是在用 fun 关键字声明的函数中返回。这意味着 lambda 表达式中的 return 将从包 含它的函数返回，而匿名函数中的 return 将从匿名函数自身返回。
     */


    /**
     * 带有接收者的函数字面值
     */

    val fuckingAcc: Int.(Int) -> Int = { other -> plus(other) }

    /**
     * 匿名函数语法允许你直接指定函数字面值的接收者类型。 如果你需要使用带接收者的函数类 型声明一个变量，并在之后使用它，这将非常有用。
     */

    val idiot = fun Int.(other: Int): Int = this + other

    foo(1).invoke()
}