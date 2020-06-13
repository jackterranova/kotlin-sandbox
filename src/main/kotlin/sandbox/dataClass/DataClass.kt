package sandbox.dataClass

data class Customer(val name: String, val email: String)

fun main() {
    Customer("Jack", "jack@example.com")
}