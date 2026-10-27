package org.example.lessons14

// 2. Аспект реальности: эмоция. Создайте класс Emotion, который представляет эмоцию.
//У него должно быть свойство type (String) и intensity (Int).
//Добавьте метод express(), который выводит описание эмоции в зависимости от её типа и интенсивности.


class Emotion(
    val type: String,
    val intensity: Int
) {
    fun express() {
        val level = when {
            intensity <= 3 -> "слабо"
            intensity <= 7 -> "умеренно"
            else -> "очень сильно"
        }

        println("Эмоция \"$type\" выражается $level (интенсивность: $intensity).")
    }
}