package org.example.lesson11

// Задачи на сигнатуру метода
// Напишите сигнатуру метода в которую входит модификатор доступа, название функции, список аргументов с типами и возвращаемое значение.
// В теле метода можешь сделать возврат объекта нужного типа если это требуется для устранения ошибок.

// 1.Не принимает аргументов и не возвращает значения.
public fun doSomething(): Unit { }

// 2.Принимает два целых числа и возвращает их сумму.
public fun sum(a: Int, b: Int): Int {
    return a + b
}

// 3.Принимает строку и ничего не возвращает.
public fun printString(text: String): Unit {
    println(text)
}

// 4.Принимает список целых чисел и возвращает среднее значение типа Double.
public fun average(numbers: List<Int>): Double {
    return numbers.average()
}

// 5.Принимает nullable строку и возвращает её длину в виде nullable целого числа и доступна только в текущем файле.
private fun nullableStringLength(input: String?): Int? {
    return input?.length
}

// 6.Не принимает аргументов и возвращает nullable вещественное число.
public fun getNullableDouble(): Double? {
    return null
}

// 7.Принимает nullable список целых чисел, не возвращает значения и доступна только в текущем файле.
private fun processNullableList(list: List<Int>?): Unit { }

// 8.Принимает целое число и возвращает nullable строку.
public fun intToNullableString(value: Int): String? {
    return value.toString()
}

// 9.Не принимает аргументов и возвращает список nullable строк.
public fun getNullableStringList(): List<String?> {
    return listOf(null, "hello")
}

// 10.Принимает nullable строку и nullable целое число и возвращает nullable булево значение.
public fun checkNullable(input: String?, number: Int?): Boolean? {
    return if (input != null && number != null) input.length == number else null
}

// Задачи на написание кода
// Напишите валидную сигнатуру метода а так же рабочий код для задач.

// 11.Напишите функцию multiplyByTwo, которая принимает целое число и возвращает его, умноженное на 2.
public fun multiplyByTwo(number: Int): Int {
    return number * 2
}

// 12.Создайте функцию isEven, которая принимает целое число и возвращает true, если число чётное, и false в противном случае.
public fun isEven(number: Int): Boolean {
    return number % 2 == 0
}

// 13.Напишите функцию printNumbersUntil, которая принимает целое число n и выводит на экран числа от 1 до n.
// Если число n меньше 1, функция должна прекратить выполнение с помощью return без вывода сообщений.
public fun printNumbersUntil(n: Int) {
    if (n < 1) return
    for (i in 1..n) {
        println(i)
    }
}

// 14. Создайте функцию findFirstNegative, которая принимает список целых чисел и возвращает первое отрицательное число в списке.
// Если отрицательных чисел нет, функция должна вернуть null.
public fun findFirstNegative(numbers: List<Int>): Int? {
    for (number in numbers) {
        if (number < 0) return number
    }
    return null
}

// 15. Напишите функцию processList, которая принимает список строк. Функция должна проходить по списку и выводить каждую строку.
// Если встречается null значение, функция должна прекратить выполнение с помощью return без возврата значения.
public fun processList(list: List<String?>) {
    for (item in list) {
        if (item == null) return
        println(item)
    }
}