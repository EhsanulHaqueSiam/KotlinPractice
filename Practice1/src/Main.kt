import Car
import Direction2
import sayHello
import sendMessage
import sendText
import sum2
import java.awt.ComponentOrientation

fun main() {
    var name: String = "Siam"
    var name2 = "Siam" // Type Inference
    name = "Ehsanul"
    val word: String = "World"
    var age: Int = 21
    val num: Int = Int.MAX_VALUE
    println("Hello $name!!")
    val num2 = 24L
    val myfloat = 2.4f
    val myfloat2 = 2.4F

    var x = 5
    val y = 4
    println("Sum : ${x + y}") // ${expressions} place holder

    val num3 = -5
    val num4 = -3
    var text: String = if (num3 > 0 || num4 > 0) {
        println("The condition is true")
        "This is text 1"
    } else {
        println("The condition is false")
        "this is text 2"
    }
    println(text)

    var text2 = if (num3 > 0 || num4 > 0) "This is text 1" else 5

    println(text2)

    val alarm = 12
    when (alarm) {
        12, 1, 3 -> println("The time is $alarm")
        in 4..6 -> println("The time is damn!!! $alarm")
        !in 1..3 -> {
            "The time is damn!!! $alarm"
        }

        7 -> println("The time is $alarm")
        14 -> println("The time is $alarm")
        else -> println("The time is $alarm")

    }
    val text3 = when (alarm) {
        in 1..10 -> "The number is in range 1..10"
        7, 8 -> "The time is $alarm"
        else -> "The time is $alarm"
    }

    val text4 = when {
        alarm <= 10 -> "The number is in range 1..10"
        alarm == 11 || alarm == 14 -> "The time is $alarm"
        else -> "The time is $alarm"
    }

    val text5: String? = null
    var text6: String? =
        "Siam" // println(text6.length) //Only safe (?.) or non-null asserted (!!.) calls are allowed on a nullable receiver of type String?

    if (text6 != null) {
        println(text6.length)
    } else {
        println("The variable is null")
    }
    text6 = null
    println(text6?.length) // ?safe call operator equivalent to if != null . if null it will print null , else print the value
//    println(text5!!.length) // asserted (!!.) if null throw exception

    val text7 = text
        ?: "Some text" // Elvis operator (?:) always returns the left operand of non-nullable type String // =(check if null. if it not null assign this) ?: return if null
    var text8 = ""
    if (text8 != null) {
        text8 = text
    } else {
        text8 = "This variable is null."
    }
    sayHello()
    sayHello("Siam")
    sayHello("Siam", 21)
    val max = getMax(2, 5)
    println(max)
    sendMessage(message = "Hello")
    sum2(1, 2, 3, 4, 5, 6)
    for (i in 1..10) {
        println("i = $i")
    }
    for (i in 1 until 10) {
        println(i)
    }
    for (i in 10 downTo 1) {
        println(i)
    }
    for (i in 1 until 10 step 2) println(i)

    var number = 0
    while (number < 10) {
        println(number)
        number++
    }
    while (number < 10) println(number++)

    do {
        println(number)
    } while (number < 10)

    outer@ while (number < 5) {
        number++
        println(number)

        var i = 0

        while (i < 5) {
            if (i == 0) break@outer
            i++
            println("***$i")
        }
    }

    val names: Array<String> = arrayOf("Tanmoy", "Sarker", "Shahriyer")
    val names2 = arrayOf("Tanmoy", "Sarker", "Shahriyer", 45, 'a') // Type Inference
    names[0] = "Alex"
    println("First Element is ${names[0]}")
    println(names.size)

    for (name in names2) {
        if (name is String) {
            println(name)
        }
    }

    val car1 = Car()
    car1.name = "Tesla"
    car1.model = "S Plaid"
    car1.color = "Red"
    car1.doors = 4

    println("Name = ${car1.name}")
    println("Model = ${car1.model}")
    println("Color = ${car1.color}")
    println("Doors = ${car1.doors}")

    val car2 = Cars(name = "Tesla", "S Plaid", "Red", 4)
    car2.favouriteCar = "Audi"
    println(car2.favouriteCar) // if late init is not initialized it will cause error . better to have late init exception then null pointer exception

    println(Calculator.sum(5, 10))
    val instance = Database.getInstance() // val instance = Database() will cause error because constructor is private
    val instance2 = Database.getInstance()
    println(instance)
    println(Database2)

    val user1 = User2("Alex", "Dobbin", 23)
    val user2 by lazy { // use when costly // object will only initialize when you use that
        User("User1", "LastName", 0)
    }

    println(Direction.WEST)
    for (direction in Direction2.values()){
        println(direction)
    }
    println(Direction2.WEST.direction)
    println(Direction2.WEST.distance)
    println(Direction2.WEST.name)
    Direction2.WEST.printData()
    val direction = Direction2.EAST
    val direction2 = Direction2.valueOf("east".uppercase())
    when(direction){
        Direction2.EAST -> {
            println("The direction is East")
        }
        Direction2.NORTH -> println("The direction is NORTH")
        Direction2.SOUTH -> println("The direction is SOUTH")
        Direction2.WEST -> println("The direction is WEST")
    }

    val listview = ListView(arrayOf("Name 1", "Name 2", "Name 3", "Name 4"))
    listview.ListViewItems().displayItem(2)

    val success = Result.Success("SUCCESS!")


    getData(success)

    val name3 = "Alex"
    val name4 = "Alexandru"

    println(name3 == name4) // checks if the content is same// structural equality
    println(name3 === name4) // checks if the address is same// referential equality


}

