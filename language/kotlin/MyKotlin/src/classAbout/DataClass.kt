package classAbout

/**
 * 我们经常创建一些只保存数据的类。 在这些类中，一些标准函数往往是从数据机械推导而来的。在 Kotlin 中，这叫做 数据类 并标记为 data :
 * 编译器自动从 主构造函数 中声明的所有属性导出以下成员:
 * equals() 和 hashcode() ;
 * toString() 格式是 "User(name=John, age=42)" ;
 * componentN() 函数 按声明顺序对应于所有属性;
 * copy() 函数(见下文)。
 *
 * 数据类必须满足：
 * 主构造函数需要至少有一个参数;
 * 主构造函数的所有参数需要标记为 val 或 var ;
 * 数据类不能是抽象、开放、密封或者内部的;
 * (在1.1之前)数据类只能实现接口。
 *
 * 成员遵循:
 * 如果在数据类体中有显式实现 equals() 、 hashCode() 或者 toString() ，或者这些函 数在父类中有 final 实现，那么不会生成这些函数，而会使用现有函数; 如果超类型具有 open 的 componentN() 函数并且返回兼容的类型， 那么会为数据类生 成相应的函数，并覆盖超类的实现。如果超类型的这些函数由于签名不兼容或者是 final 而导致无法覆盖，那么会报错;
 * 从一个已具 copy(......) 函数且签名匹配的类型派生一个数据类在 Kotlin 1.2 中已弃用，并 且在 Kotlin 1.3 中已禁用。
 * 不允许为 componentN() 以及 copy() 函数提供显式实现。
 *
 * 在 JVM 中，如果生成的类需要含有一个无参的构造函数，则所有的属性必须指定默认值。
 *
 * 请注意，对于那些自动生成的函数，编译器只使用在主构造函数内部定义的属性。如需在生 成的实现中排除一个属性，请将其声明在类体中:
 *
 *
 * 在 toString() 、 equals() 、 hashCode() 以及 copy() 的实现中只会用到 主构造函数内的 属性，并 且只有一个 component 函数 component1() 。
 * 虽然两个 Person 对象可以有不同的年龄但 它们会视为相等。
 */

data class User(val name: String) {
    var age: Int = 0
}

/**
 * 数据类与解析说明
 */

/**
 * 标准数据类
 * 标准库提供了 Pair 与 Triple 。尽管在很多情况下具名数据类是更好的设计选择， 因为它们通过为属性提供有意义的名称使代码更具可读性。
 */



fun main() {
    val person1 = User("francis")
    val person2 = User("francis")
    person1.age = 10
    person2.age = 20
    println("person1 ===(引用地址比较） person2: ${person1 === person2}")
    println("person1 ==（值比较） person2: ${person1 == person2}")

    // 数据类和解析说明
    val jane = UserAnother("jane", 35)
    val (name, age) = jane
    println("$name, $age years of age...")


}