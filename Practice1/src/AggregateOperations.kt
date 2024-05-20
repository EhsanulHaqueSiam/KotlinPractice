fun main() {
    val numbers = listOf(6, 10, 14, 4, 100)
    println("The sum is ${numbers.sum()}")
    println("The count is ${numbers.count()}")
    println("The average is ${numbers.average()}")
    println("The max value is ${numbers.maxOrNull()}")
    println("The min value is ${numbers.minOrNull()}")
    println("The sum is ${numbers.sumOf { it * 2 }}") // sum the numbers and multiply by 2

}