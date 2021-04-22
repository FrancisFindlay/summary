package moreLanguageConstructs
import kotlin.reflect.KClass

import com.sun.xml.internal.ws.api.pipe.Fiber

/**
 * 注解:
 * 注解是将元数据附加到代码的方法。要声明注解，请将 annotation 修饰符放在类的前面:
 * @Target 指定可以用该注解标注的元素的可能的类型(类、函数、属性、表达式等);
 * @Retention 指定该注解是否存储在编译后的 class 文件中，以及它在运行时能否通过反 射可见 (默认都是 true);
 * @Repeatable 允许在单个元素上多次使用相同的该注解;
 * @MustBeDocumented 指定该注解是公有 API 的一部分，并且应该包含在生成的 API 文档 中显示的类或方法的签名中。
 */

@Target(AnnotationTarget.EXPRESSION, AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.VALUE_PARAMETER)
@Retention(AnnotationRetention.SOURCE)
annotation class Fancy

@Fancy
class Foo {
    @Fancy
    fun baz(@Fancy foo: Int): Int {
        return (@Fancy 1)
    }
}

/**
 * 对类的主构造函数进行注解：
 * 需要在构造函数声明中添加,并将注解添加到其前面:
 *
 */

annotation class Inject

class foo1 @Inject constructor(dependency: Int) {
    var x: Int? = null
        @Inject set // 标注访问器
}

/**
 * 构造函数：
 * 注解也可以声明构造函数。
 * 构造函数允许的参数类型有:
 * 对应于 Java 原生类型的类型(Int、 Long等);
 * 字符串;
 * 类( Foo::class );
 * 枚举;
 * 其他注解;
 * 上面已列类型的数组。
 *
 * 注意，注解的构造函数不能有可空类型, jvm不支持将 null 作为注解属性的值存储。
 */


annotation class Special(val why: String)

@Special("fuckingAnnotation")
class Idiot


/**
 * 如果注解用作另一个注解的参数，则其名称不以 @ 字符为前缀:
 */


annotation class ReplaceWith(val expression: String)

annotation class Deprecated(
        val message: String,
        val replaceWith: ReplaceWith = ReplaceWith(""))

@Deprecated("this fucking function is deprecated, use === instead", ReplaceWith("this === other"))


/**
 * 如果需要将一个类指定为注解的参数，请使用 Kotlin 类 (KClass)。Kotlin 编译器会自动将 其转换为 Java 类，以便 Java 代码能够正常访问该注解与参数 。
 */


annotation class Ann(val arg1: KClass<*>, val arg2: KClass<out Any>)

@Ann(String::class, Int::class)
class MyClass

/**
 * lambda:
 * 注解也可以用于 lambda 表达式。它们会被应用于生成 lambda 表达式体的 invoke() 方法上。
 * 这对于像 Quasar 这样的框架很有用， 该框架使用注解进行并发控制。
 */

annotation class Suspendable

val f = @Suspendable { println("1") }

fun main() {
    f()
}