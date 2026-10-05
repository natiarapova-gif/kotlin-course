package org.example.lesson9

fun mane() {

}
// 1. Работа с массивами Array
// Создайте массив из 5 целых чисел и инициализируйте его значениями от 1 до 5.
val a1: Array<Int> = arrayOf(1, 2, 3, 4, 2, 5)

//Создайте пустой массив строк размером 10 элементов.
val a2: Array<String> = Array(size = 10) { "" }

//Создайте массив из 5 элементов типа Double и заполните его значениями, являющимися удвоенным индексом элемента.
val a3: DoubleArray = doubleArrayOf(0.0, 2.0, 4.0, 6.0, 8.0, 10.0)

//Создайте массив из 5 элементов типа Int. Используйте цикл, чтобы присвоить каждому элементу значение, равное его индексу, умноженному на 3.
val a4: Array<Int>(size = 5) { 0 }

//Создайте массив из 3 nullable строк. Инициализируйте его одним null значением и двумя строками.
val strings: Array<String?> = arrayOf(null, "Kotlin", "Hello")

//Создайте массив целых чисел и скопируйте его в новый массив в цикле.
val a5 = arrayOf(1, 2, 3, 4, 5)
val copya5 = IntArray(a5.size)

for (i in a5.indices) {
    copya5[i] = a5[i]
}

//Создайте два массива целых чисел одинаковой длины. Создайте третий массив, вычев значения одного из другого. Распечатайте полученные значения.
val a6 = arrayOf(5, 6, 7, 8, 9)
val a7 = arrayOf(1, 2, 3, 4, 5)

val result = Array<Int>(a6.size) { 0 }

for (i in a6.indices) {
    result[i] = a6[i] - a7[i]
}
for (i in result) {
    println(i)
}

//Создайте массив целых чисел. Найдите индекс элемента со значением 5. Если значения 5 нет в массиве, печатаем -1. Реши задачу через цикл while.
val numbers8 = arrayOf(8, 3, 7, 5, 10)

var i = 0
var result8 = -1

while (i < numbers8.size) {
    if(numbers8[i] == 5) {
        result8 = i
        break
    }
    i++
}
//Создайте массив целых чисел. Используйте цикл для перебора массива и вывода каждого элемента в консоль. Напротив каждого элемента должно быть написано “чётное” или “нечётное”.
val numbers9 = arrayOf(1, 2, 3, 4, 5, 6)
for (number % 2 == 0) {
    if(number % 2 == 0) {
        println("$number - чётное")
    } else {
        println("$number - нечётное")
    }
}

//Создай функцию, которая принимает массив строк и строку для поиска. Функция должна находить в массиве элемент, в котором принятая строка является подстрокой (метод contains()). Распечатай найденный элемент.
fun findString(strings: Array<String>, search: String) {

    for (text in strings) {

        if (text.contains(other = search)) {
            println(text)
        }
    }
}

//2. Работа со списками List
//Создайте пустой неизменяемый список целых чисел.
val list1: List<Int> = emptyList()

//Создайте неизменяемый список строк, содержащий три элемента (например, "Hello", "World", "Kotlin").
val list2: List<String> = listOf("Hello", "World", "Kotlin")

//Создайте изменяемый список целых чисел и инициализируйте его значениями от 1 до 5.
val list3: MutableList<Int> = mutableListOf(1, 2, 3, 4, 5)

//Имея изменяемый список целых чисел, добавьте в него новые элементы (например, 6, 7, 8).
val list4 = mutableListOf(1, 2, 3, 4, 5)

list4.add(6)
list4.add(7)
list4.add(8)

println(list4)

//Имея изменяемый список строк, удалите из него определенный элемент (например, "World").
val list5 = mutableListOf("Hello", "World", "Kotlin")

list5.remove(element = "World")

println(list5)

//Создайте список целых чисел и используйте цикл для вывода каждого элемента на экран.
val list6 = listOf(10, 20, 30, 40, 50)

for (element in list6) {
    println(element)
}

//Создайте список строк и получите из него второй элемент, используя его индекс.
val list7 = listOf("Java", "Kotlin", "Python")

println(list7[1])

//Имея изменяемый список чисел, измените значение элемента на определенной позиции (например, замените элемент с индексом 2 на новое значение).
val list8 = mutableListOf(10, 20, 30, 40)

list8[2] = 100

println(list8)

//Создайте два списка строк и объедините их в один новый список, содержащий элементы обоих списков. Реши задачу с помощью циклов.
val firstList = listOf("Hello", "World")
val secondList = listOf("Kotlin", "Java")

val resultList = mutableListOf<String>()

for (element in firstList) {
    resultList.add(element)
}

for (element in secondList) {
    resultList.add(element)
}

println(resultList)

//Создайте список целых чисел и найдите в нем минимальный и максимальный элементы используя цикл.
val list10 = listOf(7, 2, 9, 4, 1, 8)

var min = list10[0]
var max = list10[0]

for (element in list10) {

    if (element < min) {
        min = element
    }
    if (element > max) {
        max = element
    }
}
println("Минимальное: $min")
println("Максимальное: $max")

//Имея список целых чисел, создайте новый список, содержащий только четные числа из исходного списка используя цикл.
val list11 = listOf(1, 2, 3, 4, 5, 6, 7, 8)

val evenList = mutableListOf<Int>()

for (element in list11) {

    if (element % 2 == 0) {
        evenList.add(element)
    }
}

println(evenList)

//3. Работа с Множествами Set
//Создайте пустое неизменяемое множество целых чисел.
val set1: Set<Int> = emptySet()

//Создайте неизменяемое множество целых чисел, содержащее три различных элемента (например, 1, 2, 3).
val set2: Set<Int> = setOf(1, 2, 3)

//Создайте изменяемое множество строк и инициализируйте его несколькими значениями (например, "Kotlin", "Java", "Scala").
val set3: MutableSet<String> = mutableSetOf("Kotlin", "Java", "Scala")

//Имея изменяемое множество строк, добавьте в него новые элементы (например, "Swift", "Go").
val set4 = mutableSetOf("Kotlin", "Java", "Scala")

set4.add("Swift")
set4.add("Go")

println(set4)

//Имея изменяемое множество целых чисел, удалите из него определенный элемент (например, 2).
val set5 = mutableSetOf(1, 2, 3, 4, 5)

set5.remove(element = 2)

println(set5)

//Создайте множество целых чисел и используйте цикл для вывода каждого элемента на экран.
val set6 = setOf(10, 20, 30, 40)

for (element in set6) {
    println(element)
}

//Создай функцию, которая принимает множество строк (set) и строку и проверяет, есть ли в множестве указанная строка. Нужно распечатать булево значение true если строка есть. Реши задачу через цикл.
checkString(setOf("Kotlin", "Java", "Scala"), search = "Kotlin")

//Создайте неизменяемое множество строк и конвертируйте его в изменяемый список строк с использованием цикла.
val set8 = setOf("Kotlin", "Java", "Scala")

val listFromSet = mutableListOf<String>()

for (element in set8) {
    listFromSet.add(element)
}

println(listFromSet)
