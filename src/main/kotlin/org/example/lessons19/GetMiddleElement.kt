package org.example.lessons19

fun <T> getMiddleElement(list: List<T>): T? {
    if (list.isEmpty() || list.size % 2 == 0) return null
    return list[list.size / 2]
}