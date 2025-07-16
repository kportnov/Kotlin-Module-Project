import MenuProcessor.currentArchive
import MenuProcessor.currentNote
import java.util.Scanner

object InputHandler {
    private fun readNumber() = Scanner(System.`in`).nextLine().toIntOrNull()

    private fun readText(): String {
        var input = Scanner(System.`in`).nextLine()
        while (input.isEmpty()) {
            println("Ввод пустой, попробуйте снова")
            input = Scanner(System.`in`).nextLine()
        }
        return input
    }

    private fun handleWrongNumberInput(number: Int?, list: MutableList<out Item>) {
        if (number == null) {
            println("Вам следовало бы ввести цифру")
        } else {
            if (list.size == 0) {
                if (action == Action.ARCHIVES || action == Action.NOTES || action == Action.OPEN_NOTE) {
                    println("Цифра должна быть от 0 до 1\n")
                } else {
                    println("Допустимый ввод - \"0\"\n")
                }
            } else {
                println("Цифра должна быть от 0 до ${list.size + 1}\n")
            }
        }
    }

    fun notes() {
        when (val number = readNumber()) {
            0 -> action = Action.CREATE_NOTE
            archiveList[currentArchive].notes.size + 1 -> action = Action.ARCHIVES
            in 1..archiveList[currentArchive].notes.size -> {
                currentNote = number!! - 1
                action = Action.OPEN_NOTE
            }
            else -> {
                handleWrongNumberInput(number, archiveList[currentArchive].notes)
            }
        }
    }


    fun archives() {
        when (val number = readNumber()) {
            0 -> action = Action.CREATE_ARCHIVE
            archiveList.size + 1 -> action = Action.EXIT
            in 1..archiveList.size -> {
                currentArchive = number!! - 1
                action = Action.NOTES
            }
            else -> handleWrongNumberInput(number, archiveList)
        }
    }

    fun showNote() {
        when (val number = readNumber()) {
            0 -> action = Action.OPEN_NOTE
            else -> handleWrongNumberInput(number, mutableListOf())
        }
    }

    fun openNote() {
        when (val number = readNumber()) {
            0 -> action = Action.SHOW_NOTE
            1 -> action = Action.NOTES
            else -> handleWrongNumberInput(number, mutableListOf())
        }
    }

    fun createArchive() {
        println("Введите название архива:")
        archiveList.add(Archive(readText()))
        println("Архив создан\n")

        action = Action.ARCHIVES
    }

     fun createNote() {
        println("Введите название заметки:")
        val name = readText()
        println("Введите текст заметки:")
        val text = readText()
        archiveList[currentArchive].notes.add(Note(name, text))
        println("Заметка создана\n")

        action = Action.NOTES
    }
}