class NoteArchive(val name: String) : HandleMenu() {

    val notes = mutableListOf<Note>()
    fun viewNotes() {
        val noteArchive = NoteArchive("")
        if (notes.isEmpty()) {
            println("Нет заметок в данном архиве")
        } else {
            println("Заметки в архиве $name:")
            notes.forEachIndexed { index, note ->
                println("${index + 1}. ${note.title}")
            }
            println("Введите номер заметки для просмотра (или введите 0 для выхода):")
            val input = noteArchive.getUserInput()
            val noteIndex = input.toIntOrNull()
            if (noteIndex != null && noteIndex in 1..notes.size) {
                val selectedNote = notes[noteIndex - 1]
                println("Заголовок: ${selectedNote.title}\nСодержимое: ${selectedNote.content}")
            }
        }
    }
}