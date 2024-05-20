fun main() {
    val numbers = setOf(1, 2, 3, 4, 5)
    println(numbers.map { it * 10 }) // transformation functions are lambda functions //do what ever is in {} apply to all the elements of numbers
    println(numbers.map { if (it == 3) it * 100 else it * 10 })
    println(numbers.mapIndexedNotNull { index, value -> if (index == 0) null else index * value })
    val numbersMap = mapOf("key 1" to 1, "key 2" to 2, "key 3" to 3, "key 4" to 4)
    println(numbersMap.mapKeys { it.key.uppercase() })
    println(numbersMap.mapValues { it.value + it.key.length })

//    filter: Filters elements based on a predicate.
    val evens = numbers.filter { it % 2 == 0 }
    println(evens) // Output: [2, 4]
//    flatMap: Transforms each element into an iterable of elements and then flattens the resulting collections into a single list.
    val expanded = numbers.flatMap { listOf(it, it + 10) }
    println(expanded) // Output: [1, 11, 2, 12, 3, 13, 4, 14, 5, 15]
//    reduce: Accumulates value starting with the first element and applying the operation from left to right.
    val sum = numbers.reduce { acc, i -> acc + i }
    println(sum) // Output: 15
//    fold: Similar to reduce, but starts with an initial value.
    val sumWithInitial = numbers.fold(10) { acc, i -> acc + i }
    println(sumWithInitial) // Output: 25
//    forEach: Performs the given action on each element.
    numbers.forEach { println(it) }
// Output:
// 1
// 2
// 3
// 4
// 5
    //  https://kotlinlang.org/docs/collection-transformations.html
    //  https://www.baeldung.com/kotlin/collection-transformations
    //  https://www.geeksforgeeks.org/kotlin-collection-transformation/
    //  https://appcircle.io/blog/transforming-kotlin-collections-functions-with-examples
    //  https://www.kotlinprimer.com/standard-library/collections-elementary-functional-programming/transformations/#0e4d
    //  https://www.baeldung.com/kotlin/map-operations

    // zipping
    val colors = listOf("red", "brown", "grey")
    val animals = listOf("fox", "bear", "wolf")
    println(colors.zip(animals))
    println(colors zip animals)
    println(colors.zip(animals) { color, animal -> "The ${animal.replaceFirstChar { it.uppercase() }} is $color" })

    val numberPairs = listOf("one" to 1, "two" to 2, "three" to 3, "four" to 4)
    println(numberPairs)
    println(numberPairs.unzip())

    // Association allows to build maps
    val numbers2 = listOf("one", "two", "three", "four")
    println(numbers2.associateWith { it.length })
    println(numbers2.associateBy { it.first().uppercase() })
    println(numbers2.associateBy(keySelector = { it.first().uppercase() }, valueTransform = { it.length }))

    // Flatten converts 2d to 1d
    val numbersSets = arrayOf(arrayOf(1, 2, 3), arrayOf(4, 5, 6), arrayOf(7, 8, 9)) // multi-dimensional array
//    1    2    3
//    4    5    6
//    7    8    9
    println(numbersSets[2][2])
    val numbersSets2 = listOf(setOf(1, 2, 3), setOf(4, 5, 6), setOf(7, 8, 9)) // multi-dimensional array
    for (numbers in numbersSets2) {
        for (number in numbers) {
            print(number)
        }
        println()
    }
    println()
    val numbersFlatten = numbersSets2.flatten()
    println(numbersFlatten[8])
    for (number in numbersFlatten) {
        println(number)
    }

    val numbersStrings = listOf("one", "two", "three", "four")
    println(numbersStrings)
    println(numbersStrings.joinToString())
    val listStrings = StringBuffer("The list of numbers: ")
    println(numbersStrings.joinTo(listStrings))

    println(numbersStrings.joinToString(separator = " | ", prefix = "Start: ", postfix = ": end"))
    val numbers3 = (1..100).toList()
    println(numbers3)
    println(numbers3.joinToString(limit = 15, truncated = "<..>"))

    println(numbersStrings.joinToString { "Element: ${it.uppercase()}" })

    // Filtering return true or false
    // for using Filter list or set it returns list .for map returns map
    val numbers4 = listOf("one", "two", "three", "four")
    val longerThan3 = numbers4.filter { it.length > 3 }
    println(longerThan3)

    val numbersMap2 = mapOf("key 1" to 1, "key 2" to 2, "three" to 3, "keu 101" to 101)
    val fileteredMap = numbersMap2.filter { it.key.endsWith("1") && it.value > 100 }
    println(fileteredMap)
    val filteredIndex = numbers4.filterIndexed { index, value -> (index != 0) && (value.length < 5) }
    val filteredNot = numbers4.filterNot { it.length <= 3 }
    println(filteredIndex)
    println(filteredNot)

    val mixedList = listOf(1, 2, 3, 'a', 'b', 'c', "Hello World", "Alex", false)
    mixedList.filterIsInstance<Char>().forEach {
        println(it)
    }
    // Partition filters collection by predicate and keeps that don't match in separate list
    val (match, rest) = numbers4.partition { it.length > 3 }
    println(match)
    println(rest)

    // testing predicate
    println(numbers4.any { it.endsWith("e") }) // true
    println(numbers4.none { it.endsWith("w") }) //true
    println(numbers4.all { it.length > 1 }) //true

    // + - operator for collection
    val numbers5 = mutableListOf("one", "two", "three", "four")
    val plusList = numbers5 + "five"
    val minusList = numbers5 - mutableListOf("three", "four")
    println(plusList)
    println(minusList)

    // Grouping
    val numbers6 = listOf("one", "two", "three", "four", "five")
    println(numbers6.groupBy { it.first().uppercase() })
    println(numbers6.groupBy(keySelector = { it.first() }, valueTransform = { it.uppercase() }))

    // Retrieving parts
    val numbersStrings2 = listOf("one", "two", "three", "four", "five", "six")
    println(numbersStrings2.slice(1..3))
    println(numbersStrings2.slice(0..4 step 2))
    println(numbersStrings2.slice(setOf(3, 5, 0)))

    // take and drop
    println(numbersStrings2.take(3))
    println(numbersStrings2.takeLast(3))
    println(numbersStrings2.drop(1))
    println(numbersStrings2.dropLast(5))

    println(numbersStrings2.takeWhile { !it.startsWith("f") })
    println(numbersStrings2.takeLastWhile { it != "three" })
    println(numbersStrings2.dropWhile { it.length == 3 })
    println(numbersStrings2.dropLastWhile { it.contains("i") })

    // chunked
    val numbers7 = (0..13).toList()
    println(numbers7.chunked(3))
    println(numbers7.chunked(3) { it.sum() })

    //windowed similar to chunked but more flexible
    val numbersString = numbersStrings2
    println(numbersString.windowed(3))

    //retrieving element
    val numbers8 = listOf("one", "two", "three", "four", "five")
    println(numbers8.elementAt(3))
    println(numbers8.first())
    println(numbers8.last())

    println(numbers8.first { it.length > 3 })
    println(numbers8.last { it.startsWith("f") })
    println(numbers8.random())
    println(numbers8.isEmpty())

    // ---------- //
    val numbers9 = mutableListOf<Int>(2, 5, 1, 40, 20, 100, 60)
    numbers9.sorted().forEach { println(it) }
    val laptops = mutableListOf(
        Laptop("Dell", 2021, 4, 600),
        Laptop("Acer", 2020, 8, 800),
        Laptop("Apple", 2022, 16, 1000)
    )

    laptops.sorted().forEach { println(it) }
    laptops.sortedWith(ComparatorRam()).forEach { println(it) }
    laptops.sortedWith(ComparatorYear()).forEach { println(it) }

    laptops.sortedWith(compareBy { it.price }).forEach { println(it) }
    laptops.sortedWith(compareBy { it.ram }).forEach { println(it) }
    laptops.sortedWith(compareBy { it.year }).forEach { println(it) }

    laptops.sortedBy { it.price }.forEach { println(it) }
    laptops.sortedBy { it.ram }.forEach { println(it) }
    laptops.sortedBy { it.year }.forEach { println(it) }

    laptops.sortedWith(compareBy<Laptop> { it.year }.thenBy { it.price }.thenBy { it.ram }).forEach { println(it) }
}

data class Laptop(val brand: String, val year: Int, val ram: Int, val price: Int) : Comparable<Laptop> {
    override fun compareTo(other: Laptop): Int {
        return if (this.price > other.price) {
            println("In if statement: Swapping ${this.brand} with ${other.brand}")
            1
        } else if (this.price < other.price) {
            println("In else if statement: Swapping ${this.brand} with ${other.brand}")

            -1
        } else {
            0
        }
    }

}

class ComparatorRam : Comparator<Laptop> {
    override fun compare(o1: Laptop, o2: Laptop): Int {
        return if (o1.ram > o2.ram) {
            1
        } else if (o1.ram < o2.ram) {
            -1
        } else {
            0
        }
    }

}

class ComparatorYear : Comparator<Laptop> {
    override fun compare(o1: Laptop, o2: Laptop): Int {
        return if (o1.year > o2.year) {
            1
        } else if (o1.year < o2.year) {
            -1
        } else {
            0
        }
    }

}