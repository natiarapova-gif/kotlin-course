package org.example.lessons18.Homeworks

// ===== Task 3. Программируемое оборудование =====
abstract class ProgrammableDevice : PowerableDevice(), Programmable {

    override fun programAction(action: String) {
        if (!isPoweredOn) {
            println("Устройство выключено: программирование недоступно")
            return
        }
        println("Программирование: $action")
    }

    override fun execute() {
        if (!isPoweredOn) {
            println("Устройство выключено: выполнение программы недоступно")
            return
        }
        println("Выполнение программы")
    }
}