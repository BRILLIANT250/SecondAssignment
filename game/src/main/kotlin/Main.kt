class Game(val position: Int, val color: Int)
//Function to insert players Nmae
fun playerName(name: String): String {
    println("Enter $name Player's Name: ")
    return readLine() ?: "Player"
}
fun input(playerName: String): List<Char> {
    println("$playerName Enter 4 Secret Letter From Six( R B Y G O W): ")
    val letter = readLine()?.toUpperCase() ?: ""//Converting inserted String into Uppercase
    return letter.toList()//converting user insertion into List
}
fun getResult(playerName: String): List<Char> {
    println("$playerName Guess 4 Letters From Six Letters(R B Y G O W) : ")
    val code = readLine()?.toUpperCase() ?: ""
    return code.toList()
}
//this function will check if two list are equal to check position and color
fun correctResult(list1: List<Char>, list2: List<Char>): Game {
    var position = 0
    var color = 0

    for (i in list1.indices) {
        if (list2[i] == list1[i]) {
            position++
        } else if (list2[i] in list2) {
            color++
        }
    }
    val rl1 = list1.toMutableList()
    val rl2 = list2.toMutableList()

    for (i in 0..<rl1.size) {
        if (rl1.contains(rl2[i])) {
            color++
            rl1.remove(rl2[i])
        }
    }

    return Game(position, color)
}

fun main() {
    //PlayerName Function Calling
    val name1 = playerName("First")
    val name2 = playerName("Second")
    val list1 = input(name1)
    //Counting Correct Position and colors from List2 compared to List1
    var correctGuess = false
    for (count in 1..Int.MAX_VALUE) {
        val list2 = getResult(name2)
        val result = correctResult(list1, list2)
        println("Feedback: ${result.position} correct position, ${result.color} correct color")
        if (result.position == 4) {
            correctGuess = true
            println("Congratulations, $name2 Your Guess Is Correct, $name1 Lost.")
            break//quitting loop because two lists are equal
        }
    }
}