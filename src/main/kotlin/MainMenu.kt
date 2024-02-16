import java.util.*

class MainMenu : HandleMenu() {
    private val archives = mutableListOf<NoteArchive>()

    fun run() {
        while (true) {
            val mainMenu = MainMenu()
            val mainMenuOptions = arrayListOf("Создать архив", "Выбрать архив", "Выход")
            showOption(mainMenuOptions)

            when (val userInput = mainMenu.getUserInput()) {
                "1" -> {
                    var archiveName: String
                    do {
                        println("Введите название архива:")
                        archiveName = getUserInput()
                    } while (archiveName.isBlank())

                    archives.add(NoteArchive(archiveName))
                }

                "2" -> {
                    val selectedArchive = selectArchive(archives)
                    if (selectedArchive != null) {
                        handleArchive(selectedArchive)
                    } else {
                        println("Некорректный ввод")
                    }
                }

                "3" -> return
                else -> {
                    if (!userInput.all { it.isDigit() }) {
                        println("Пожалуйста, введите цифру.")
                    } else {
                        println("Нет такого пункта. Пожалуйста, выберите корректный пункт меню.")
                    }
                }
            }
        }
    }

    private fun selectArchive(archives: List<NoteArchive>): NoteArchive? {

        val scanner = Scanner(System.`in`)
        println("Доступные архивы:")
        archives.forEachIndexed { index, archive ->
            println("${index + 1}. ${archive.name}")
        }
        println("Выберите номер архива (или введите 0 для выхода):")
        val input = scanner.nextLine()
        val archiveIndex = input.toIntOrNull()
        return if (archiveIndex != null && archiveIndex in 1..archives.size) {
            archives[archiveIndex - 1]
        } else {
            null
        }
    }

    private fun handleArchive(selectedArchive: NoteArchive) {
        while (true) {
            val noteMenu = arrayListOf("Добавить заметку", "Просмотреть заметки", "Назад")
            showOption(noteMenu)

            when (getUserInput()) {
                "1" -> {
                    val newNote = Note.createNote()
                    selectedArchive.notes.add(newNote)
                }

                "2" -> {
                    selectedArchive.viewNotes()
                }

                "3" -> return
                else -> println("Некорректный ввод")
            }
        }
    }
}