package FunctionAndlambda

/**
 * inline函数可以为高阶函数提供灵活的控制流。
 *
 * 使用高阶函数会带来一些运行时的效率损失:每一个函数都是一个对象，每一个lambda都会产生一个匿名类和一个调用它的对象，并且会捕获一个闭包。
 * 即那些在函数体内会访问到的变量。 内存分配(对于函数对象和类)和虚拟调用会引入运行时间开销。
 *
 * 但是在许多情况下通过内联化 lambda 表达式可以消除这类的开销。
 *
 */

fun foo(block: () -> Unit) {
    println("Before block...")
    block()
    println("After block...")
}


inline fun fooAnother(block: () -> Unit) {
    println("Before block...")
    block()
    println("After block...")
}

/**
 * Jvm对于普通的函数已经可以决定是否进行inline了，因此，一般情况并不需要进行inline化。
 *
 * 避免对于大量函数体的函数inline，会导致生成过多的字节码。
 *
 * 一旦一个函数被定义为inline，就不能获取闭包类的私有成员，除非声明为internal以上。
 */

/**
 * 对于有多个lambda作为函数参数，而我们只想对其中的一部分 inline 化的情况。可以使用 noinline 关键字。
 */

inline fun fooAgain(block1: () -> Unit, noinline block2: () -> Unit) {
    println("before block")
    block1()
    block2()
    println("after block")
}

/**
 * 非局部返回：
 */


fun localReturn() {
    return
}

fun outerReturn() {
    println("before local return...")
    localReturn()
    println("after local return...")
    return
}

// 我们把上面的函数换成lambda的表示形式:

fun outerReturnByLambda(returning: () -> Unit) {
    println("before local return...")
    returning
    println("after local return...")
    return
}

// 把上面的函数inline后：

inline fun outerReturnByInlineLambda(returning: () -> Unit) {
    println("before local return...")
    returning()
    println("after local return...")
    return
}

/**
 * 具体化参数类型：
 * Kotlin和Java一样，由于运行时的类型擦除，并不能直接获得一个参数的类型。
 * 但是由于内联函数会直接在字节码中生成相应的函数体，反而可以获得具体的参数类型了。
 */

inline fun <reified T> getType() {
    println(T::class)
}


/**
 * 内联属性：
 * inline 可以用作没有幕后字段的属性的访问器：
 */

var bar: Int
    get() = 1
    inline set(value) {}

inline var bar1: Int // 把get 和 set 都作为inline
    get() = 1
    set(value) {}

/**
 * 公有API内联函数的限制：
 * 公有 API 内联函数体内不允许使用非 公有声明，即，不允许使用 private 与 internal 声明以及其部件。
 */

fun main() {

    getType<Int>()


    foo {
        println("dive into kotlin...")
    }

    fooAnother {
        println("inline function call...")
    }

    fooAgain({
        println("i am inline")
    }, {
        println("i am not inline")
    })

    outerReturn()
    outerReturnByLambda {
        // return 编译错误了。在Kotlin中，lambda表达式不允许存在return关键字。
    }
    outerReturnByInlineLambda {
        return // 编译通过了，并且直接在 returning 部分返回了，内联的魅力。
    }

}