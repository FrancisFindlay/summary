package basicSyntax

fun main() {
    //list
    val items = listOf<String>("apple", "banana", "kiwifruit", "apple")
    for (item in items) {
        println(item)
    }

    //set
    val sets = setOf<String>("apple", "banana", "kiwifruit", "apple")
    for (item in sets) {
        println(item)
    }

    //判断某实例是否在集合内
    when {
        "orange" in items -> println("juicy")
        "apple" in items -> println("apple is fine, too")
    }

    //使用lambda来过滤和映射集合
    val fruits = listOf<String>("banana", "avocado", "apple", "kiwifruit")
    fruits
            .filter { it.startsWith("a") } //过滤
            .sortedBy { it } // 排序
            .map { it.toUpperCase() }
            .forEach { println(it) }

}
