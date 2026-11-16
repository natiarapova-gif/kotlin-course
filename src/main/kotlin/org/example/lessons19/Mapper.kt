package org.example.lessons19

interface Mapper<F, T> {
    // Преобразование одного элемента
    fun map(element: F): T

    // Преобразование списка элементов
    fun map(list: List<F>): List<T>
}