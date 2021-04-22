package generics

import java.lang.IndexOutOfBoundsException
import javax.tools.JavaCompiler

/**
 * 类型约束：设定类型上界；
 */
interface Ground


// 第二种方法， 内联函数
inline fun <reified T> getType(): Class<T> {
    return T::class.java
}

fun main() {
    class Plate<T>(val t: T)
    open class Fruit(val weight: Double)
    class Banana(weight: Double) : Fruit(weight)
    class Apple(weight: Double) : Fruit(weight)
    class FruitPlate<T : Fruit?>(val t: T) // 表明T只能是Fruit类及其子类的类型，其他类型是不被允许的；
    class Noodles(weight: Double)

    val applePlate = FruitPlate<Apple>(Apple(100.0))
    val applePlate1 = FruitPlate(Apple(100.0)) // type cast
    // val noodlesPlate = FruitPlate<Noodles>(Noodles(100.0)) 不允许
    val fruitPlate = FruitPlate(null)

    class Watermelon(weight: Double) : Fruit(weight), Ground

    fun <T> cut(t: T) where T : Fruit, T : Ground { // where 关键字来添加约束条件
        println("you can cut me")
    }
    cut(Watermelon(100.0))
    // cut(Apple(100.0)) 编译错误

    // 在运行时获得类型参数的第一种方法， 匿名内部类；
    val list1 = ArrayList<String>()
    val list2 = object : ArrayList<String>() {}
    println(list1.javaClass.genericSuperclass)
    println(list2.javaClass.genericSuperclass)


    /**
     * kotlin 中， out关键字可以实现协变。
     * 但是，为了防止类型错误，List被设置为类只能读取，不能写入的形式。
     * 这就是为了将泛型实现为协变付出的代价。
     */

    /**
     * 类型错误：
     */
    /*
    List<String> sList = new ArrayList<String>();
    List<Object> olist = sList; // 编译本来会报错，假设不报错；
    olist.add(Integer(1));
    String str = slist.get(0); // 运行出错
    */

    val stringList: List<String> = ArrayList<String>()
    val anyList: List<Any> = stringList
    // stringList.add("kotlin") 编译错误
    /**
     * 需要注意，一个泛型类 Generic<out T> 支持协变，那么它里面的方法就不能使用T作为参数类型, 因为一个方法不允许传入参数父类型的对象；
     */

    class my<out T> {
        fun test(t: @UnsafeVariance T) {} // 编译错误， 但可以通过注解解除；
    }

    /**
     * 逆变：A是B的子类型，但是Generic<A> 是 Generic<B> 的父类型;
     */
    val doubleComparator = Comparator<Double> { d1, d2 ->
        d1.compareTo(d2)
    }
    val doubleList = mutableListOf(2.0, 3.0)
    doubleList.sortWith(doubleComparator)
    doubleList.sortWith(Comparator { d1, d2 ->
        d1.compareTo(d2)
    })

    val numberComparator = Comparator<Number> { n1, n2 ->
        n1.toDouble().compareTo(n2.toDouble()) // number 代替了 double
    }
    val doubleList2 = mutableListOf(2.0, 3.0)
    doubleList2.sortWith(numberComparator)
    val intList = mutableListOf(1, 2)
    intList.sortWith(numberComparator) // 编译通过, sortWith 使用了 in， 实现了逆变。
    /**
     * in： 不能将 T 作为返回值， 但是可以作为参数。
     */

    /**
     * 协变和逆变：
     */
    fun copy(dest: Array<Double?>, src: Array<Double>) {
        if (dest.size < src.size) {
            throw IndexOutOfBoundsException()
        } else {
            src.forEachIndexed { index, _ ->
                dest[index] = src[index]
            }
        }
    }
    var dest = arrayOfNulls<Double>(3)
    val src = arrayOf<Double>(1.0, 2.0, 3.0)
    copy(dest, src)

    // 利用泛型进行处理, 但是只支持同一类型copy
    fun <T> copy(dest: Array<T?>, src: Array<T>) {
        if (dest.size < src.size) {
            throw IndexOutOfBoundsException()
        } else {
            src.forEachIndexed { index, _ ->
                dest[index] = src[index]
            }
        }
    }
    var destDouble = arrayOfNulls<Int>(3)
    val srcDouble = arrayOf(1, 2, 3)
    copy(destDouble, srcDouble)

    fun <T> copyIn(dest: Array<in T>, src: Array<T>) { // T 是 Double
        if (dest.size < src.size) {
            throw IndexOutOfBoundsException()
        } else {
            src.forEachIndexed { index, _ ->
                dest[index] = src[index]
            }
        }
    }
    var dest2 = arrayOfNulls<Number>(3)
    val src2 = arrayOf<Double>(1.0, 2.0, 3.0)
    copyIn(dest2, src2)
    fun <T> copyOut(dest: Array<T>, src: Array<out T>) { // T 是 number
        if (dest.size < src.size) {
            throw IndexOutOfBoundsException()
        } else {
            src.forEachIndexed { index, _ ->
                dest[index] = src[index]
            }
        }
    }
    copyOut(dest2, src2)

}