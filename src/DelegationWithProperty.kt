import java.text.Format
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

fun main() {

    var User6 = User6()
    with(User6){ // scope function
        firstName = "Alex"
        lastName = "Dobinca"
    }
    with(User6) {
        println(User6.firstName)
        println(User6.lastName)
    }
}

class User6{
    var firstName by FormatDelegate()
    var lastName by FormatDelegate()
}

class FormatDelegate : ReadWriteProperty<Any?, String>{
    private var formattedString: String = ""
    override fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return formattedString
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        formattedString = value.lowercase()
    }

}