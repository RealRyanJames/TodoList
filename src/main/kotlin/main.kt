import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.io.File

fun main() {

    TimingSleep.greetingUser("Welcome to My Todo List Application")
    loop@ while (true) {

        TimingSleep.setSleep()
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
    IsCreated.created(f)
    f.writeText(todo)
}

object IsCreated {
    fun created(file: File) {

        if (file.exists()) {
            PrintLines.printLines("Created Already")
        }
    }
}

object PrintLines {

    fun printLines(message: String) {
        println(message.uppercase())
    }
}

object TimingSleep {

    fun greetingUser(personName: String = "App's User") {
        PrintLines.printLines(personName)
    }

    fun setSleep() = runBlocking {

        withContext(Dispatchers.IO) {
            Thread.sleep(1 * 4000)
        }
    }
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