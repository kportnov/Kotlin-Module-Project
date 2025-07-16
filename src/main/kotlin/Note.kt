abstract class Item(open val name: String)

class Note(override val name: String, val text: String) : Item(name) {

    override fun toString(): String {
        return "Заметка \"$name\"\n$text\n"
    }
}

 class Archive(override val name: String): Item(name) {
     val notes = mutableListOf<Note>()
 }

