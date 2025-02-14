import java.nio.file.DirectoryStream.Filter
//Part 2: Filtering Strings with Lambda
fun filterNames(names: List<String>, filtered: (String) -> Boolean): List<String>{
    return names.filter(filtered)
}

//Part 4: Customizing the Filter of a List
fun customFilter(numbers: List<Int>, filter: (Int) -> Boolean): List<Int>{
    return numbers.filter(filter)
}

//Part 5: Combining Lambdas
fun processNumbers(numbers: List<Int>,filter: (Int) -> Boolean ): List<Int>{
    return numbers.filter(filter).filter(filter)
}

//Bonus
fun processNumbers(numbers: List<Int>,filter: (Int) -> Boolean, transform: (Int) -> Int ): List<Int>{
    return numbers.filter(filter).map(transform)
}



fun main() {

    //Part 1: Lambda with List Transformation
    val listOfNumbers = listOf(1,2,3,4,5,6,7,8,9,10)
    val doubledNumbers = listOfNumbers.map { it * 2 }
    println(doubledNumbers)

    //Part 2: Filtering Strings with Lambda
    val names = listOf("Alice", "Bob", "Amir", "Charlie", "Annie", "David")
    val filteredNames = filterNames(names) { it.startsWith('A') }
    println(filteredNames)

    //Part 3: Sorting with Custom Lambda
    val words = listOf("apple", "banana", "kiwi", "strawberry", "grape")
    val sortedList = words.sortedByDescending { it.length }
    println(sortedList)

    //Part 4: Customizing the Filter of a List
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val greaterThan5 = customFilter(numbers) {it > 5}
    val evenNumbers =  customFilter(numbers) {it % 2 == 0}
    val multiplesOf3 = customFilter(numbers) {it % 3 ==0}

    println(greaterThan5)
    println(evenNumbers)
    println(multiplesOf3)

    //Part 5: Combining Lambdas
    // I'm reusing numbers parameter from part 4
    val processedNumbers = processNumbers(numbers) {it % 2 != 0}.map { it * it }
    println(processedNumbers)

    //Bonus
    val processedNumbersBonus = processNumbers(numbers, { it % 2 != 0 }, { it * it })
    println(processedNumbers)

}
