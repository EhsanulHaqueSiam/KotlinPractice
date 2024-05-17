fun main() {
    val names = listOf<String>("Name 1", "Name 2", "Name 3", "Name 3") // immutable List
    val names2 = mutableListOf("Name 1", "Name 2", "Name 3", "Name 3") // mutable List
    names2.add("Name 5")
    names2.removeAt(0)
    names2.remove("Name 2")
    names2.forEach { println(it) }
    val names3 = setOf<String>("Name 1", "Name 2", "Name 3", "Name 3") // immutable set. // set cannot have duplicates
    names3.forEach { println(it) }
    val names4 =
        mutableListOf<String>("Name 1", "Name 2", "Name 3", "Name 3") // mutable set. // set cannot have duplicates
    names4.add("Name 4")
    names4.forEach { println(it) }

    val user1 = User5("Name 1")
    val user2 = User5("Name 2")
    val user3 = User5("Name 3")
    val User5 = User5("Name 4")
    val user5 = User5("Name 5")
    val user6 = User5("Alex")
    val user7 = User5("Alex")

    val names5 =
        mutableListOf<User5>(
            user1,
            user2,
            user3,
            User5,
            user5,
            user6,
            user7,
        ) // mutable set. // set cannot have duplicates

    names5.forEach { println(it.name) } // uses equals to == function to determine if there are equal elements

    val users = mapOf<Int, String>(1 to "Maria", 2 to "Alex", 3 to "John") // immutable // cannot have duplicated key
    println(users[1])// key
    users.forEach { t, u -> println("$t and $u") }
    val users2 =
        mutableMapOf<Int, String>(1 to "Maria", 2 to "Alex", 3 to "John") // mutable // cannot have duplicated key
    users2[5] = "Vlad"
    users2.remove(2)
    users2.forEach { t, u -> println("$t and $u") }


}

data class User5(val name: String) // now it have equals to function