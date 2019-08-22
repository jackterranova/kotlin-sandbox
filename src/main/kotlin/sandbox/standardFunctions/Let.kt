package sandbox.standardFunctions


/**
 *
 *
 * `T.let()` returns the last statement in the block
 *
 *
 */

fun main() {
    println(listOf("one","two","three").let { mylist ->
        println(mylist.size)

        "abc"
    }.toUpperCase())
}

