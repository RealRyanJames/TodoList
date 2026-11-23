import java.io.File

fun main() {
    loop@ while (true) {

        (1..3 step 1).forEach { el ->
            println("Enter Todos: $el")
            val todoFirst = readln()

            val todos: ArrayList<String> = AppendTodos.appendTodos()
            todos.add(todoFirst)

            if (Empty.isEmpty(todos.toString())) {
                println("Empty Message".uppercase())
            } else if (todos.equals("Break")) {
                break@loop
            }

            todos.forEachIndexed { index, todo ->
                println(index)
                println(todo.uppercase())

                createFile(todo)
            }
        }
    }
}

fun createFile(todo: String) {
    val f = File("main.txt")
    f.writeText(todo)
}

object Empty {

    fun isEmpty(message: String): Boolean {
        return message.isEmpty()
    }
}

object AppendTodos {

    fun appendTodos(): ArrayList<String> {

        val todos: ArrayList<String> = ArrayList()
        return todos
    }
}