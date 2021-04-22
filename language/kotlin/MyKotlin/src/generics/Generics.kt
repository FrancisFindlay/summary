package generics

/**
 * kotlin的类型参数:
 */

private class Box<T>(t: T) {
    val value = t
}

/**
 * 型变:
 * kotlin中没有通配符匹配，有其他两个实现的东西，声明处型变和类型投影。
 * 在Java中，泛型是不变的，这意味这 List<String> 不是 List<Object> 的子类型。也就是说，List<String> 就只能装配String 而不能装配 Integer 。
 *
List<String> strs = new ArrayList<String>();
List<Object> objs = strs; // !!!即将来临的问题的原因就在这里。Java 禁止这样! objs.add(1); // 这里我们把一个整数放入一个字符串列表
String s = strs.get(0); // !!! ClassCastException:无法将整数转换为字符串
 */


/*

interface Collection<E> {
    void addAll(Collection<E> items);
}

void copyAll(Collection<Object> to, Collection<String> from) {
    to.addAll(from);
    // !!!对于这种简单声明的 addAll 将不能编译:
    // Collection<String> 不是 Collection<Object> 的子类型
}

实际上，Collection的实际实现是这样的：

interface Collection<E> {
    void addAll(Collection<? extends E> items);
}

 */

/**
 * 声明处型变：
 *
 * 在 Kotlin 中，有一种方法向编译器解释这种情况。
 * 这称为声明处型变:我们可以标注 Source 的类型参数 T 来确保它仅从 Source<T> 成员中返回(生产)，并从不被消费。
 * 为此，我们 提供 out 修饰符:
 *
 * 当一个类 C 的类型参数 T 被声明为 out 时，它就只能出现在 C 的成员的输 出-位置，但回报是 C<Base> 可以安全地作为 C<Derived> 的超类。
 *
 *
 */

/*
 * 如果你的类是将泛型作为内部方法的返回，那么可以用 out：

 interface Production<out T> {
    fun produce(): T
}

 */

/*
 * 如果你的类是将泛型对象作为函数的参数，那么可以用 in：
 interface Consumer<in T> {
    fun consume(item: T)
}
 */

/*
如果你使用一个生产者对象，如 List<? extends Foo> ，在该对象上不允许调用
add() 或 set() 。但这并不意味着该对象是不可变的:例如，没有什么阻止你调用
clear() 从列表中删除所有项目，因为 clear() 根本无需任何参数。通配符(或其他类型的
型变)保证的唯一的事情是类型安全。不可变性完全是另一回事。
 */

interface Source<out T> {
    fun nextT(): T
}

fun demo(str: Source<String>) {
    val objects: Source<Any> = str
}

fun main() {
    val box: Box<Int> = Box<Int>(1)
    val box1 = Box(1) // 类型推断
    val box2: Box<Int> = Box(1)


}