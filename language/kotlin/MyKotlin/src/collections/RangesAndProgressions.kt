package collections

/**
 * Kotilin可通过调用 kotlin.ranges 包中的 rangeTo() 函数及其操作符形式的 .. 轻松地创建两个值的区间。
 * 通常， rangeTo() 会辅以 in 或 !in 函数。
 */

/**
 * 反向迭代：
 * downTo
 */


/**
 * 区间是为可比较类型定义的:具有顺序，可以定义任意实例是否在两个给定实例之间的区间内。
 * 区间的主要操作是 contains ，通常以 in 与 !in 操作符的形式使用。
 * 要为类创建一个区间，请在区间起始值上调用 rangeTo() 函数，并提供结束值作为参数。 rangeTo() 通常以操作符 .. 形式调用。
 */


class Version(val major: Int, val minor: Int) : Comparable<Version> {
    override fun compareTo(other: Version): Int {
        if (this.major != other.major) {
            return this.major - other.major
        }
        return this.minor - other.minor
    }
}

/**
 * 如上个示例所示，整数类型的区间(例如 Int 、 Long 与 Char )可视为等差数列。
 * 在 Kotlin 中，这些数列由特殊类型定义: IntProgression 、 LongProgression 与CharProgression 。
 */


fun main() {
    for (i in 1.rangeTo(4)) { // 会调用IntProgression
        print(i)
    }
    println()

    for (i in 1..4) {
        print(i)
    } // 和上面等价
    println()

    for (i in 4 downTo 1) {
        print(i)
    }
    println()

    for (i in 1..8 step 2) {
        print(i)
    }
    println()

    // 需要不包含右边界，使用until
    for (i in 1 until 4) {
        print(i)
    }
    println()

    val versionRange = Version(1, 11)..Version(1, 30)
    println(Version(0, 9) in versionRange)
    println(Version(0, 20) in versionRange)

}
