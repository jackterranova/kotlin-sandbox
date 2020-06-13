package sandbox.conditionals

fun describe(obj: Any): String =
    when (obj) {
        1          -> "One"
        "Hello"    -> "Greeting"
        is Long    -> "Long"
        !is String -> "Not a string"
        else       -> "Unknown"
    }

fun main() {
    println("10 is a ${describe(10)}")
    println("Test is a ${describe("Test")}")
    println("1 is ${describe(1)}")
}