package basicSyntax

import sun.misc.Request
import javax.xml.ws.http.HTTPException

/**
 * when 取代了 c 的 switch
 * when 既可以被当做表达式使用也可以被当做语句使用。
 * 如果它被当做表达式,符合条件的分支的值就是整个 表达式的值，如果当做语句使用，则忽略个别分支的值。
 * 像 if 一样，每一个分支可以是一个代码块,它的值是块中最后的表达式的值。
 */


fun describe(obj: Any): String =
        when (obj) {
            1 -> {
                println("this is 1")
                "one"
            }
            "hello" -> "Greeting"
            is Long -> "Long"
            !is Long -> "not a string"
            else -> "unknown"
        }


fun main() {
    val v = describe(1)
    println(v)
    println(describe("hello"))
    println(describe(1000L))
    println("others")
    println("=========")

    val x = 1
    when (x) {
        0, 1 -> println("x == 0 or x == 1")
        else -> println("other..")
    }

    val y = when (x) {
        0 -> {
            println("y == 0")
            0
        }
        in 2..10 -> {
            3
        }
        is Int -> {
            println("x is a int")
            999
        }
        else -> {
            println("y == 1")
            1
        }
    }
    println("y == $y")

    // when表达式也可以取代if else，某一分支为真就结束
    when {
        //x.isOdd() -> println("x is  an odd")
        //x.isEven() -> println("x is a even")
        else -> println("other...")
    }


    // 自 Kotlin 1.3 起，可以使用以下语法将 when 的主语(subject，译注:指 达式)捕获到变量中:

   /*
       fun Request.getBody() =
            when (val response = executeRequest()) {
                is Success -> response.body
                is HttpError -> throw HTTPException(response.status)
            }
    */




}

