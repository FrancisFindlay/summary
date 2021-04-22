package FunctionAndlambda

/**
 * 柯里化：函数作为返回值的应用。
 *
 */

fun sum(x: Int, y: Int, z: Int) = x + y + z

/**
 * 柯里化：
 */

fun sum(x: Int) = { y: Int ->
    { z: Int -> x + y + z }
}

fun sum() = { x: Int ->
    { y: Int ->
        { z: Int -> x + y + z }
    }
}


fun main() {
    sum(1, 2, 3)
    sum(1)(2)(3)
    sum()(1)(2)(3)
}