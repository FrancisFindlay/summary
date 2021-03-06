package keywordsAndOperators

/**
 * kotlin 有 hardkeywords 和 softketwords:
 * hard 不能用来作为标识符，soft 在适用的上下文用作关键字，其他的可以用来当作标识符;
 * https://kotlinlang.org/docs/reference/keyword-reference.html
 *
 */

/**
 * 标识符:
 * == 、 != —— 相等操作符(对于非原生类型会翻译为调用 equals() )
 * === 、 !== —— 引用相等操作符
 * < 、 > 、 <= 、 >= —— 比较操作符(对于非原生类型会翻译为调用 compareTo() ) [ 、 ] —— 索引访问操作符(会翻译为调用 get 与 set )
 * !! 断言一个表达式非空
 * ?. 执行安全调用(如果接收者非空，就调用一个方法或访问一个属性)
 * ?: 如果左侧的值为空，就取右侧的值(elvis 操作符)
 * :: 创建一个成员引用或者一个类引用
 * .. 创建一个区间
 * : 分隔声明中的名称与类型
 * ? 将类型标记为可空
 */

/**
 * -> 分隔 lambda 表达式的参数与主体 分隔在函数类型中的参数类型与返回类型声明 分隔 when 表达式分支的条件与代码体
 */

/**
 * @
 * 赋值操作符
 * 引入一个注解
 * 引入或引用一个循环标签 引入或引用一个 lambda 表达式标签 引用一个来自外部作用域的 “this”表达式
 * 引用一个外部超类
 * ; 分隔位于同一行的多个语句
 * $ 在字符串模版中引用变量或者表达式
 * _ 在 lambda 表达式中代替未使用的参数 在解构声明中代替未使用的参数
 */

fun main() {
    val field = 1; val a = 2
    val enum = 2
}