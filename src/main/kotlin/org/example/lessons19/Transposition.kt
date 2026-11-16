package org.example.lessons19

fun <K, V> transposition(map: Map<K, V>): Map<V, K> {
    // Меняем ключ и значение местами
    val resultMap = mutableMapOf<V, K>()
    for ((key, value) in map) {
        resultMap[value] = key
    }
    return resultMap
}