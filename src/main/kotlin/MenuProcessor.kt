object MenuProcessor {
    var currentArchive = -1
    var currentNote = -1

    private fun printItems(list: MutableList<out Item>) {
        val name1 = if (action == Action.ARCHIVES) "архивов" else "заметок"
        val name2 = if (action == Action.ARCHIVES) "архив" else "заметку"
        println("Список $name1\n0. Создать $name2")
        list.forEachIndexed { index, item -> println("${index + 1}. ${item.name}") }
        println("${list.size + 1}. Выход\n")
    }

    fun showArchiveMenu() {
        printItems(archiveList)
    }

    fun showNotesMenu() {
        println("Архив \"${archiveList[currentArchive].name}\"")
        printItems(archiveList[currentArchive].notes)
    }

    fun showOpenNoteMenu() {
        println("Архив \"${archiveList[currentArchive].name}\", " +
                "Заметка \"${archiveList[currentArchive].notes[currentNote].name}\"\n")
        println("0. Открыть\n1. Выход")
    }

    fun showNoteMenu() {
        println(archiveList[currentArchive].notes[currentNote])
        println("0. Выход")
    }
}