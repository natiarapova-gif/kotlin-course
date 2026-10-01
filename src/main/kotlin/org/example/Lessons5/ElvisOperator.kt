package org.example.Lessons5

fun main() {
    // Задание 1 Контекст: Вы изучаете физическое явление затухания звука в помещении. У вас есть измеренное значение начальной интенсивности звука, но из-за ограничений оборудования данные о коэффициенте затухания иногда могут быть неизвестны.
    // Задача: Рассчитать предполагаемую интенсивность звука после затухания. Интенсивность звука после затухания пропорциональна начальной интенсивности, умноженной на коэффициент затухания. Если коэффициент затухания неизвестен, использовать стандартное значение 0.5.
//    val baseIntensity: Double = 3.0
//    val coefficient: Double? = 0.73 // но может быть null
//    val baseCoefficient = 0.5
//    val resultIntensity = baseIntensity * (coefficient ?: baseCoefficient)
//    println(resultIntensity)

    // Задание 2
    // Контекст: Клиент оплачивает доставку груза. К стоимости доставки добавляется страховка на груз, которая составляет 0,5% от его стоимости. В случае, если стоимость не указана, то берётся стандартная стоимость в $50
    // Задача: Рассчитать полную стоимость доставки.
    val defaultCost: Double = 50.0
    val cost: Double? = 20.0 // но может быть null
    val deliveryCost = 5.0
    val insuranceCoefficient = 0.005
    // стоимость страховки
    val insuranceCost = ???
    val totalCost: Double = deliveryCost + insuranceCost
    println(insuranceCost)
    println(totalDeliveryCost)




    val pressure: String? = "34.6" // но может быть null
    val attentionMessage = "Attention, pressure is lost"
    val pressureForLab = ???

}