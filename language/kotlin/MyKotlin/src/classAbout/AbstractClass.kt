package classAbout

/**
 *
 */

open class Poly {
    open fun draw() {
    }

    // abstract fun f() 报错
}

abstract class Holy : Poly() {
/*
    override fun draw() {

    }
 */

    abstract override fun draw() // 可以使用抽象函数覆盖，也可以使用普通函数覆盖

}

/**
 * 伴生对象
 */

fun main() {

}