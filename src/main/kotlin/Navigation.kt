var action = Action.START
val archiveList = mutableListOf<Archive>()

object Navigation {

    fun menu() {

        while (true) {
            when (action) {

                Action.START -> {
                    println("Программа запущена\n")
                    action = Action.ARCHIVES
                }

                Action.ARCHIVES -> {
                    MenuProcessor.showArchiveMenu()
                    InputHandler.archives()
                }

                Action.NOTES -> {
                    MenuProcessor.showNotesMenu()
                    InputHandler.notes()
                }

                Action.OPEN_NOTE -> {
                    MenuProcessor.showOpenNoteMenu()
                    InputHandler.openNote()
                }

                Action.SHOW_NOTE -> {
                    MenuProcessor.showNoteMenu()
                    InputHandler.showNote()
                }

                Action.CREATE_ARCHIVE -> {
                    InputHandler.createArchive()
                }

                Action.CREATE_NOTE -> {
                    InputHandler.createNote()
                }

                Action.EXIT -> {
                    println("Программа завершена")
                    break
                }
            }
        }
    }
}