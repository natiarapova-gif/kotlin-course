package org.example.lessons15.Materials

//Это класс контейнера.
//Он абстрактный, это означает, что нельзя создавать экземлпяр этого класса, он нужен только для того,
//чтобы быть основой для подклассов.

//Создай подклассы этого контейнера, которые будут добавлять строку material (или коллекции или словари строк)
//в какое-то определённое место (места).

abstract class Materials {
    // Изменено с private на protected, чтобы наследники имели доступ к списку
    protected val materials = mutableListOf<String>()

    open fun addMaterial(material: String) {
        materials.add(material)
    }

    // Перегрузка для списков (нужна для второго класса)
    open fun addMaterials(newMaterials: List<String>) {
        newMaterials.forEach { addMaterial(it) }
    }

    // Перегрузка для словарей (нужна для четвертого класса)
    open fun addMaterials(dictionary: Map<String, String>) {
        dictionary.forEach { (key, value) ->
            addMaterial(key)
            addMaterial(value)
        }
    }

    fun extractMaterials(): List<String> {
        val extracted = materials.toList()
        materials.clear()
        return extracted
    }

    fun printContainer() {
        materials.forEachIndexed { index, layer ->
            println("[$index]: $layer")
        }
    }
}