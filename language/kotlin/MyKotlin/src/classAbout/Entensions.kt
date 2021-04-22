package classAbout

import basicSyntax.t
import java.lang.Exception

/**
 * 扩展函数在全局声明就可以在包内可见， 并且对应的Java代码是 public static final。
 * 而如果在类内实现扩展函数，就没有了static关键字,于是，就只能在类内和子类调用了。
 */

/**
 * 同名的类成员方法的优先级总是高于扩展函数。
 */

/**
 *
 * Kotlin 能够扩展一个类的新功能而无需继承该类或者使用像装饰者这样的设计模式。这通过叫做 扩展 的特殊声明完成。
 * 例如，你可以为一个你不能修改的、来自第三方库中的类编写一 个新的函数。 这个新增的函数就像那个原始类本来就有的函数一样，可以用普通的方法调用。
 * 这种机制称为扩展函数 。此外，也有扩展属性 ， 允许你为一个已经存在的类添加新的属性。
 *
 *
 */

/**
 * 扩展函数
 * 声明一个扩展函数，我们需要用一个 接收者类型 也就是被扩展的类型来作为他的前缀。
 * 下面代码为 MutableList<Int> 添加一个 swap 函数:
 *
 * this 在扩展函数内部对应接收者对象（.之前的对象）
 */

/*

fun MutableList<Int>.swap(index1: Int, index2: Int) {
    val temp = this[index1] // this 对应该列表
    this[index1] = this[index2]
    this[index2] = temp
}

 */

// 可以泛化这个函数


fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
    val temp = this[index1] // this 对应该列表
    this[index1] = this[index2]
    this[index2] = temp
}

/**
 * 扩展是静态扩展的：
 * 扩展不能真正的修改他们所扩展的类。通过定义一个扩展, 你并没有在一个类中插入新成员，仅仅是可以通过该类型的变量用点表达式去调用这个新函数。
 *
 * 我们想强调的是扩展函数是静态分发的，即他们不是根据接收者类型的虚方法。
 * 这意味着调 用的扩展函数是由函数调用所在的表达式的类型来决定的， 而不是由表达式运行时求值结果决定的。
 */


/**
 * 可空接收者:
 * 注意可以为可空的接收者类型定义扩展。
 * 这样的扩展可以在对象变量上调用， 即使其值为 null，并且可以在函数体内检测 this == null ，这能让你在没有检测 null 的时候调用 Kotlin 中的toString():检测发生在扩展函数的内部。
 */

fun Any?.toString(): String {
    if (this == null) return "null"
    return this.toString()
}


/**
 * 接口的扩展：
 */

interface MyInterface

fun MyInterface.extensions() {
    println("Ffff...")
}

class ExtendsFromMyInterface : MyInterface


/**
 * 扩展属性
 *
 * 注意:由于扩展没有实际的将成员插入类中，因此对扩展属性来说幕后字段是无效的。
 * 这就是为什么扩展属性不能有初始化器, 他们的行为只能由显式提供的 getters/setters 定义。
 */

val <T> List<T>.lastIndex: Int
    get() = this.size - 1


/**
 * 伴生对象的扩展:
 * 如果一个类定义有一个伴生对象 ，你也可以为伴生对象定义扩展函数与属性。
 * 就像伴生对象的常规成员一样， 可以只使用类名作为限定符来调用伴生对象的扩展成员:
 */

class MyClass {
    companion object Factory {
        val x = 1
    }

}

fun MyClass.Factory.extensionPrint() {
    println("companion...")
}

/**
 * 扩展的作用域:
 * 大多数情况下，我们在顶层直接扩展。
 *
 * 如果需要使用在包之外的一个扩展，我们需要在调用包的时候引入：
 *
 * package org.example.declarations
 * fun List<String>.getLongestString() { }
 *
 * package org.example.usage
 * import org.example.declarations.getLongestString
 *
 * fun main() {
 * val list = listOf("red", "green", "blue") list.getLongestString()
 * }
 *
 */


/**
 * 扩展声明为成员：
 * 在一个类内部你可以为另一个类声明扩展。在这样的扩展内部，有多个 隐式接收者 —— 其中的对象成员可以无需通过限定符访问。
 * 扩展声明所在的类的实例称为 分发接收者，扩展方法 调用所在的接收者类型的实例称为 扩展接收者 。
 *  dispatch receiver
 *  extension receiver
 *
 *  对于分发接收者和扩展接受者的命名冲突的情况，扩展接受者优先。分发接收者可以通过this来实现。
 *
 */

class Host(val hostName: String) { // 扩展接收者
    fun printHostName() {
        println(hostName)
    }


}

class Connect(val host: Host, val port: Int) { // 分发接收者
    // host 就是隐式的

    fun printPort() {
        println(port)
    }

    fun Host.printConnectionString() { // 这种扩展函数只有在Connect内可以使用，其他地方都无法访问。
        printHostName()
        print(":")
        printPort()
    }

    fun Host.getConnectionString() {
        println("=======")
        toString() // 调用Host.toString()
        this@Connect.toString() // Connect的toString()
    }

    fun connect() {
        host.printConnectionString()

        host.getConnectionString()
    }
}


/**
 * 关于可见性的说明：
 * 扩展的可见性与相同作用域内声明的其他实体的可见性相同。例如:
 * 在文件顶层声明的扩展可以访问同一文件中的其他 private 顶层声明; 如果扩展是在其接收者类型外部声明的，那么该扩展不能访问接收者的 private 成员。
 */

class Test {
    private val innerField = 1

    fun Test.find() { // 只能在类内访问到这个函数
        println(innerField)
    }

    fun findNo() {

    }
}


private val privateField = 1

fun Test.findInner() {
    // println(innerField) 不能访问接受者的private
    println(privateField) // 可以访问其他顶层private
}

fun main() {

    ExtendsFromMyInterface().extensions() // 对接口的扩展可以由实现接口的子类调用...


    val list = mutableListOf<Int>(1, 2, 3)
    list.swap(1, 2)

    open class Shape

    class Rectangle : Shape()

    fun Shape.getName() = "Shape"

    fun Rectangle.getName() = "Rectangle"

    fun printClassName(s: Shape) {
        println(s.getName())
    }

    printClassName(Rectangle()) // 这个例子会输出 "Shape"，因为调用的扩展函数只取决于参数 s 的声明类型，该类型是 Shape 类。


    // 如果一个类定义有一个成员函数与一个扩展函数，而这两个函数又有相同的接收者类型、相同的名字，并且都适用给定的参数，这种情况总是取成员函数。 例如:
    class Example {
        fun printFunctionType() {
            println("class method...")
        }
    }

    fun Example.printFunctionType() {
        println("extension function...")
    }

    fun Example.printFunctionType(i: Int) {
        println("extension with Int ...")
    }

    Example().printFunctionType() // 输出class method。

    // 拓展函数也可以重载同样名字但不同签名的函数
    Example().printFunctionType(1) // 输出 extension with int...

    // 伴生对象的扩展...
    MyClass.extensionPrint()

    // 成员扩展
    Connect(Host("kotlin"), 443).connect()
    // Host("kotlin").printConnectString() 错误


}