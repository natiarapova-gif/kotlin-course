package org.example.lessons19

class ListHolder<T> {
    // Внутренний изменяемый список
    private val items = mutableListOf<T>()

    fun add(item: T) {
        items.add(item)
    }

    // Возвращаем копию списка (toList), чтобы снаружи его нельзя было изменить
    fun getAll(): List<T> {
        return items.toList()
    }
}