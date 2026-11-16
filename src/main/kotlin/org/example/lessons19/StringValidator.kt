package org.example.lessons19

class StringValidator : Validator<String?> {
    override fun validate(element: String?): Boolean {
        // Проверяем, что не null и не пустая/пробельная строка
        return element != null && element.isNotBlank()
    }
}