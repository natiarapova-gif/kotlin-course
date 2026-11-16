package org.example.lessons19

class OddValidator : Validator<Int> {
    override fun validate(element: Int): Boolean {
        // В задании просят проверить, что число чётное
        return element % 2 == 0
    }
}