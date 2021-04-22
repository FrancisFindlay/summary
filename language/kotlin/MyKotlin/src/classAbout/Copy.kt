package classAbout

/**
 * 在很多情况下，我们需要复制一个对象改变它的一些属性，但其余部分保持不变。
 * copy()函数就是为此而生成。对于上文的 User 类，其实现会类似下面这样:
 *
 *
 */
data class UserAnother (val name: String, val age: Int){
}

fun UserAnother.copy(name: String = this.name, age: Int = this.age) = UserAnother(name, age)

fun main() {
    val jack = UserAnother(name = "jack", age = 1)
    val olderJack = jack.copy(age = 2)
    println(jack)
    println(olderJack)
}