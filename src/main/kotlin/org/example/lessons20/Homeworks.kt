package org.example.lessons20

import kotlin.math.absoluteValue

// ===== 1. Расширение для массива (первый и последний элемент) =====
fun <T> Array<T>.firstAndLast(): Pair<T?, T?> {
    if (this.isEmpty()) return Pair(null, null)
    return Pair(this.first(), this.last())
}

// ===== 2. Расширение для MutableList с сортировкой =====
fun <T : Comparable<T>> MutableList<T>.sortAndFreeze(ascending: Boolean): List<T> {
    // sort() и sortDescending() сортируют список на месте (in-place)
    if (ascending) {
        this.sort()
    } else {
        this.sortDescending()
    }
    // Возвращаем неизменяемую копию (toList)
    return this.toList()
}

// ===== 3. Расширение для nullable словаря =====
fun <K, V> Map<K, List<V>>?.extractToStringKeys(index: Int): Map<String, V?>? {
    if (this == null) return null

    // mapKeys преобразует ключи, mapValues преобразует значения
    return this.mapKeys { (key, _) -> key.toString() }
        .mapValues { (_, list) -> list.getOrNull(index) }
    // getOrNull(index) безопасно вернет null, если индекса нет
}

// ===== 4. Расширение для Number (within) =====
fun Number.within(other: Number, deviation: Number): Boolean {
    // Считаем разницу, берем модуль (absoluteValue) и сравниваем с отклонением
    val difference = (this.toDouble() - other.toDouble()).absoluteValue
    return difference <= deviation.toDouble()
}

// ===== 5. Расширения для String (шифрование/дешифрование) =====
fun String.encrypt(base: Int): String {
    // Прибавляем к каждому символу (Char) число base
    return this.map { (it + base) }.joinToString("")
}

fun String.decrypt(base: Int): String {
    // Вычитаем из каждого символа (Char) число base
    return this.map { (it - base) }.joinToString("")
}

// ===== 6. Расширение для String (вывод как в Твиттере) =====
fun String.printTwitterStyle(authors: List<String>) {
    if (authors.isEmpty()) {
        println("Список авторов пуст!")
        return
    }

    // Переводим строку в верхний регистр и идем по каждой букве
    this.uppercase().forEachIndexed { index, char ->
        // Берем автора по кругу, если букв больше, чем авторов
        val author = authors[index % authors.size]
        println("$author:")
        println(char)
        println()
    }
}


// ================= ТЕСТИРОВАНИЕ =================
fun main() {
    println("--- 1. Массив ---")
    val arr = arrayOf(10, 20, 30, 40)
    val emptyArr = arrayOf<Int>()
    println(arr.firstAndLast())       // (10, 40)
    println(emptyArr.firstAndLast())  // (null, null)

    println("\n--- 2. MutableList ---")
    val mutableList = mutableListOf(5, 1, 8, 3)
    val immutableAsc = mutableList.sortAndFreeze(true)
    println("По возрастанию: $immutableAsc, исходный стал: $mutableList")

    val immutableDesc = mutableList.sortAndFreeze(false)
    println("По убыванию: $immutableDesc")

    println("\n--- 3. Nullable Map ---")
    val map: Map<Int, List<String>>? = mapOf(1 to listOf("A", "B", "C"), 2 to listOf("X"))
    println(map.extractToStringKeys(1))  // {1=C, 2=null}
    println(map.extractToStringKeys(0))  // {1=A, 2=X}

    val nullMap: Map<Int, List<String>>? = null
    println(nullMap.extractToStringKeys(1)) // null

    println("\n--- 4. Number within ---")
    println(10.within(12, 2.5))      // true (разница 2, отклонение 2.5)
    println(10.within(15, 2))        // false (разница 5, отклонение 2)
    println(100.5f.within(100, 1))   // true
    println(5.within(5, 0))          // true

    println("\n--- 5. Encrypt / Decrypt ---")
    val original = "Hello"
    val encrypted = original.encrypt(3) // сдвиг на 3 символа
    val decrypted = encrypted.decrypt(3)
    println("Оригинал: $original")
    println("Зашифровано: $encrypted")
    println("Расшифровано: $decrypted")

    println("\n--- 6. Twitter Style ---")
    // Взял строку из скриншота
    val secretWord = "Пидар"
    val authors = listOf("groteck", "Асахи Кобэ", "комната", "Avocado1")
    secretWord.printTwitterStyle(authors)
}


// Пояснения по коду:
//firstAndLast(): Если массив пуст, isEmpty() вернёт true, и мы вернём пару из null. В остальных случаях first() и last() вернут нужные элементы.
//
//sortAndFreeze(): Методы sort() и sortDescending() у MutableList ничего не возвращают, они изменяют список "на месте". Поэтому мы сначала сортируем this, а потом возвращаем this.toList() (копию в виде неизменяемого List).
//
//extractToStringKeys(): Метод mapKeys позволяет поменять все ключи словаря, применив к ним функцию. mapValues делает то же самое со значениями. list.getOrNull(index) — безопасный способ получить элемент (вернёт null, если индекса не существует, не выбрасывая Exception).
//
//within(): Мы приводим оба числа к Double, вычитаем, берем absoluteValue (модуль) и проверяем <= deviation.toDouble().
//
//encrypt / decrypt: В Kotlin Char + Int возвращает новый Char (сдвинутый по таблице Unicode). map проходит по каждому символу, а joinToString("") собирает строку обратно.
//
//printTwitterStyle(): Функция forEachIndexed даёт нам и индекс, и сам символ. Оператор % (остаток от деления) позволяет брать авторов по кругу: если букв больше, чем имён, он снова начнёт с первого автора. Выводим в столбик с пустой строкой для красоты.