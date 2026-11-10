package org.example.lessons17

// Дополнительно: расширяемый калькулятор

abstract class Operation(protected val symbol: String) {

    protected abstract fun apply(left: Double, right: Double): Double

    open fun isApplicable(expression: String): Boolean {
        return expression.trim().contains(" $symbol ")
    }

    protected fun split(expression: String): Pair<Double, Double> {
        val parts = expression.trim()
            .split(Regex("\\s+${Regex.escape(symbol)}\\s+"))

        require(parts.size == 2) { "Ожидалось два операнда" }
        return parts[0].toDouble() to parts[1].toDouble()
    }

    fun execute(expression: String): String {
        val (left, right) = split(expression)
        return apply(left, right).toString()
    }
}

// Стандартные операции скрыты в файле: снаружи калькулятора они недоступны
private class Plus : Operation("+") {
    override fun apply(left: Double, right: Double) = left + right
}

private class Minus : Operation("-") {
    override fun apply(left: Double, right: Double) = left - right
}

private class Multiply : Operation("*") {
    override fun apply(left: Double, right: Double) = left * right
}

private class Divide : Operation("/") {
    override fun apply(left: Double, right: Double) = left / right
}

private class Remainder : Operation("%") {
    override fun apply(left: Double, right: Double) = left % right
}

class Calculator(vararg extraOperations: Operation) {

    private val operations = mutableListOf<Operation>(
        Plus(), Minus(), Multiply(), Divide(), Remainder()
    ).apply {
        addAll(extraOperations)
    }

    fun addOperation(operation: Operation) {
        operations.add(operation)
    }

    fun calculate(expression: String): String {
        val operation = operations.firstOrNull { it.isApplicable(expression) }
            ?: return "Неподдерживаемая операция: $expression"
        return operation.execute(expression)
    }
}

fun main() {
    val power = object : Operation("^") {
        override fun apply(left: Double, right: Double): Double {
            return Math.pow(left, right)
        }
    }

    val calculator = Calculator(power)

    listOf(
        "3 + 4",
        "10 - 2",
        "6 * 7",
        "8 / 2",
        "10 % 3",
        "2 ^ 8",
        "2 & 3"
    ).forEach {
        println("$it = ${calculator.calculate(it)}")
    }
}

// Так стандартные операции инкапсулированы, а новые можно добавлять снаружи через наследников Operation и конструктор/addOperation().