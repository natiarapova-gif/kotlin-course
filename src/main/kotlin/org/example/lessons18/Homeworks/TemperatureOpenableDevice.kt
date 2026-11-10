package org.example.lessons18.Homeworks

// ===== Task 4. Оборудование с температурой и открыванием =====
abstract class TemperatureOpenableDevice :
    ProgrammableDevice(), TemperatureRegulatable, Openable {

    abstract override val maxTemperature: Int

    override fun setTemperature(temp: Int) {
        if (!isPoweredOn) {
            println("Устройство выключено: установка температуры недоступна")
            return
        }
        if (temp !in 0..maxTemperature) {
            println("Температура $temp вне диапазона 0..$maxTemperature")
            return
        }
        println("Температура установлена: $temp")
    }

    override fun open() {
        println("Устройство открыто")
    }

    override fun close() {
        println("Устройство закрыто")
    }
}
