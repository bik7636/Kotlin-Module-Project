import java.util.*

abstract class HandleMenu {
    fun showOption(options: List<String>) {
        options.forEachIndexed { index, option -> println("-> ${index + 1}. $option") }
    }

    fun getUserInput(): String {
        return Scanner(System.`in`).nextLine()
    }
}