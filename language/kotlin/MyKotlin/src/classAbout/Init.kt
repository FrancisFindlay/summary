package classAbout

/**
 *
 */



fun main() {
    class Bird(weight: Double, age: Int, val color: String) {

        var sex: String

        init {
            println("do something...")
            println("the weight is $weight") // 如果不使用val和var修饰参数，在init可以使用;
        }

        val x: Double = weight // 也可以使用;

        fun printWeight() {
            // println(weight) 在其他任何地方都不可以使用
            this.sex = if (color == "yellow") "male" else "female"

        }

        init {
            this.sex = if (color == "yellow") "male" else "female"
        }
    }

}