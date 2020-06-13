package sandbox.collectionFunctions

fun main() {
    val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
    fruits
        .filter { it.startsWith("a") } //only those that start with a
        .sortedBy { it } // sort them
        .map { it.toUpperCase() }  //upper case them
        .forEach { println(it) }  //iterate and print
}