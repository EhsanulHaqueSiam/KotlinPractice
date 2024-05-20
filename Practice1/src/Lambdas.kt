import jdk.internal.org.jline.utils.Colors.s

fun main() {
    val mylambda = { a: Int, b: Int -> println("a+b = ${a + b}") }
    val mylambda2: (Int, Int) -> Unit = { a: Int, b: Int -> println("a+b = ${a + b}") }
    mylambda(5, 6)

    val mylambda3 = { a: Int -> println(a) }

    add2(5, 10, mylambda3)
    add2(5, 10, { a: Int -> println(a) })
    add2(5, 10) { a: Int -> println(a) } // if lambda is the last parameter we can define it outside


    val loginButton2 = Button3("Login", 34345, {
        // Login User
    })

    val signUpButton2 = Button3("Sign Up", 2345) {
        // Sign up User
    }

    upperCase("Hello", { s: String -> s.uppercase() })
    upperCase("Hello") { s: String -> s.uppercase() }
    upperCase("Hello", { it.uppercase() })
    upperCase("Hello") { it.uppercase() }

    val user = User8()
    user.firstName = "Alex"
    user.lastName = "Dobinca"
    user.age = 23

    with(user) {
        this.firstName = "Alex"
        this.lastName = "Dobinca"
        this.age = 23
    }
    val result = with(user) {
        firstName = "Alex"
        lastName = "Dobinca"
        age = 23 // return value of this scope function is lambda result
//        23
//        "text"
        this
    }

    val user2 = User8().apply {// returns the object
        firstName = "Alex"
        lastName = "Dobinca"
        age = 23
    }

    with(user2) {
        println(firstName)
        println(lastName)
        println(age)
    }

    val user3 = User9("Alex", "Dobinca", 23)
    println(user3)
    val result2 = User9("Alex", "Dobinca", 23).also { println(it) }

    // Let scope to avoid null pointer exception
    var text: String? = null
    text.let {
        println(it)
    }
    text = "Name"
    val result4 = text?.let {// execute the block of code if the value of the variable is not null
        println(it)// returns lambda result
        "Text"
    }

    val user4: User9? = null
    val result5 = user4?.run { // combination of let and with
        println(firstName)
        println(lastName)
        println(age)
        23
    }

    with(user4) {
        println(this?.firstName)
        println(this?.lastName)
        println(this?.age)
    }

}
// function can accept function as parameter,or return a function is called higher order function
// lambda is just function without name

fun add(a: Int, b: Int) {
    println("a+b = ${a + b}")
}

fun add2(a: Int, b: Int, action: (Int) -> Unit) { // take one int and return nothing
    action(a + b)

}

class Button3(val text: String, val id: Int, val onCLickListener: () -> Unit)
interface OnClickListener2 {
    fun onClick()
}

fun upperCase(str: String, myFunction: (String) -> String) {
    val uppercaseWord = myFunction(str)
    println(uppercaseWord)
}

class User8 {
    var firstName = ""
    var lastName = ""
    var age = -1
}

data class User9(val firstName: String, val lastName: String, val age: Int)