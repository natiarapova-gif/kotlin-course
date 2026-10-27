package org.example.lessons14

// 3. Природное явление: луна.
// Создайте объект Moon, который будет представлять Луну.
// Добавьте свойства isVisible (Boolean), чтобы отображать, видна ли Луна в данный момент,
// и phase (String), чтобы отображать текущую фазу Луны (например, "Full Moon", "New Moon").
// Добавьте метод showPhase(), который выводит текущую фазу Луны.


object Moon {
    var isVisible: Boolean = true
    var phase: String = "Full Moon"

    fun showPhase() {
        val visibility = if (isVisible) "видна" else "не видна"
        println("Луна $visibility. Текущая фаза: $phase")
    }
}