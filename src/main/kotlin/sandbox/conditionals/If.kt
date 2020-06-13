package sandbox.conditionals

// kotlin has the standard if-else

fun maxOfWithJavaStyleIf(a: Int, b: Int): Int {
    if (a > b) {
        return a
    } else {
        return b
    }
}

fun maxOfWithKotlinStyleIf(a: Int, b: Int): Int {
    return if (a > b) {
        a
    } else {
        b
    }
}

fun main() {
    println(maxOfWithJavaStyleIf(10,20))
    println(maxOfWithKotlinStyleIf(10,20))
}