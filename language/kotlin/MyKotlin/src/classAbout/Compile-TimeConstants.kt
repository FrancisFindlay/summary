package classAbout

/**
 * 如果只读属性的值在编译期间是已知的，那么可以使用 const 来修饰将其标记为编译期常量。
 * 这种属性需要满足以下条件：
 *      位于顶层或者是 object 声明 或者 companion object 的一个成员
 *      以String或者原声类型初始化
 *      没有自定义getter
 *
 * 在顶层中：
 *      const val 生成的java代码对应public static final int,
 *      val 对应 private static final int,
 *      var 对应 private static int...
 * 在companion中
 *      const val 对应 public static final int,
 *      val 对应 private static final int,
 *      var 对应 private static int...
 *
 * 首先，const 无法定义局部变量，除了局部变量位于栈区这个原因之外，还因为局部变量的值无法在编译期间确定。
 *      因此，const 只能修饰属性（类属性、顶层属性）...
 *
 * 因为 const 变量的值必须在编译期间确定下来，所以它的类型只能是 String 或基本类型，并且不能有自定义的 getter,
 */



class Con {

    companion object Factory {
        var t = 1
    }
}

fun main() {

}