class Note(val title: String, val content: String) : HandleMenu() {


    companion object {
        fun createNote(): Note {
            val note = Note("", "")
            var title: String
            do {
                println("Введите название заметки:")
                title = note.getUserInput()
                if (title.isBlank()) {
                    println("Название заметки не может быть пустым.")
                }
            } while (title.isBlank())

            var content: String
            do {
                println("Введите содержимое заметки:")
                content = note.getUserInput()
                if (content.isBlank()) {
                    println("Содержание заметки не может быть пустым. Введите содержимое заметки:")
                }
            } while (content.isBlank())

            return Note(title, content)
        }
    }
}