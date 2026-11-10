package org.example.lessons17

class SlotMachine(
    val color: String,                 // цвет — не меняется
    val model: String,                 // модель — не меняется
    val owner: String,                 // владелец — публично
    val supportPhone: String,          // телефон поддержки — публично
    val sessionPrice: Double,          // стоимость сеанса — публично, но менять не даём
    val hasJoystick: Boolean,          // наличие джойстика
    private val pinCode: String,       // пин-код скрыт
    initialGames: List<String> = emptyList()
) {
    private var isOn = false           // включён
    private var isOsLoaded = false     // ОС загружена
    private val installedGames = mutableListOf<String>().apply { addAll(initialGames) }
    private var cashBalance = 0.0      // баланс выручки
    private var isSessionPaid = false  // игровой сеанс оплачен

    fun turnOn(): Boolean {
        isOn = true
        return isOn
    }

    fun turnOff(): Boolean {
        isOn = false
        isOsLoaded = false
        isSessionPaid = false
        return isOn
    }

    fun loadOS(): Boolean {
        if (isOn) isOsLoaded = true
        return isOsLoaded
    }

    fun shutdownOS(): Boolean {
        isOsLoaded = false
        isSessionPaid = false
        return isOsLoaded
    }

    fun showGames(): List<String> = installedGames.toList()

    fun startGame(game: String): Boolean {
        if (!isOn || !isOsLoaded || !isSessionPaid) return false
        if (game !in installedGames) return false
        isSessionPaid = false
        return true
    }

    fun payForSession(amount: Double): Boolean {
        if (amount >= sessionPrice) {
            cashBalance += amount
            isSessionPaid = true
            return true
        }
        return false
    }

    fun withdrawCash(pin: String): Double {
        if (pin != pinCode) return 0.0
        return openSafeAndDispenseCash(cashBalance)
    }

    private fun openSafeAndDispenseCash(amount: Double): Double {
        val issued = amount.coerceAtMost(cashBalance)
        cashBalance -= issued
        return issued
    }
}

// Ключевое: pinCode, cashBalance, isOn, isOsLoaded, isSessionPaid — private; наружу — только методы.

