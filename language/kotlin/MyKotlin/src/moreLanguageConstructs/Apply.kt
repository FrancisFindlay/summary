package moreLanguageConstructs

/**
 * 上下文对象 作为接收者( this )来访问。 返回值 是上下文对象本身。
 * 对于不返回值且主要在接收者( this )对象的成员上运行的代码块使用 apply 。
 * apply 的常见情况是对象配置。这样的调用可以理解为“将以下赋值操作应用于对象”。
 */

fun main() {
    data class Person(var name: String, var age: Int = 0, var city: String = "")

    val adam = Person("Adam").apply {
        age = 32
        city = "London"
    }
    println(adam)

}