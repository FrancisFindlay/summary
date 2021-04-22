package classAbout

/**
 * 类声明由类名、类头(指定其类型参数、主构造函数等)以及由花括号包围的类体构成
 * 类头与类体都是可选的; 如果一个类没有类体，可以省略花括号
 */

class NoBody // 没有类体


class Invoice {
}


/**
 * 一个类可以有一个主构造函数和一个或者多个副构造函数。
 *
 * 主构造函数是类头的一部分，跟在类名后。主构造函数没有任何注解和可见性修饰符，construct可以省略。
 *
 * 主构造函数不能包含任何的代码。初始化的代码可以放到以 init 关键字作为前缀的初始化 块(initializer blocks)中。
 *
 */

class Person constructor(firstName: String) {

}

class person(firstName: String) {

}

/**
 * 在实例初始化期间，初始化块按照它们出现在类体中的顺序执行，与属性初始化器交织在一起:
 *
 */

class InitDemo(name: String) {
    val firstProperty = "1 first property: $name".also(::println)

    init {
        println("2 first init block print $name...")
    }

    val secondProperty = "3 second property: $name".also(::println)

    init {
        println("4 Second initializer block that prints ${name.length}")
    }
}



/**
 * 请注意，主构造的参数可以在初始化块中使用。它们也可以在类体内声明的属性初始化器中 使用:
 */

class Customer(name: String) { //主构造函数必须声明类型
    val property = name.toUpperCase()
}

/**
 * 主构造函数和初始化的简洁写法
 */

class Man(val firstName: String, val lastName: String, var age: Int = 1) {

}

/**
 * 如果有可见性修饰符和构造函数，construct是必须的
 */

class Woman public @SuppressWarnings constructor(name: String) {

}


/**
 * 副构造函数
 * 如果类有一个主构造函数，每个次构造函数需要委托给主构造函数，可以直接委托或者通过别的次构造函数间接委托。委托到同一个类的另一个构造函数用 this 关键字即可:
 *
 * 请注意，初始化块中的代码实际上会成为主构造函数的一部分。
 * 委托给主构造函数会作为次 构造函数的第一条语句，因此所有初始化块与属性初始化器中的代码都会在次构造函数体之前执行。
 * 即使该类没有主构造函数，这种委托仍会隐式发生，并且仍会执行初始化块:
 */


class Child {
    var children: MutableList<Child> = mutableListOf<Child>()

    constructor(child: Child) {
        child.children.add(this)
    }
}

class ChildTwo(name: String) {
    val children: MutableList<ChildTwo> = mutableListOf()

    constructor(name: String, child: ChildTwo) : this(name) {
        child.children.add(this)
    }
}


private class Constructors {
    init {
        println("Init block")
    }

    constructor(i: Int) {
        println("Constructor")
    }

    val x: Int = when (1) {
        1 -> {
            println("field has init...")
            1
        }
        else -> {
            print("nothing")
            0
        }
    }
}


fun main() {
    InitDemo("Hello")

    Constructors(1)
}


/**
 * 如果一个非抽象类没有声明任何(主或次)构造函数，它会有一个生成的不带参数的主构造函数。
 * 构造函数的可见性是 public。如果你不希望你的类有一个公有构造函数，你需要声明一个带有非默认可见性的空的主构造函数:
 */

class DontCreateMe private constructor () { /*......*/ }

/**
 * 注意:在 JVM 上，如果主构造函数的所有的参数都有默认值，编译器会生成一个额外的无参构造函数，它将使用默认值。
 * 这使得 Kotlin 更易于使用像 Jackson 或者 JPA 这样 的通过无参构造函数创建类的实例的库。
 */

class NoParameterConstruct(name: String = "")

