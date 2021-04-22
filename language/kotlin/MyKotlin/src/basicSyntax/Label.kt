package basicSyntax

/**
 * 任何表达式都支持标签
 *
 * return 表达式从最直接包围它的函数即 foo 中返回。
 * (注意，这种非局部的返回只 支持传给内联函数的 lambda 表达式。)
 * 如果我们需要从 lambda 表达式中返回，我们必须 给它加标签并用以限制 return 。
 *
 *
 * 标签限制的 return 允许我们从外层函数返回。 最重要的一个用途就是从 lambda 表达式中返回。
 */

fun foo() {
    listOf(1, 2, 3, 4, 5).forEach {
        // println(it) it是列表元素（非下标）
        if (it == 3) {
            return // return 非局部返回到了foo（）的调用者
        }
        print(it)
    }
}

fun fooWithLabel() {
    listOf(1, 2, 3, 4, 5).forEach lit@{
        if (it == 3) {
            return@lit // 返回到了 lambda的调用者，forEach()
        }
        print(it)
    }
}


fun fooWithLabelAndAnonymousFunction() {
    listOf(1, 2, 3, 4, 5).forEach(fun(value: Int) {
        if (value == 3) return
        print(value)
    })
    println("done with a function")
}

fun fooWithImplictLabel() {
    listOf(1, 2, 3, 4).forEach {
        if (it == 3) {
            return@forEach
        }
        print(it)
    }
}

fun fooWithRun() {
    run loop@{
        listOf(1, 2, 3, 4, 5).forEach {
            if (it == 3) return@loop // 从传入 run 的 lambda 表达式非局部返回
            print(it)
        }
    }
    print(" done with nested loop")
}

fun run() {
    run {
        listOf(1, 2, 3, 4, 5).forEach {
            if (it == 3) return
            print(it)
        }
    }
    println("run...")
}


fun main() {
    loop@ for (i in 1..100) {
        for (j in 1..100) {
            println("i == $i, j == $j")
            if (i == j) {
                break@loop
            }
        }
    }

    //foo()
    //fooWithLabel()

    //fooWithLabelAndAnonymousFunction()
    //fooWithImplictLabel()
    //fooWithRun()
    val x = run()
    println(x)
}



