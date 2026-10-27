package org.example.lessons14

// 5. Мероприятие: концерт. Создайте класс, который будет представлять концерт.
//У него должны быть свойства “группа”, “место проведения”, “стоимость”, “вместимость зала”.
//Также приватное поле “проданные билеты”. Добавьте метод,
//который выводит информацию о концерте и метод “купить билет”,
//который увеличивает количество проданных билетов на один.



class Concert(
    val band: String,
    val venue: String,
    val ticketPrice: Double,
    val hallCapacity: Int
) {
    private var soldTickets: Int = 0

    fun printInfo() {
        println("Концерт группы: $band")
        println("Место проведения: $venue")
        println("Стоимость билета: $ticketPrice")
        println("Вместимость зала: $hallCapacity")
        println("Продано билетов: $soldTickets")
    }

    fun buyTicket() {
        if (soldTickets < hallCapacity) {
            soldTickets++
            println("Билет куплен. Всего продано: $soldTickets")
        } else {
            println("Все билеты проданы.")
        }
    }
}