fun sayHello() {
    println("Hello")
}

fun sayHello(name: String) {
    println("Hello, $name")
    return
}

fun sayHello(name: String, age: Int) {
//    age = 30 // Val cannot be reassigned ( parameter is Val )
    println("Hello, $name; Your age $age")
}

fun getMax(a: Int, b: Int): Int {
    val max = if (a > b) a else b
    return max
}

fun getMax2(a: Int, b: Int): Int {
    if (a > b) return a else return b
}

fun getMax3(a: Int, b: Int): Int {
    return if (a > b) a else b
}

fun getMax4(a: Int, b: Int) =
    if (a > b) a else b // Single Expression Function use if single expression on single line of code . in that case not needed type

fun getMax5(a: Int, b: Int, c: Int): Int {
    return if (a >= b && a >= c) {
        a
    } else if (b >= a && b >= c) {
        b
    } else {
        c
    }
}

fun sendMessage(name: String = "Siam", message: String = sendText()) {
    println("Name = $name and message = $message")
}

fun sendText() = "Some text"
fun sum(vararg numbers: Int): Int {
    var result = 0
    for (number in numbers) {
        result += number
    }
    return result
}

fun sum2(vararg numbers: Int) {
    numbers.forEach { println(it) }
}

fun isEvenNumber(number: Int) = (number % 2) == 0

fun findMax(numbers: Array<Int>): Int {
    var max = numbers[0]

    for (number in numbers) {
        if (number > max) {
            max = number
        }
    }

    return max
}

class Cars(name: String, model: String, color: String, doors: Int) {
    lateinit var favouriteCar: String // lateinit only works with classes . not with primitive type like Int Boolean
    var name = name
        get() {
            return field
        }
        set(value) {
            field = value
        } // name = value will cause recursive infinite calls
    var model = model
        get() = field
    var color = color
    var doors = doors
    fun move() {
        println("the car is moving")
    }

    fun stop() {
        println("The car is stopped")
    }
}

class Cars2(var name: String, var model: String, var color: String, var doors: Int) {

    constructor(name: String) : this(
        name,
        "Model",
        "white",
        2
    )// secondary constructor can only declare parameters. not properties

    constructor(name: String, model: String) : this(name, model, "white", 2) {
        println("You are good to go.")
    }

    fun move() {
        println("the car is moving")
    }

    fun stop() {
        println("The car is stopped")
    }
}

class User(name: String, var lastName: String = "LastName", var age: Int) {
    var name: String

    init {
        if (name.lowercase().startsWith("a")) {
            this.name = name
        } else {
            this.name = "User"
            println("The name doesn't start with the letter 'a' or 'A'")
        }
    }

    init {
        println("Nice to meet you")
    }
}

class Calculator(){
    companion object{   // no need to create a object as it belongs to a class. not to a object. class variable or class function
        var max = 100
        fun sum(a: Int, b: Int): Int{
            return a+b
        }
    }

}

// Singleton
class Database private constructor(){
    companion object{
        private var instance: Database? = null

        fun getInstance(): Database? {
            if (instance == null) {
                instance = Database()
            }
            return instance

        }
    }
}

