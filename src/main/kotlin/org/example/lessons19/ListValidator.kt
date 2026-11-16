package org.example.lessons19

// T ограничен типом Number
class ListValidator<T : Number> : Validator<List<T?>> {
    override fun validate(element: List<T?>): Boolean {
        // Проверяем каждый элемент списка
        return element.all { item ->
            // Элемент не null И приведенный к Double не равен 0.0
            item != null && item.toDouble() != 0.0
        }
    }
}