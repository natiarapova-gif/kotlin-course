package org.example.lessons18.Homeworks

// ===== Task 5. Конкретные устройства =====
class RefrigeratorDevice(
    override val maxTemperature: Int = 10
) : TemperatureOpenableDevice(), WaterContainer, LightEmitting {

    override val capacity = 5

    override fun fillWater(amount: Int) {
        println("В холодильник налито $amount л воды")
    }

    override fun getWater(amount: Int) {
        println("Из холодильника получено $amount л воды")
    }

    override fun emitLight() {
        if (!isPoweredOn) {
            println("Холодильник выключен — свет не горит")
            return
        }
        println("Свет в холодильнике горит")
    }

    override fun completeLiteEmission() {
        println("Свет в холодильнике выключен")
    }
}

class WashingMachineDevice(
    override val maxTemperature: Int = 90
) : TemperatureOpenableDevice(), WaterContainer, WaterConnection,
    Drainable, Timable, Cleanable {

    override val capacity = 10

    override fun fillWater(amount: Int) {
        println("В стиральную машину налито $amount л воды")
    }

    // Один метод удовлетворяет и WaterContainer, и WaterConnection
    override fun getWater(amount: Int) {
        println("Из стиральной машины получено $amount л воды")
    }

    override fun connectToWaterSupply() {
        println("Стиральная машина подключена к водопроводу")
    }

    override fun connectToDrain() {
        println("Стиральная машина подключена к сливу")
    }

    override fun drain() {
        println("Стиральная машина сливает воду")
    }

    override fun setTimer(time: Int) {
        if (!isPoweredOn) {
            println("Стиральная машина выключена: таймер недоступен")
            return
        }
        println("Таймер установлен на $time мин")
    }

    override fun clean() {
        println("Стиральная машина очищена")
    }
}

class KettleDevice(
    override val maxTemperature: Int = 100
) : TemperatureOpenableDevice(), WaterContainer, LightEmitting {

    override val capacity = 2

    override fun fillWater(amount: Int) {
        println("В чайник налито $amount л воды")
    }

    override fun getWater(amount: Int) {
        println("Из чайника получено $amount л воды")
    }

    override fun emitLight() {
        if (!isPoweredOn) {
            println("Чайник выключен — подсветка не горит")
            return
        }
        println("Подсветка чайника горит")
    }

    override fun completeLiteEmission() {
        println("Подсветка чайника выключена")
    }
}

class OvenDevice(
    override val maxTemperature: Int = 250
) : TemperatureOpenableDevice(), LightEmitting, Timable, Cleanable {

    override fun emitLight() {
        if (!isPoweredOn) {
            println("Духовка выключена — свет не горит")
            return
        }
        println("Свет в духовке горит")
    }

    override fun completeLiteEmission() {
        println("Свет в духовке выключен")
    }

    override fun setTimer(time: Int) {
        if (!isPoweredOn) {
            println("Духовка выключена: таймер недоступен")
            return
        }
        println("Таймер духовки установлен на $time мин")
    }

    override fun clean() {
        println("Духовка очищена")
    }
}

// ===== Проверка =====
fun main() {
    println("--- Холодильник ---")
    val fridge = RefrigeratorDevice()
    fridge.setTemperature(5)                // выключен
    fridge.programAction("быстрое охлаждение") // выключен
    fridge.powerOn()
    fridge.programAction("быстрое охлаждение")
    fridge.setTemperature(5)
    fridge.open()
    fridge.emitLight()
    fridge.fillWater(2)
    fridge.getWater(1)
    fridge.close()
    fridge.completeLiteEmission()
    fridge.powerOff()

    println("--- Стиральная машина ---")
    val washer = WashingMachineDevice()
    washer.setTemperature(40) // выключена
    washer.powerOn()
    washer.connectToWaterSupply()
    washer.fillWater(8)
    washer.programAction("деликатная стирка")
    washer.setTemperature(40)
    washer.execute()
    washer.setTimer(30)
    washer.drain()
    washer.clean()
    washer.powerOff()

    println("--- Чайник ---")
    val kettle = KettleDevice()
    kettle.powerOn()
    kettle.fillWater(1)
    kettle.setTemperature(95)
    kettle.programAction("кипячение")
    kettle.emitLight()
    kettle.getWater(1)
    kettle.completeLiteEmission()
    kettle.powerOff()

    println("--- Духовка ---")
    val oven = OvenDevice()
    oven.powerOn()
    oven.setTemperature(180)
    oven.programAction("выпечка")
    oven.execute()
    oven.open()
    oven.emitLight()
    oven.setTimer(45)
    oven.clean()
    oven.close()
    oven.completeLiteEmission()
    oven.powerOff()
}



// Ключевые моменты:
//В Task 1 классы только объявляют интерфейсы и остаются abstract, методы не реализуются.
//В Task 2 PowerableDevice хранит isPoweredOn и реализует Powerable.
//В Task 3 ProgrammableDevice наследует PowerableDevice и проверяет питание перед программированием и выполнением.
//В Task 4 TemperatureOpenableDevice наследует ProgrammableDevice, реализует TemperatureRegulatable и Openable, а maxTemperature оставляет абстрактным.
//В Task 5 конкретные устройства наследуют TemperatureOpenableDevice, добавляют нужные интерфейсы и реализуют их методы. Установка температуры, программирование, таймер и выполнение проверяют isPoweredOn.