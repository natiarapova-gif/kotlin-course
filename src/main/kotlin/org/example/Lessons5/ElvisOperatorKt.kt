package org.example.Lessons5

fun main() {
    println("--- Задача 1: Затухание звука ---")
    // Начальная интенсивность 100, коэффициент неизвестен (null)
    val intensity1 = calculateIntensity(100.0, null)
    println("При неизвестном коэффициенте: $intensity1 (ожидается 50.0)")

    // Начальная интенсивность 100, коэффициент 0.8
    val intensity2 = calculateIntensity(100.0, 0.8)
    println("При известном коэффициенте 0.8: $intensity2 (ожидается 80.0)")


    println("\n--- Задача 2: Стоимость доставки ---")
    // Базовая стоимость доставки 10, стоимость груза неизвестна (null)
    val cost1 = calculateDeliveryCost(10.0, null)
    println("При неизвестной стоимости груза: $cost1 (ожидается 10.25)")

    // Базовая стоимость доставки 10, стоимость груза 200
    val cost2 = calculateDeliveryCost(10.0, 200.0)
    println("При стоимости груза 200: $cost2 (ожидается 11.0)")


    println("\n--- Задача 3: Атмосферное давление ---")
    // Показания есть
    printPressure(760.5)

    // Показания потеряны (null)
    printPressure(null)
}

// Задача 1
fun calculateIntensity(initialIntensity: Double, attenuationCoefficient: Double?): Double {
    return initialIntensity * (attenuationCoefficient ?: 0.5)
}

// Задача 2
fun calculateDeliveryCost(baseCost: Double, cargoValue: Double?): Double {
    val actualCargoValue = cargoValue ?: 50.0
    val insurance = actualCargoValue * 0.005
    return baseCost + insurance
}

// Задача 3
fun printPressure(pressure: Double?) {
    if (pressure == null) {
        println("Ошибка: показания атмосферного давления отсутствуют!")
    } else {
        println("Атмосферное давление: $pressure мм рт. ст.")
    }
}