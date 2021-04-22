package classAbout


/**
 *
 */

/**
 *  kotlin所有类都有一个共同超类Any，对于没有显式声明的类来说，默认继承类Any
 *  class Example  // 从Any继承
 *
 *  Any有三个方法equals(),hashCode(),toString(), 因此所有类都定义了这三个方法
 *
 *  Kotlin类默认是final的，不能被继承，要实现继承必须将父类用 open 标记
 *
 *  如果派生类有一个主构造函数，其基类必须用派生类主构造函数的参数就地初始化。
 *  如果派生类没有主构造函数，那么每个次构造函数必须使用 super 关键字初始化其基类型， 或委托给另一个构造函数做到这一点。
 *  注意，在这种情况下，不同的次构造函数可以调用基类型的不同的构造函数:
 *
 */

private open class Base(p: Int)


private class Derived(p: Int) : Base(p) // 显式声明一个父类的语法

private class DerivedNoMainConstruct : Base {
    constructor(p: Int) : super(p)
}

/**
 * Kotlin 对于可覆盖的成员(我们称之为开放) 以及覆盖后的成员需要显式修饰符:
 */

private open class Shape {
    open fun draw() {} // 显式声明
    fun fill() {}
}

private class Circle : Shape() {
    // 如果想禁止被子类覆盖，可以声明为final
    final override fun draw() { // 显式声明
        println("Circle draw...")
    }
    // fun fill() {} 父类已经有同名函数，不能在子类声明
}

/**
 * 覆盖属性
 *
 * 在超类中声明然后在派生类中重新声明的属性必须以 override 开头，并且它们必须具有兼容的类型。
 * 每个声明的属性可以由具有初始化器的属性或者具有  get 方法的属性覆盖。
 *
 * 可以用var覆盖val， 不能用val覆盖var。
 */

open class Fruit {
    open val vertexCount: Int = 0
}

class Apple : Fruit() {
    override val vertexCount: Int = 1
}

class Origan(override val vertexCount: Int = 4) : Fruit()  // 总是有4个

class Banana() : Fruit() {
    override var vertexCount = 0 // 可以有任意个
}


/**
 * 派生类的初始化顺序
 *
 * 在构造派生类的新实例的过程中，第一步完成其基类的初始化(在之前只有对基类构造函数参数的求值)，因此发生在派生类的初始化逻辑运行之前。
 *
 *
 * 属性构造器和init代码块都会加到主构造函数里(对应的Java代码的构造函数)，具体的执行顺序按照出现顺序排列。
 *
 * 这意味着，基类构造函数执行时，派生类中声明或覆盖的属性都还没有初始化。
 * 如果在基类 初始化逻辑中(直接或通过另一个覆盖的 open 成员的实现间接)使用了任何一个这种属 性，那么都可能导致不正确的行为或运行时故障。
 * 设计一个基类时，应该避免在构造函数、 属性初始化器以及 init 块中使用 open 成员。
 */


open class Based(val name: String) {
    open val size: Int =
            name.length.also { println("Initializing size in Base is $it") }

    init {
        println("Initializing Base")
        println("size in base is $size") // 如果在父类中访问open属性，会因为派生类的属性没有初始化，会导致不正常的行为
    }

    constructor() : this("aaa"){
        println("main constructor...")
    }
}

class Derive(
        name: String,
        val lastName: String
) : Based(name.capitalize().also { println("Argument for Based : $it") }) {
    init {
        println("Initializing Derive")
    }

    override val size: Int =
            (super.size + lastName.length).also { println("Initializing size for derived is $it") }

    constructor() : this("bbb", "ccc") {
        println("last con...")
    }
}

fun main() {
    val fruit = Fruit()
    println(fruit.vertexCount)
    val apple = Apple()
    println(apple.vertexCount)

    //val d = Derive("hello", " world!")

    val dd = Derive()

}


