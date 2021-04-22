package moreLanguageConstructs

import kotlin.random.Random


/**
 *
 * 对一个非空(non-null)对象执行 lambda 表达式: let
 * 将表达式作为变量引入为局部作用域中: let
 * 对象配置: apply
 * 对象配置并且计算结果: run
 * 在需要表达式的地方运行语句:非扩展的 run
 * 附加效果: also
 * 一个对象的一组函数调用: with
 */

/**
 * Kotlin 标准库包含几个函数，它们的唯一目的是在对象的上下文中执行代码块。
 * 当对一个对象 调用这样的函数并提供一个 lambda 表达式时，它会形成一个临时作用域。
 * 在此作用域中，可以访问该对象而无需其名称。这些函数称为作用域函数。
 * 共有以下五种:let 、run 、with 、apply 以及 also 。
 */

/**
 * run 、 with 以及 apply 通过关键字 this 引用上下文对象。
 * 因此，在它们的 lambda 表达式中可以像在普通的类函数中一样访问上下文对象。
 * 在大多数场景，当你访问接收者对象时你可以省略 this ，来让你的代码更简短。
 * 相对地，如果省略了 this ，就很难区分接收者对象的成员及外部对象或函数。
 * 因此，对于主要对对象成员进行操作(调用其函数或赋值 其属性)的 lambda 表达式，建议将上下文对象作为接收者( this )。
 */

fun main() {
    data class Person(var name: String, var age: Int, var city: String) {
        fun moveTo(newCity: String) {
            city = newCity
        }

        fun incrementAge() {
            age++
        }
    }
    Person("Alice", 20, "Amsterdam")
            .let {
                println(it)
                it.moveTo("London")
                it.incrementAge()
                println(it)
            }

    /**
     * 如果不使用 let 来写这段代码，就必须引入一个新变量，并在每次使用它时重复其名称。
     */
    val alice = Person("Alice", 20, "Amsterdam")
    println(alice)
    alice.moveTo("London")
    alice.incrementAge()
    println(alice)


    /**
     * 区别：this 还是 it
     * 在作用域函数的 lambda 表达式里，上下文对象可以不使用其实际名称而是使用一个更简短的 引用来访问。
     * 每个作用域函数都使用以下两种方式之一来访问上下文对象:作为 lambda 表达 式的接收者( this )或者作为 lambda 表达式的参数( it )。
     * 两者都提供了同样的功能， 因此我们将针对不同的场景描述两者的优缺点，并提供使用建议。
     */
    val str = "hello"
    str.run {
        println("the recevier string length is $length")
        // println("The receiver string length: ${this.length}") // 和上句效果相同 }
    }
    str.let {
        println("the receiver string length is ${it.length}")
    }

    data class PersonAnother(var name: String, var age: Int = 0, var city: String = "")

    val adam = PersonAnother("Adam")
            .apply {
                age = 20
                city = "London"
            }

    println(adam)

    /**
     * 反过来， let 及 also 将上下文对象作为 lambda 表达式参数。
     * 如果没有指定参数名，对象 可以用隐式默认名称 it 访问。 it 比 this 简短，带有 it 的表达式通常更容易阅读。
     * 然而，当调用对象函数或属性时，不能像 this 这样隐式地访问对象。
     * 因此，当上下文对象 在作用域中主要用作函数调用中的参数时，使用 it 作为上下文对象会更好。若在代码块中 使用多个变量，则 it 也更好。
     */


    fun writeToLog(message: String) {
        println("INFO: $message")
    }

    fun getRandomInt(): Int {
        return Random.nextInt(100).also {
            writeToLog("getRandomInt() generated value $it")
        }
    }

    val i = getRandomInt()

    /**
     * 返回值：
     * apply 及 also 返回上下文对象。
     * let 、 run 及 with 返回 lambda 表达式结果.
     */
    val numberList = mutableListOf<Double>()
    numberList
            .also {
                println("Polulation the list")
                it.add(1.0)
            }
            .apply {
                add(3.0)
                add(2.0)
            }
            .also {
                println("Sorting the list")
            }
            .sort()
    numberList.forEach {
        println( it )
    }

    /**
     * lambda 结果：
     * let 、 run 及 with 返回 lambda 表达式的结果。
     *
     */
    val numbers = mutableListOf("one", "two", "three")
    val countEndWithE = numbers.run {
        add("four")
        add("five")
        count {
            it.endsWith("e")
        }
    }
    println("There are $countEndWithE elements that end with e.")

    /**
     * 此外，还可以忽略返回值，仅使用作用域函数为变量创建一个临时作用域。
     */
    with(numbers) {
        val firstItem = first()
        val lastItem = last()
        println("First item: $firstItem, last item: $lastItem")
    }


}