package classAbout

import java.util.function.BinaryOperator
import java.util.function.IntBinaryOperator

/**
 * 枚举类:
 * 每个枚举常量都是一个对象。枚举常量用逗号分隔。
 */

private enum class Direction {
    NORTH, SOUTH, WEST, EAST
}

/**
 * 初始化:
 * 因为每一个枚举都是枚举类的实例，所以他们可以是这样初始化过的。
 */

private enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}

/**
 * 匿名类：
 * 枚举常量还可以声明其带有相应方法以及覆盖了基类方法的匿名类。
 * 如果枚举类定义任何成员，那么使用分号将成员定义中的枚举常量定义分隔开。
 */

private enum class ProtocoState {
    WAITING { // 匿名类
        override fun signal() = TALKING
    },

    TALKING {
        override fun signal() = WAITING
    };



    abstract fun signal(): ProtocoState
}

/**
 * 枚举类中实现接口:
 *
 * 一个枚举类可以实现接口(但不能从类继承)，可以为所有条目提供统一的接口成员实现， 也可以在相应匿名类中为每个条目提供各自的实现。
 * 只需将接口添加到枚举类声明中即可， 如下所示:
 */

private enum class IntArithmetics : BinaryOperator<Int>, IntBinaryOperator {
    PLUS {
        override fun apply(t: Int, u: Int): Int = t + u
    },
    TIMES {
        override fun apply(t: Int, u: Int): Int = t * u
    };

    override fun applyAsInt(left: Int, right: Int): Int = apply(left, right)

}

/**
 * 使用枚举常量：
 * Kotlin 中的枚举类也有合成方法允许列出定义的枚举常量以及通过名称获取枚举常量。这些方法的签名如下(假设枚举类的名称是 EnumClass ):

EnumClass.valueOf(value: String): EnumClass
EnumClass.values(): Array<EnumClass>

 */

private enum class RGB {
    RED, GREEN, BLUE
}

inline fun <reified T : Enum<T>> printAllValues() {
    print(enumValues<T>().joinToString { it.name })
}

/**
 * 枚举常量还实现了 Comparable 接口， 其中自然顺序是它们在枚举类中定义的顺序。
 */


/**
 * 枚举中如果有额外的属性或者方法定义，需要使用；来分割。
 */

enum class Car(val x: Int) {
    BMW(1);
    val t = 2
}



fun main() {
    val a = 12
    val b = 21
    for (f in IntArithmetics.values()) {
        println("$f($a, $b) = ${f.apply(a, b)}")
    }

    printAllValues<RGB>()
}