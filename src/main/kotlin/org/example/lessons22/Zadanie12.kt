package org.example.lessons22

fun main() {
    try {
        val list = listOf(1, 2, 3)
        println(list[10]) // провоцируем IndexOutOfBoundsException
    } catch (e: IndexOutOfBoundsException) {
        println("Поймано IndexOutOfBoundsException: ${e.message}")
        throw CustomIndexException(e)
    }
}