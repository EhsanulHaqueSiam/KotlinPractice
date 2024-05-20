import org.w3c.dom.css.Counter

fun main() {
//    var numbers = arrayOf<Int>()
//    numbers = "some text" // type mismatch

    val footballPlayer = FootballPlayer("Football player 1")
    val footballPlayer2 = FootballPlayer("Football player 2")

    val baseballPlayer = BaseballPlayer("Baseball player 1")
    val baseballPlayer2 = BaseballPlayer("Baseball player 2")

    val footballTeam = Team("Football Team", mutableListOf(footballPlayer))
    footballTeam.addPlayers(footballPlayer2)
//    footballTeam.addPlayers(baseballPlayer) // Error

    val baseballTeam = Team<BaseballPlayer>("Baseball Team", mutableListOf(baseballPlayer))
    baseballTeam.addPlayers(baseballPlayer2)
//    baseballTeam.addPlayers(footballPlayer) // Error

//    val gamesTeam = Team2<GamesPlayer>("Games Team", mutableListOf()) // error expected Player

    val footballTeam2 = Team3<Player>(
        "Football Team",
        mutableListOf<FootballPlayer>(FootballPlayer("Player 1"), FootballPlayer("Player 2"))
    ) // Error, Mutable list is Invariant

    val gamesTeam = Team4<CounterStrikePlayer>(
        "Games Team",
        mutableListOf<GamesPlayer>(GamesPlayer("Player 1"), GamesPlayer("Player 2"))
    )
    val gamesTeam2 = Team4<CounterStrikePlayer>(
        "Games Team",
        mutableListOf<Player>(GamesPlayer("Player 1"), GamesPlayer("Player 2"))
    )

//    val list: Any = mutableListOf("Hello","World")
//    if (list is List<*>)
    val mixedList = mutableListOf(1, 2, 360, 'a', 'b', 'c', "hello", "world")
    val specificList = getSpecificTypes<Int>(mixedList)

    for (element in specificList) {
        println(element)
    }

    val gamesTeam3 = Team5<FootballPlayer2>(
        "Games Team",
        mutableListOf<Player>(GamesPlayer("Player 1"), GamesPlayer("Player 2"))
    )

    addPlayer(FootballPlayer2("Player 1"))
}

class Team<T>(val name: String, val players: MutableList<T>) {
    fun addPlayers(player: T) {
        if (players.contains(player)) {
            println("Player: ${(player as Player).name} is already in the team ${this.name}")
        } else {
            players.add(player)
            println("Player: ${(player as Player).name} was added in the team ${this.name}")

        }
    }
}

class Team2<T : Player>(val name: String, val players: MutableList<T>) { // T: UpperBound
    fun addPlayers(player: T) {
        if (players.contains(player)) {
            println("Player: ${player.name} is already in the team ${this.name}")
        } else {
            players.add(player)
            println("Player: ${player.name} was added in the team ${this.name}")

        }
    }
}

class Team3<T : Player>(
    val name: String,
    val players: MutableList<out T>
) { // T: UpperBound // to accept sub classes (Going down the inheritance tree) out T// covariance
    fun addPlayers(player: T) {
        if (players.contains(player)) {
            println("Player: ${player.name} is already in the team ${this.name}")
        } else {
//            players.add(player) // Read-only for out T
            println("Player: ${player.name} was added in the team ${this.name}")

        }
    }
}

class Team4<T : Player>(
    val name: String,
    val players: MutableList<in T>
) { // T: UpperBound // to accept super classes (Going up the inheritance tree) in T// contravariance
    fun addPlayers(player: T) {
        if (players.contains(player)) {
            println("Player: ${player.name} is already in the team ${this.name}")
        } else {
            players.add(player)
            println("Player: ${player.name} was added in the team ${this.name}")

        }
    }
}

class Team5<T>(
    val name: String,
    val players: MutableList<in T>
) where T : Player, T : Listener { // must inherit player(same as class Team5<T: Player>) and Must implement Listener
    fun addPlayers(player: T) {
        if (players.contains(player)) {
            println("Player: ${player.name} is already in the team ${this.name}")
        } else {
            players.add(player)
            println("Player: ${player.name} was added in the team ${this.name}")

        }
    }
}

open class Player(val name: String)
class FootballPlayer(name: String) : Player(name)
class FootballPlayer2(name: String) : Player(name), Listener {
    override fun listen() {

    }
}

class BaseballPlayer(name: String) : Player(name)
open class GamesPlayer(name: String) : Player(name)
class CounterStrikePlayer(name: String) : GamesPlayer(name)

inline fun <reified T> getSpecificTypes(list: List<Any>): List<T> { //reified makes sure that the types are not reased at run time
    val specificList = mutableListOf<T>()
    for (element in list) {
        if (element is T) { // Generics dont exist at run time
            specificList.add(element)
        }
    }
    return specificList
}

interface Listener {
    fun listen()
}

fun <T> addPlayer(player: T) where T : Player, T : Listener {

}