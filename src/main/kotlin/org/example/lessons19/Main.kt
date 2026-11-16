package org.example.lessons19

fun main() {
    println("--- 1. getMiddleElement ---")
    println(getMiddleElement(listOf(1, 2, 3)))       // 2
    println(getMiddleElement(listOf(1, 2, 3, 4)))    // null

    println("\n--- 2. ListHolder ---")
    val holder = ListHolder<String>()
    holder.add("A")
    holder.add("B")
    println(holder.getAll())

    println("\n--- 4. PhrasesToListOfStrings ---")
    val mapper = PhrasesToListOfStrings()
    println(mapper.map("Привет мир Kotlin"))
    println(mapper.map(listOf("один два", "три четыре")))

    println("\n--- 5. transposition ---")
    println(transposition(mapOf("a" to 1, "b" to 2)))

    println("\n--- 7. StringValidator ---")
    val strVal = StringValidator()
    println(strVal.validate("Текст"))
    println(strVal.validate("   "))

    println("\n--- 8. OddValidator (чётность) ---")
    val oddVal = OddValidator()
    println(oddVal.validate(4))
    println(oddVal.validate(3))

    println("\n--- 9. ListValidator ---")
    val listVal = ListValidator<Int>()
    println(listVal.validate(listOf(1, 2, 3)))
    println(listVal.validate(listOf(1, 0, 3)))
    println(listVal.validate(listOf(1, null, 3)))
}