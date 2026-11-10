package org.example.lessons17

// Доработанный ChildrenClass и main

class ChildrenClass(
    val privateVal: String,
    protectedVal: String,
    publicVal: String
) : BaseClass(privateVal, protectedVal, publicVal) {

    // 3–4: разрешаем установить publicField в "Антонио Бандераса"
    protected override fun verifyPublicField(value: String): Boolean {
        return value == "Антонио Бандераса" || value.length < 3
    }

    // 5: публичный сеттер для protectedField
    fun setProtectedField(value: String) {
        protectedField = value
    }

    // 6: штатно изменить privateField из BaseClass нельзя.
    // BaseClass менять запрещено, privateField — private.
    // Сеттер здесь не поможет: поле недоступно даже наследнику.

    private fun privatePrint() {
        println("Печать из класса ChildrenClass")
    }

    override fun generate(): String {
        return "Это генерация из дочернего класса"
    }
}

fun main() {
    val child = ChildrenClass(
        "private-из-ребенка",
        "protected-из-ребенка",
        "public-из-ребенка"
    )

    child.publicField = "Антонио Бандераса"
    child.setProtectedField("protectedField изменён через сеттер наследника")

    println(child.getAll())
    println("---")
    child.printText()
    println("child.privateVal = ${child.privateVal}")
    println("child.publicVal = ${child.publicVal}")

    // println(child.protectedVal) // ошибка: protected
    // println(child.privateField) // ошибка: private
}

// Ответы на вопросы:
////1. privateVal в main() доступен потому, что в ChildrenClass объявлено своё поле val privateVal. Это не поле BaseClass, а публичное свойство наследника. Приватное privateVal из BaseClass всё равно недоступно.
////
////2. protectedVal недоступен в main(), потому что protected виден только внутри класса и наследников. В ChildrenClass параметр protectedVal объявлен без val/var, значит это не свойство.
////
////3. publicField можно менять из main(), потому что это публичный var. Но сеттер проверяет значение через verifyPublicField(). Чтобы установить "Антонио Бандераса", нужно переопределить проверку в наследнике.
////
////4. Для этого в ChildrenClass переопределяем verifyPublicField().
////
////5. protectedField меняем из main() через публичный метод-сеттер в ChildrenClass.
////
////6. privateField из BaseClass штатно изменить из main() нельзя: он private, а BaseClass дорабатывать запрещено. Сеттер в ChildrenClass не сможет к нему обратиться. Только рефлексия, но это уже нарушение инкапсуляции.
////
////7. getProtectedClass() не может быть public, потому что возвращает ProtectedClass, а этот класс объявлен protected. Публичная функция не может раскрывать менее доступный тип в своей сигнатуре.
////
////8. В getAll() поле generate будет другим, потому что getAll() вызывает generate(), а он переопределён в ChildrenClass. Срабатывает динамический полиморфизм.
////
////9. getPrivateClass() не может быть public или protected, потому что возвращает PrivateClass, который объявлен private внутри BaseClass. Такой тип нельзя раскрывать в публичной/защищённой сигнатуре.
////
////10. publicVal доступен в main() не как аргумент ChildrenClass, а как унаследованное публичное поле BaseClass: там объявлено val publicVal. В ChildrenClass параметр без val/var просто передаётся в super.
////
////11. getAll() доступна в main(), потому что это публичный метод BaseClass, а ChildrenClass его наследует.
////
////12. printText() выведет "Печать из класса BaseClass". privatePrint() — приватный метод, он не переопределяется. ChildrenClass.privatePrint() — это отдельная функция с тем же именем, а не override.

// Пример вывода:
//privateVal: private-из-ребенка
//protectedVal: protected-из-ребенка
//publicVal: public-из-ребенка
//publicField: Антонио Бандераса
//protectedField: protectedField изменён через сеттер наследника
//privateField: 6. добавь сеттер чтобы изменить меня из main()
//generate: Это генерация из дочернего класса
//---
//Печать из класса BaseClass
//child.privateVal = private-из-ребенка
//child.publicVal = public-из-ребенка