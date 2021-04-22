package basicSyntax

fun main() {
    val items = listOf<String>("apple", "banana", "kiwifruit")
    var index = 0
    while (index < items.size) {
        println("item at $index is ${items[index]}")
        index++
    }

}

