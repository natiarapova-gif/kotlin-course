package org.example.lessons14


//1. Событие: вечеринка.
//Создайте класс Party, который описывает вечеринку.
//У него должны быть свойства location (String) и attendees (Int).
//Добавьте метод details(), который выводит информацию о месте проведения и количестве гостей.

class Party(
    val location: String,
    val attendees: Int
) {
    fun details() {
        println("Вечеринка проходит в: $location")
        println("Количество гостей: $attendees")
    }
}