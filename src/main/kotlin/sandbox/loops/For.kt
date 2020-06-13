package sandbox.loops

fun main() {

    // for in syntax
    var items = listOf("apple", "banana", "kiwifruit")
    for (item in items) {
        println(item)
    }

    // for in with index
    items = listOf("apple", "banana", "kiwifruit")
    for (index in items.indices) {
        println("item at $index is ${items[index]}")
    }
}