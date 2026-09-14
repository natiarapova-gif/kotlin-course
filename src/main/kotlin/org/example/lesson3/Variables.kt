package org.example.lesson3

// blabla auto
val shassi: String = "bslkdsdklsld667788"

// auto color
lateinit var colorAuto: String

// auto length
var probeg: Double = 0.0

// owner name
lateinit var ownerName: String

// wheels number
const val wheelsNumber: Int = 4

//detailed report for auto utilization
val deadReport: String by lazy{
    "blabla"
}



val name: String = "Alice" // immutable, can be calculated at runtime 1Usage
var age: Int = 38 //mutable 3Usages

//lateinit var only
lateinit var phoneNumber: String 2 Usages

const val PI: Double = 3.14 // only primitive, out of fun and class

// lazy initialization

val lazyValue: String by lazy {
    Thread.sleep(millis = 2000)
    "this is very lazy String"
