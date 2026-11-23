package org.example.lessons21

//Задача 1
//Напишите функцию analyzeDataType, принимающую параметр типа Any. Функция должна определить тип аргумента и вывести соответствующее сообщение:
//Для строки: "Это строка: [значение]".
//Для любого числа: "Это число: [значение]".
//Для списка: "Это список, количество элементов: [количество]".
//Для словаря: "Это словарь, количество пар: [количество]".
//Для остальных типов: "Неизвестный тип данных".
//Используйте оператор is для проверки типов.

fun analyzeDataType(data: Any) {
    when (data) {
        is String -> println("Это строка: $data")
        is Number -> println("Это число: $data")
        is List<*> -> println("Это список, количество элементов: ${data.size}")
        is Map<*, *> -> println("Это словарь, количество пар: ${data.size}")
        else -> println("Неизвестный тип данных")
    }
}

//Задача 2
//Создайте функцию safeCastToList, принимающую параметр типа Any и возвращающую размер списка, если аргумент можно безопасно привести к типу List.
//В случае неудачного приведения функция должна возвращать -1. Используйте as? для безопасного приведения типа.

fun safeCastToList(data: Any): Int {
    val list = data as? List<*>
    return list?.size ?: -1
}


//Задача 3
//Создайте функцию getStringLengthOrZero, которая принимает параметр типа Any? и возвращает длину строки, если аргумент можно привести к типу String.
//В случае, если аргумент равен null или не является строкой, функция должна возвращать 0.

fun getStringLengthOrZero(data: Any?): Int {
    return (data as? String)?.length ?: 0
}

//Задача 4
//Создайте функцию-расширение класса Any toSquare.
//Функция гарантированно вызывается у числа (в виде числа или строки, например 4 или 4.2 или “4.2”) и должна вернуть квадрат этого числа.
//Если придёт число, его нужно возвести в квадрат, если придёт строка, то его нужно преобразовать в число через функцию toDouble() и возвести в квадрат.

fun Any.toSquare(): Double {
    return when (this) {
        is Number -> {
            val number = this.toDouble()
            number * number
        }

        is String -> {
            val number = this.toDouble()
            number * number
        }

        else -> throw IllegalArgumentException("Ожидалось число или строка с числом")
    }
}

//Задача 5
//Напишите функцию sumIntOrDoubleValues, которая принимает список элементов типа Any и возвращает сумму всех целочисленных (Int) и вещественных (Double) значений в списке.
//Все остальные типы должны быть проигнорированы.

fun sumIntOrDoubleValues(items: List<Any>): Double {
    var sum = 0.0

    for (item in items) {
        when (item) {
            is Int -> sum += item
            is Double -> sum += item
        }
    }

    return sum
}

//Задача 6
//Создайте функцию tryCastToListAndPrint, которая принимает параметр типа Any и пытается привести его к типу List<*>.
//Если приведение успешно, функция должна напечатать все строки из списка, если элемент не является строкой то вывести предупреждение об этом.
//Если приведение неудачно, должно быть выведено сообщение об ошибке, не прерывая выполнение программы.

fun tryCastToListAndPrint(data: Any) {
    val list = data as? List<*>

    if (list == null) {
        println("Ошибка: объект нельзя привести к List<*>")
        return
    }

    for (item in list) {
        if (item is String) {
            println(item)
        } else {
            println("Предупреждение: элемент не является строкой: $item")
        }
    }
}

fun main() {
    println("Задача 1")
    analyzeDataType("Kotlin")
    analyzeDataType(42)
    analyzeDataType(3.14)
    analyzeDataType(listOf(1, 2, 3))
    analyzeDataType(mapOf("a" to 1, "b" to 2))
    analyzeDataType(true)

    println("\nЗадача 2")
    println(safeCastToList(listOf(1, 2, 3))) // 3
    println(safeCastToList("not a list"))    // -1

    println("\nЗадача 3")
    println(getStringLengthOrZero("Kotlin")) // 6
    println(getStringLengthOrZero(123))      // 0
    println(getStringLengthOrZero(null))     // 0

    println("\nЗадача 4")
    println(4.toSquare())      // 16.0
    println(4.2.toSquare())    // 17.64
    println("4.2".toSquare())  // 17.64

    println("\nЗадача 5")
    println(sumIntOrDoubleValues(listOf(1, 2.5, "Kotlin", 3, true, 4.0))) // 10.5

    println("\nЗадача 6")
    tryCastToListAndPrint(listOf("Kotlin", 42, "Java", true))
    tryCastToListAndPrint("not a list")
}