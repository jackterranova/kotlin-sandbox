package sandbox.standardFunctions


/**
 *
 * `with(T)` returns last statement in block even though it takes `this` as an argument
 *
 */

fun main() {

    val withResult = with(listOf("one","two","three")) {
        println(size)
    }

    println(withResult)

}

