package sandbox.standardFunctions


/**
 *
 *
 * `T.also()` takes `it` as a param but returns `this`
 *
 *
 */

fun main() {
    //unlike the previous standard functions, `also` returns this
    println(mutableListOf("one", "two", "three").also {
        it.removeAt(0)
        Unit // << tryng to return nothing, but `also` always returns this
    })
}

