package org.example.lessons15.Materials

// 5. Второй класс должен получать список строк и вставлять их в начало контейнера но поочерёдно с теми данными,
//которые уже есть.
//То-есть, наш список должен появиться в контейнере по индексам 0, 2, 4 и так далее.

class InterleavedMaterials : Materials() {
    override fun addMaterials(newMaterials: List<String>) {
        val oldMaterials = materials.toList()
        materials.clear()

        var oldIndex = 0
        var newIndex = 0

        // Пока есть элементы хотя бы в одном списке
        while (oldIndex < oldMaterials.size || newIndex < newMaterials.size) {
            // Сначала добавляем новый элемент (на позиции 0, 2, 4...)
            if (newIndex < newMaterials.size) {
                materials.add(newMaterials[newIndex])
                newIndex++
            }
            // Затем существующий (на позиции 1, 3, 5...)
            if (oldIndex < oldMaterials.size) {
                materials.add(oldMaterials[oldIndex])
                oldIndex++
            }
        }
    }
}