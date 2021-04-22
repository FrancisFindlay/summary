package classAbout

/**
 * 关于类的主构造器的参数：
 * 使用val和var，才会生成对应的getter和setter， 不使用就不会生成，也不会生成幕后字段。
 */

/**
 * https://stackoverflow.com/questions/55356837/what-is-the-difference-between-init-block-and-constructor-in-kotlin
 */

/**
 * 指定一个类的主构造函数的可见性，使用以下语法(需要显式声明关键字 construct)：
 *
 */

open class Constr private constructor(a: Int) {
    //这里的构造函数是私有的。
    // 默认情况下，所有构造函数都是 public ，这实际上等于类可见的地方它就可见(即 一个 internal 类的构造函数只能在相同模块内可见).


}


fun main() {
    // private val x = 1 局部变量、局部函数、局部类不能有修饰符

}