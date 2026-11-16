package org.example.lessons19

interface Validator<T> {
    fun validate(element: T): Boolean
}