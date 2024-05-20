fun main() {
    val a = 5
    val b = 0
    try {
        println(a / b)
    } catch (e: ArithmeticException) {
        println("You can't divide by zero: ${e.message}")
    } finally {
        print("Database is closed")
    }

    val result = try {
        println(a / b)
        a / b
    } catch (e: ArithmeticException) {
        println("You can't divide by zero: ${e.message}")
        0
    } finally {
        print("Database is closed")
    }
    println(result)
}