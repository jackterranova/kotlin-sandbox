package sandbox.standardFunctions


/**
 *
 * Kotlin has a normal run `run(T)` function and an extension version `T.run()`
 *
 * Both return the value of the last statement in the block
 *
 * `run(T)` acts as a sort of scope function
 *
 * `T.run()` passes T as a parameter, referenced as `this`
 *
 */

fun main() {
    val mood = "I am sad"


    // run function will return the value of the last statement in the block
    // normal standard function
    val runResult = run {
        val mood = "I am happy"
        println(mood) // I am happy

        "FINISHED" // return this statement
    }

    println(mood)  // I am sad
    println(runResult)


    // extension standard function
    val runResult2 = "RUN ME".run {
        println("$this as an extension function version of run")
        "FINSIHED2"
    }

    println(runResult2)

    println(mutableListOf("one","two","three").apply {
        println(size)
        println(get(0))
        println(get(1))
        println(get(2))
        add("four")
    })


}

