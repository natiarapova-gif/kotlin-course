package org.example.lessons19

class PhrasesToListOfStrings : Mapper<String, List<String>> {

    override fun map(element: String): List<String> {
        // Разбиваем строку по пробелу
        return element.split(" ")
    }

    override fun map(list: List<String>): List<List<String>> {
        // Применяем метод map к каждому элементу списка
        return list.map { map(it) }
    }
}