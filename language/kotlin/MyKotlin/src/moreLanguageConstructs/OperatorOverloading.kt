package moreLanguageConstructs

/**
 * 一元操作符：
 * +a ->  a.unaryPlus()
 * -a -> a,unaryMinus()
 * !a -> a.not()
 * a++ -> a.inc()
 * a-- -> a.dec()
 *
 */

/**
 * 二元操作符：
 * a + b -> a.plus(b)
 * a - b -> a.minus(b)
 * a * b -> a.times(b)
 * a / b -> a.div(b)
 * a % b -> a.rem(b)
 * a..b -> a.rangTo(b)
 */


/**
 * in:
 * a in b -> b.contains(a)
 *
 * a !in b -> !b.contains(a)
 */

/**
 * 索引访问：
 * a[i] -> a.get(i)
 * a[i, j] -> a.get(i, j)
 */

/**
 * 调用操作符：
 * a() -> a.invoke()
 * a(i) -> a.invoke(i)
 */

/**
 * 广义赋值：
 * a += b -> a.plusAssign(b)
 * a -= b -> a.minusAssign(b)
 * a *= b -> a.timesAssign(b)
 * a /= b -> a.divAssign(b)
 * 如果右列的函数可用
 * 相应的二元函数(即 plusAssign() 对应于 plus() )也可用，那么报告错误 (模糊)，
 * 确保其返回类型是 Unit ，否则报告错误，
 * 生成 a.plusAssign(b) 的代码;
 * 否则试着生成 a = a + b 的代码(这里包含类型检测: a + b 的类型必须是 a 的子类 型)。
 */

/**
 * 比较操作符：
 * a > b -> a.compareTo(b) > 0
 * ...
 */

fun main() {
    data class Point(val x: Int, val y: Int)

    operator fun Point.unaryMinus() = Point(-x, -y)
    val point = Point(10, 20)
    println(-point) // 输出“Point(x=-10, y=-20)”

    /**
     * 对于 A++ 和 ++A :
     * 计算表达式的步骤是:
     * 把 a 的初始值存储到临时存储 a0 中; 把 a.inc() 结果赋值给 a ;
     * 把 a0 作为表达式的结果返回。
     * 对于 a-- ，步骤是完全类似的。
     * 对于前缀形式 ++a 和 --a 以相同方式解析，其步骤是:
     * 把 a.inc() 结果赋值给 a ;
     * 把 a 的新值作为表达式结果返回。
     */



}