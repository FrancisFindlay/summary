package classAbout

/**
 * 一个类可以实现多个接口
 *
 * 接口中的属性要么是抽象的，要么提供访问器的存在。
 * 接口中不能有幕后字段的存在，因此接口中的访问器不能访问他们。
 * 接口无法保存状态。
 */

interface Myinterface {
    // val x: Int = 1  没有幕后字段的存在，生成的java代码只有getX（）而没有声明x属性。因此，接口只能定义，而不能初始化实际的值。
    abstract val x: Int
    val prop: Int
    val propertyString: String
        get() = "foo..."

    fun foo() {
        println(prop)
    }
}

class ChildForInterface : Myinterface {
    override val x: Int = 30
    override val prop: Int = 29
}

/**
 * 接口的继承：
 * 一个接口可以从其他接口继承。
 */

interface Named {
    val name: String
}

interface Renamed : Named { // 接口实现另外一个接口， 不需要implement...
    val firstName: String
    val lastName: String

    override val name: String get() = "$firstName $lastName" //
}

interface RRenamed : Renamed { // 子接口继承父接口的override属性在子接口的子接口中不需要重写...
    override val firstName: String
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
    override val lastName: String
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.
}

data class Employee( // 数据类
        override val firstName: String,
        override val lastName: String

) : Renamed {
    fun f() {
        println() // 数据类也可以实现函数
    }
}


/**
 * 覆盖冲突
 */

private interface A {
    fun p() {
        println("A p...")
    }
    fun q() {
        println("A q...")
    }
}

private interface B {
    fun p() {
        println("B p...")
    }
    fun q() {
        println("B q...")
    }
}

private class C : A {
    override fun p() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun q() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

/**
 * 通过super<Type> 来分别对继承的接口进行实现。
 * 接口因为没有方法体时默认为抽象。
 */

private class D : A, B {
    override fun p() {
        super<A>.p()
        super<B>.p()
    }

    override fun q() {
        super<A>.q()
        super<B>.q()
    }
}



fun main() {

}