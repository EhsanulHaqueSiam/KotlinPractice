fun main(args: Array<String>) {
//    val clickListener = ClickListener()
//    val loginButton2 = Button2("Login", 1232, clickListener) // sharing same click listener . which we don't want because2 Button2s are different
//    val signUpButton2 = Button2("Sign Up", 23423, clickListener)
    val loginButton2 = Button2("Login", 1232, object : OnClickListener { // object expression or anonymous classes // Declared and Instantiated at the same time
        override fun onClick() {
            // Login the user
        }

    })
    val signUpButton2 = Button2("Sign Up", 23423, object : OnClickListener {
        override fun onClick() {
            // sign up the user
        }
    })
}
class Button2(val text: String,val id: Int, onClickListener: OnClickListener)
class ClickListener(): OnClickListener {
    override fun onClick(){

    }
}
interface OnClickListener{
    fun onClick()
}