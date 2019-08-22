package sandbox.standardFunctions


/**
 *
 *
 * `T.apply()` takes `this` and returns `this`
 *
 */

fun main() {

    println(mutableListOf("one","two","three").apply {
        println(size)
        println(get(0))
        println(get(1))
        println(get(2))
        add("four")
    })


}

