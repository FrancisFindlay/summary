package classAbout

/**
 * 类型别名为现有类型提供替代名称。 如果类型名称太长，你可以另外引入较短的名称，并使 用新的名称替代原类型名。
 * 它有助于缩短较长的泛型类型。 例如，通常缩减集合类型是很有吸引力的:
 */

typealias set = Set<Int>
typealias map = Map<Int, String>

/**
 * 可以为函数类型提供别名
 */

typealias MyHandler = (Int, String) -> Unit
typealias f<T> = (T) -> Boolean

/**
 * 可以为内部类和嵌套类提供别名
 */

private class ClassOne {
    inner class Inner
}

private typealias AInner = ClassOne.Inner



fun main() {
}