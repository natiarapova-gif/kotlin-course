package org.example.lessons18.Homeworks

// ===== Task 2. Абстрактный класс включаемого оборудования =====
abstract class PowerableDevice : Powerable {
    protected var isPoweredOn = false

    override fun powerOn() {
        isPoweredOn = true
        println("Устройство включено")
    }

    override fun powerOff() {
        isPoweredOn = false
        println("Устройство выключено")
    }
}