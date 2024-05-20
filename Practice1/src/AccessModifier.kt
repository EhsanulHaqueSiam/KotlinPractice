fun main() {
    getData()

}
// public,private, internal, protected
// internal is accessible in same module (package)
// protected cannot be used in classes.only inside classes

open class User7 {
    public var firstName: String = ""
    private var lastName: String = ""
    protected var age: Int = 0
    internal var nickName: String = ""
}

class VipUser : User7() {
    fun printInfo() {
        println(age)
    }
}