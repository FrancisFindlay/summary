package basicSyntax

/*
 is 运算符检测一个表达式是否是某类型，如果一个不可变的局部变量或者属性已经被类型检测，
 那么检测后的分支可以直接使用该类型。
 */

fun getTypeLength(obj: Any): Int? {
    if (obj is String) {
        return obj.length
    }
    return null
}

/*
 可以这样写
 */

fun getTypeLength1(obj: Any) :Int? {
    if (obj !is String) {
        return null
    }
    return obj.length
}

/*
 还可以这样写
 */

fun getTypeLength2(obj: Any) :Int? {
    if (obj is String && obj.length > 0) {
        return obj.length
    }
    return null
}

fun main() {
    fun printLength(obj: Any) {
        println("'$obj' string length is ${getTypeLength(obj) ?: "... err, not a string"} ")
    }
//如果 ?: 左侧表达式非空，elvis 操作符就返回其左侧表达式， 否则返回右侧表达式。 请注意，当且仅当左侧为空时，才会对右侧表达式求值。

    printLength("incaslkdalkmsd")
    printLength(1000)
}