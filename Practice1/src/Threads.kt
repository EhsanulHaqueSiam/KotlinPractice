import kotlin.concurrent.thread

fun main() {

    println("Hello World! 1")
    println("Hello World! 2")
    println("Hello World! 3")
    println("Hello World! 4")
    println("Hello World! 5")
    thread {
        Thread.sleep(5000)
        println("Thread 2 has finished")
    }
    println("Hello World! 6")
    println("Hello World! 7")
    println("Hello World! 8")
    println("Hello World! 9")
    println("Hello World! 10")
    println("Hello World! 11")
}