package sandbox.range

fun main() {
    val vals = listOf(1,2,3,12,20,100)

    vals.forEach {
        if (it in 1..10) {  //<<< RANGE
            println("$it is in range")
        }

        if (it !in 1..10) {  // <<< NEGATION IN RANGE
            println("$it is not in range")
        }
    }

    // RANGE STEPS print odd numbers in a range
    for(i in 1..10 step 2) println(i)
}