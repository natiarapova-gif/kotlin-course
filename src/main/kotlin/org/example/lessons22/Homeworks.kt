package org.example.lessons22

//Воспроизвести фрагменты кода, которые могут привести к возникновению исключений:

//1. NullPointerException
fun main() {
    val str: String? = null
    println(str!!.length)

//2. IndexOutOfBoundsException
    val list = listOf(1, 2, 3)
    println(list[5])
//3. ClassCastException
    val obj: Any = "строка"
    val number: Int = obj as Int
//4. IllegalArgumentException
    require(false) { "Некорректный аргумент" }
//5. NumberFormatException
    val n = "не число".toInt()
//6. IllegalStateException
    check(false) { "Некорректное состояние" }
//7. OutOfMemoryError
    val hog = mutableListOf<LongArray>()
    while (true) hog.add(LongArray(10_000_000))
//8. StackOverflowError
fun recurse(): Int = recurse() + 1
    recurse()
}

//Задание 9. Оберни все вызовы из предыдущего задания в блок try-catch и создай для каждого типа ошибки свой catch блок

fun demonstrateAllExceptions() {
    try {
        val str: String? = null
        str!!.length
    } catch (e: NullPointerException) {
        println("Поймано NullPointerException: ${e.message}")
    }

    try {
        listOf(1, 2, 3)[5]
    } catch (e: IndexOutOfBoundsException) {
        println("Поймано IndexOutOfBoundsException: ${e.message}")
    }

    try {
        val obj: Any = "строка"
        obj as Int
    } catch (e: ClassCastException) {
        println("Поймано ClassCastException: ${e.message}")
    }

    try {
        require(false) { "Некорректный аргумент" }
    } catch (e: IllegalArgumentException) {
        println("Поймано IllegalArgumentException: ${e.message}")
    }

    try {
        "не число".toInt()
    } catch (e: NumberFormatException) {
        println("Поймано NumberFormatException: ${e.message}")
    }

    try {
        check(false) { "Некорректное состояние" }
    } catch (e: IllegalStateException) {
        println("Поймано IllegalStateException: ${e.message}")
    }

    try {
        val hog = mutableListOf<LongArray>()
        while (true) hog.add(LongArray(10_000_000))
    } catch (e: OutOfMemoryError) {
        println("Поймано OutOfMemoryError: ${e.message}")
    }

    try {
        fun recurse(): Int = recurse() + 1
        recurse()
    } catch (e: StackOverflowError) {
        println("Поймано StackOverflowError: ${e.message}")
    }
}

fun main() = demonstrateAllExceptions()

//Задание 10. Напиши функцию, которая принимает nullable аргумент типа Any и в блоке try/catch выполни набор действий с этим аргументом которые могут потенциально вызвать одно из исключений в этом же порядке:

fun analyzeArgument(arg: Any?) {
    try {
        // 1. NullPointerException
        val nonNull: Any = arg!!

        // 2. IndexOutOfBoundsException
        if (nonNull is List<*>) {
            nonNull[0] // упадёт, если список пустой
        }

        // 3. ClassCastException
        val asString = nonNull as String

        // 4. IllegalArgumentException
        require(asString.isNotBlank()) { "Строка пустая" }

        // 5. NumberFormatException
        val num = asString.toInt()

        // 6. IllegalStateException
        check(num > 0) { "Число должно быть положительным" }

        println("Переданный аргумент фантастически хорош!")
    } catch (e: Throwable) {
        when (e) {
            is NullPointerException       -> println("Поймано: NullPointerException — ${e.message}")
            is IndexOutOfBoundsException  -> println("Поймано: IndexOutOfBoundsException — ${e.message}")
            is ClassCastException         -> println("Поймано: ClassCastException — ${e.message}")
            is NumberFormatException      -> println("Поймано: NumberFormatException — ${e.message}")
            is IllegalArgumentException   -> println("Поймано: IllegalArgumentException — ${e.message}")
            is IllegalStateException      -> println("Поймано: IllegalStateException — ${e.message}")
            else                          -> println("Поймано: ${e::class.simpleName} — ${e.message}")
        }
        throw e // прекращаем работу программы
    }
}

fun main() {
    analyzeArgument(null)               // NPE
    // analyzeArgument(emptyList<Any>()) // IOOBE
    // analyzeArgument(mapOf(1 to 2))    // CCE
    // analyzeArgument("")               // IAE
    // analyzeArgument("abc")            // NFE
    // analyzeArgument("0")              // ISE
    // analyzeArgument("42")             // «фантастически хорош!»
}
//NullPointerException
//IndexOutOfBoundsException
//ClassCastException
//IllegalArgumentException
//NumberFormatException
//IllegalStateException
//В блоке catch перехватывай исключение с общим типом Throwable а внутри через when определи тип исключения и выведи сообщение с названием исключения. Сразу после when выброси перехваченное исключение через throw, чтобы прекратить работу программы.
//Если аргумент функции не вызвал исключение, то выведи текст, сообщающий что переданный аргумент фантастически хорош!
