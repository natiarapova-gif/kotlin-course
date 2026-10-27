package org.example.Lessons5
/*
val sum = 10 + 5 // 15
val diff = 10 - 5 // 5
val product = 10 * 5 // 50
val quotient = 10 / 5 // 2
val remainder  = 10 % 5 / 0
val remainder1 = 10 % 6 // 4
val  remainder2 = 10 % 4 // 2


val isEqual: Boolean = (5 == 5) // true
val isNotEqual = (5 != 5) // false
val isGreater = (5 > 3) // true
val isLesser = (5 < 3) // false
val GreaterOrEqual = (5 >= 5) // true
val isLesserOrEqual = (5 <= 3) // false

// true && true == true
// true && false == false
// false && false == false
// true || false == true
// true || true == true
// false || false == false
// false || true == true
//
val andResult = (5 >3) && (5 > 4) // true
val orResult = (5 > 3) || (5 > 4) // true
val notResult = !(5 >3) // false

fun main() {
    var number = 5
    number += 3 // number теперь равно 8
    // равнозначное выражение: number = number + 3
    var incNumber = number++ // 9

}


val name: String? = null
val result = name ?: "Unknown" // "Unknown", так как name равно null


fun printVolume(userVolume: Int?) {
    val defaultVolume = 30
    println(userVolume ?: defaultVolume)
}

// 1. Задача: Вернуть язык интерфейса для сайта. Если пользователь не установил язык, то вернуть язык по умолчанию - Английский.

 */
/*
//fun main() {
//    val userLang: String? = null
//    val defaultLang = "English"
//    val currentLang = userLang ?: defaultLang
//    println(currentLang)
//}
//
*/

// Задача 2
// Контекст: У вас есть портативное зарядное устройство для мобильного телефона. Это устройство состоит из двух основных частей: встроенной батареи и дополнительного аккумуляторного модуля. Встроенная батарея всегда имеет известное количество энергии, но дополнительный модуль может быть либо подключен с известным количеством энергии, либо отсутствовать.
// Задача: Определить общий запас энергии зарядного устройства, учитывая, что если дополнительный аккумуляторный модуль отсутствует, его вклад в общий запас энергии равен нулю. Известно, что встроенная батарея имеет энергию 5000 мАч, а дополнительный модуль, если он подключен, имеет энергию 2000 мАч.


//val innerAccumulator = 5000
//val externalAccumulator: Int? = 2000
//val powerBank = innerAccumulator + (externalAccumulator ?: 0)
//fun main() {
//    println(powerBank)
//}


//Задача 3
//Контекст: Вы работаете на складе и отвечаете за инвентаризацию. Ваша задача — убедиться, что в каждом контейнере есть товары, иначе сообщить об ошибке.

//val goodsInContainer: String? = "uugf"
//val checkedGoods = goodsInContainer ?: "Error"
//fun main() {
//    println(checkedGoods)
//}

//Задача 4
//Рассчитай стоимость товара со скидкой, если цена известна, а скидка (указанная в процентах) может быть не установлена.

//val price = 80.0
//val discountInPercent: Double? = null
//val discount = (discountInPercent ?: 0.0) / 100
//val discountPrice = price - price * discount
//fun main() {
//    println(discountPrice)
//}

