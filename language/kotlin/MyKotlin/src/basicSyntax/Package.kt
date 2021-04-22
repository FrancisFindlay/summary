package basicSyntax

fun printMessage() = "message"

class Message {

}

/**
 * 以下包默认导入到Kotlin文件
 * kotlin.*
 * kotlin.annotation.*
 * kotlin.collections.*
 * kotlin.comparisons.* (自 1.1 起)
 * kotlin.io.*
 * kotlin.ranges.*
 * kotlin.sequences.*
 * kotlin.text.*
 *
 * 根据目标平台会导入其他包
 * Jvm: java.lang.*
 *      java.jvm.*
 */

/**
 * 名字冲突可以使用
 * import org.test.Message as testMessage
 */

/**
 * 关键字import不仅可以用来导入包，还可以用来导入：
 * 顶层函数及其属性
 * 对象声明中声明的函数和属性
 * 枚举常量
 */

fun main() {

}