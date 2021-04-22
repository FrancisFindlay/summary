package moreLanguageConstructs

import kotlin.random.Random

/**
 * takeIf taketUnless:
 * 当以提供的谓词在对象上进行调用时，若该对象与谓词匹配，则 takeIf 返回此对象。否则 返回 null 。
 * 因此， takeIf 是单个对象的过滤函数。反之， takeUnless 如果不匹配谓词， 则返回对象，如果匹配则返回 null 。
 * 该对象作为 lambda 表达式参数( it )来访问。
 */

fun main() {
    val number = Random.nextInt()
    val evenOrNull = number.takeIf { number % 2 == 0 } // 是返回 number， 否则返回null
    val odd = number.takeUnless { number % 2 == 0 }
    println(evenOrNull)
    println(odd)

    /**
     * 当在 takeIf 及 takeUnless 之后链式调用其他函数，不要忘记执行空检查或安全调用 ( ?. )，因为他们的返回值是可为空的。
     */

    val str = "Hello"
    val caps = str.takeIf { it.isNotEmpty() }?.toUpperCase()
    //val caps = str.takeIf { it.isNotEmpty() }.toUpperCase() // 编译错误
    println(caps)

    /**
     * takeIf 及 takeUnless 与作用域函数一起特别有用。
     * 一个很好的例子是用 let 链接它们， 以便在与给定谓词匹配的对象上运行代码块。
     * 为此，请在对象上调用 takeIf ，然后通过安 全调用( ?. )调用 let 。对于与谓词不匹配的对象， takeIf 返回 null ，并且不调用let 。
     */

    fun displaySubstringPosition(input: String, sub: String) {
        input.indexOf(sub).takeIf { it >= 0 }?.let {
            println("The substring $sub is found in $input.")
            println("Its start position is $it.")
        }
    }

    displaySubstringPosition("010000011", "11")
    displaySubstringPosition("010000011", "12")



}