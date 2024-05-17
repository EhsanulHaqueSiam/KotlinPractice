fun main() {

}
class App : A by FirstDelegate(), B by SecondDelegate(){ // Implement Interface A but use for the interface A the implementation of the class FirstDelegate
    override fun print() {

    }

    override fun print2() {

    }

}
interface A {
    fun print()
}
interface B {
    fun print2()
}
open class FirstDelegate : A {
    override fun print() {

    }
}
open class SecondDelegate : B{
    override fun print2() {

    }
}
