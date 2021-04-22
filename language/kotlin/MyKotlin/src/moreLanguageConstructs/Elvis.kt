package moreLanguageConstructs

import kotlin.random.Random

/**
 * ?:
 *
 * !!
 *
 * as
 */

fun main() {
    val b: String? = "kotlin"
    val l: Int = if (b != null) b.length else -1

    /**
     * 如果 ?: 左侧表达式非空，elvis 操作符就返回其左侧表达式，否则返回右侧表达式。
     *
     * 请注意，当且仅当左侧为空时，才会对右侧表达式求值。
     */
    val ll = b?.length ?: -1

    /**
     * 请注意，因为 throw 和 return 在 Kotlin 中都是表达式，所以它们也可以用在 elvis 操作符 右侧。
     * 这可能会非常方便，例如，检测函数参数:
     */
    class Node {

        var x = Random.nextInt()

        fun getParent(): Int? {
            return if (x == 0) 0 else null
        }

        fun getName(): Int? {
            return if (x == 0) 0 else null
        }
    }

    fun foo(node: Node): String? {
        val parent = node.getParent() ?: return null
        val name = node.getName() ?: throw IllegalArgumentException("name expected") // ......
        return "return"
    }

    /**
     * 第三种选择是为 NPE 爱好者准备的:非空断言运算符( !! )将任何值转换为非空类型，若 该值为空则抛出异常。
     * 我们可以写 b!! ，这会返回一个非空的 b 值 (例如:在我们例子 中的 String )或者如果 b 为空，就会抛出一个 NPE 异常:
     *
     */
    val lll = b!!.length

    /**
     * 如果对象不是目标类型，那么常规类型转换可能会导致 ClassCastException 。
     * 另一个选择是 使用安全的类型转换，如果尝试转换不成功则返回 null
     */
    val a = "String"
    val aInt: Int? = a as? Int
    println(aInt) // 转换失败， 为null

    /**
     * 可空集合类型：
     */

    val nullableList: List<Int?> = listOf(1, 2, null, 4)
    val intList: List<Int> = nullableList.filterNotNull()
    println(intList)
}