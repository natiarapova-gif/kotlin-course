package org.example.lessons18.Homeworks

import java.io.InputStream

// ===== Интерфейсы из задания =====
interface Powerable {
    fun powerOn()
    fun powerOff()
}

interface Openable {
    fun open()
    fun close()
}

interface WaterContainer {
    val capacity: Int
    fun fillWater(amount: Int)
    fun getWater(amount: Int)
}

interface TemperatureRegulatable {
    val maxTemperature: Int
    fun setTemperature(temp: Int)
}

interface WaterConnection {
    fun connectToWaterSupply()
    fun getWater(amount: Int)
}

interface AutomaticShutdown {
    val sensorType: String
    val maxSensoredValue: Int
    fun startMonitoring()
}

interface Drainable {
    fun connectToDrain()
    fun drain()
}

interface Timable {
    fun setTimer(time: Int)
}

interface BatteryOperated {
    fun getCapacity(): Double
    fun replaceBattery()
}

interface Mechanical {
    fun performMechanicalAction()
}

interface LightEmitting {
    fun emitLight()
    fun completeLiteEmission()
}

interface SoundEmitting {
    fun setVolume(volume: Int)
    fun mute()
    fun playSound(stream: InputStream)
}

interface Programmable {
    fun programAction(action: String)
    fun execute()
}

interface Movable {
    fun move(direction: String, distance: Int)
}

interface Cleanable {
    fun clean()
}

interface Rechargeable {
    fun getChargeLevel(): Double
    fun recharge()
}

// ===== Task 1. Абстрактные классы устройств =====
// Только схема: методы не реализуем, классы abstract.
abstract class Refrigerator :
    Powerable, Openable, TemperatureRegulatable, WaterContainer, LightEmitting

abstract class WashingMachine :
    Powerable, Openable, WaterContainer, WaterConnection, Drainable,
    Timable, Programmable, Cleanable

abstract class SmartLamp :
    Powerable, LightEmitting, Programmable, Rechargeable

abstract class ElectronicClock :
    Powerable, Timable, Programmable, SoundEmitting, BatteryOperated

abstract class RobotVacuumCleaner :
    Powerable, Movable, Cleanable, Rechargeable, BatteryOperated,
    AutomaticShutdown, Programmable

abstract class MechanicalClock :
    Mechanical, Timable, SoundEmitting

abstract class Flashlight :
    Powerable, LightEmitting, BatteryOperated, Rechargeable, Mechanical

abstract class CoffeeMachine :
    Powerable, WaterContainer, WaterConnection, TemperatureRegulatable,
    Programmable, Timable, Drainable, Cleanable

abstract class SmartSpeaker :
    Powerable, SoundEmitting, Programmable, Rechargeable, Movable