object Database2 {
    init {
        println("Database Created")
    }
}

class User2(var firstname: String, var lastName: String, var age: Int){
    init {
        println("User: $firstname was created")
    }
}

// enum classes when you want to represent fixed set of values or constants. it can have properties and functions
// normally used in if statement , when statement
enum class Direction {
    NORTH,// these are objects created inside class
    SOUTH,
    EAST,
    WEST
}
enum class Direction2 (var direction: String, var distance: Int) {
    NORTH("north",10),
    SOUTH("south",20),
    EAST("east",15),
    WEST("west",40);

    fun printData(){
        println("Direction = $direction and Distance = $distance")
    }
}

class ListView(val items: Array<String>){
    inner class ListViewItems(){
        fun displayItem(position: Int){
            println(items[position])
        }
    }
}

class Account(val accountName: String){
    private var balance = 0
    private var transactions = mutableListOf<Int>()

    fun deposit(amount: Int){
        if (amount > 0){
            transactions.add(amount)
            balance += amount
            println("$amount deposited. Balance is now ${this.balance}")
        }else{
            println("Cannot deposit negative sums")
        }
    }
    fun withdraw(withdrawal: Int){
        if (-withdrawal < 0 ){
            transactions.add(-withdrawal)
            this.balance += -withdrawal
            println("$withdrawal withdrawn. Balance is now ${this.balance}")
        }else{
            println("Cannot withdraw negative sums")
        }
    }
    fun calculateBalance(): Int{
        this.balance = 0
        for (transaction in transactions){
            this.balance += transaction
        }
        return balance
    }
}
open class Vehicle(val name: String, val color: String){
    open fun move(){
        println("$name is moving")
    }
    open fun stop(){
        println("$name is stopped")

    }
}
class Car2(name: String, color: String, val engine: Int, val doors: Int): Vehicle(name, color) {
    override fun move() {
        super.move()
    }


}
class Plane(name: String, color: String, val engine: Int, val doors: Int): Vehicle(name, color){
    override fun move() {
        flying()
        super.move()
    }

    fun flying (){
        println("The plane is flying")
    }
}
open class View(){
    open fun draw(){
        println("Drawing the view.")
    }
}
open class Button (val text: String, val orientation: String): View(){
    override fun draw() {
        // here is the code for creating the button
        println("Drawing the button")
        super.draw()
    }
}

class RoundButton(text: String, orientation: String, val corners: Int): Button(text, orientation){
    override fun draw() {
        println("Drawing the round button.")
    }
}

fun getData(result: Result){
    when(result) {
        is Result.Error.RecoverableError -> result.showMessage()
        is Result.Error.NonRecoverableError -> result.showMessage()
        is Result.Success -> result.showMessage()
        else -> {
            result.showMessage()
        }

    }//'when' expression must be exhaustive. Add the 'is Error', 'is Success' branches or an 'else' branch
}

sealed class Result(val message: String){ // ENUM with properties
    fun showMessage(){
        println("Result: $message")
    }
    class Success(message: String): Result(message)
    sealed class Error(message: String): Result(message){
        class RecoverableError(exception: Exception, message: String): Error(message)
        class NonRecoverableError(exception: Exception, message: String): Error(message)

    }
    class Progress(message: String): Result(message)
}

// abstract class
abstract class Vehicle2(){

    val text = "some text"

    abstract fun move()
    fun stop(){

    }
}
class Car3(var name: String, var color: String, var engine: Int, val doors: Int): Vehicle2(){
    override fun move() {
        TODO("Not yet implemented")
    }


}

class User3(var firstName: String, var lastName: String, var age: Int){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other is User3) return ((this.firstName == other.firstName)
                && (this.lastName == other.lastName)
                && (this.age == other.age))

        return false
    }

    override fun hashCode(): Int {
        return 0
    }

    override fun toString(): String {
        return "User(firstName='$firstName', lastName='$lastName', age=$age"
    }
}

data class User4(var firstName: String, var lastName: String){
    var age = 0// will not auto generate  hashcode,equals,toString
}

interface Engine {
    fun startEngine()
}
class Car4(val name: String, val color: String):Engine{
    override fun startEngine() {
       println("The car engine is started")
    }

}
class Truck(val name: String, val color: String):Engine{
    override fun startEngine() {
        println("The Truck engine is started")

    }

}


