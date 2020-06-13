package sandbox.loops


fun main() {

    // WHILE
    val items = listOf("apple", "banana", "kiwifruit")
    var index = 0
    while (index < items.size) {
        println("item at $index is ${items[index]}")
        index++
    }

    // DO WHILE
    var y = 0

    do {
        println(y++)
    } while (y < 100) // y is visible here!
}
