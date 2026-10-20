package org.example.lesson13

// 1. Среднее время выполнения теста — values
fun averageTestTime(times: Map<String, Int>): Double =
    times.values.average()

// 2. Список всех тестовых методов — keys
fun getAllTestMethods(metadata: Map<String, String>): List<String> =
    metadata.keys.toList()

// 3. Добавить новый тест и результат в изменяемый словарь — put
fun addTestResult(results: MutableMap<String, String>, testName: String, result: String) {
    results.put(testName, result)
}

// 4. Количество успешных тестов — count
fun countPassedTests(results: Map<String, String>): Int =
    results.count { it.value == "passed" }

// 5. Удалить исправленный баг из изменяемого словаря — remove
fun removeFixedBug(bugs: MutableMap<String, String>, bugName: String) {
    bugs.remove(bugName)
}

// 6. Вывести сообщение о странице и статусе — forEach
fun printPageResults(pageResults: Map<String, String>) {
    pageResults.forEach { (url, status) ->
        println("Страница $url: статус проверки — $status")
    }
}

// 7. Найти сервисы с временем ответа выше порога — filterValues
fun filterSlowServices(services: Map<String, Int>, threshold: Int): Map<String, Int> =
    services.filterValues { it > threshold }

// 8. Статус endpoint или «не был протестирован» — getOrElse
fun getEndpointStatus(statuses: Map<String, String>, endpoint: String): String =
    statuses.getOrElse(endpoint) { "не был протестирован" }

// 9. Получить browserType, ответ не может быть null — getValue
fun getBrowserType(config: Map<String, String>): String =
    config.getValue("browserType")

// 10. Копия словаря версий с новой версией — plus
fun addNewVersion(versions: Map<String, String>, key: String, value: String): Map<String, String> =
    versions + (key to value)

// 11. Настройки для модели или по умолчанию — getOrDefault
fun getDeviceSettings(settings: Map<String, String>, model: String, defaultSettings: String): String =
    settings.getOrDefault(model, defaultSettings)

// 12. Содержит ли словарь ошибок определённый код — containsKey
fun containsErrorCode(errors: Map<Int, String>, code: Int): Boolean =
    errors.containsKey(code)

// 13. Оставить сценарии только нужной версии — filterKeys
fun filterTestsByVersion(results: Map<String, String>, version: String): Map<String, String> =
    results.filterKeys { it.contains(version) }

// 14. Есть ли модули с неудачным тестированием — any
fun hasFailedModules(modules: Map<String, String>): Boolean =
    modules.any { it.value == "failed" }

// 15. Добавить настройки из другого словаря — putAll
fun addEnvironmentSettings(target: MutableMap<String, String>, source: Map<String, String>) {
    target.putAll(source)
}

// 16. Объединить два неизменяемых словаря багов — entries
fun combineBugMaps(bugs1: Map<String, String>, bugs2: Map<String, String>): Map<String, String> =
    (bugs1.entries + bugs2.entries).associate { it.key to it.value }

// 17. Очистить изменяемый словарь временных данных — clear
fun clearTemporaryRunData(tempData: MutableMap<String, String>) {
    tempData.clear()
}

// 18. Исключить пропущенные тесты — filterNot
fun excludeSkippedTests(report: Map<String, String>): Map<String, String> =
    report.filterNot { it.value == "skipped" }

// 19. Копия словаря конфигураций без нескольких ключей — minus
fun removeConfigurations(configs: Map<String, String>, keysToRemove: List<String>): Map<String, String> =
    configs - keysToRemove

// 20. Отчёт в виде списка строк — map
fun buildTestReport(results: Map<String, String>): List<String> =
    results.map { (id, result) -> "Test ID: $id — $result" }

// 21. Изменяемый словарь в неизменяемый для архивации — toMap
fun archiveResults(results: MutableMap<String, String>): Map<String, String> =
    results.toMap()

// 22. Числовые ID тестов заменить на строковые — mapKeys
fun stringifyTestIds(times: Map<Int, Int>): Map<String, Int> =
    times.mapKeys { it.key.toString() }

// 23. Увеличить оценки производительности на 10% — mapValues
fun increasePerformanceScores(scores: Map<String, Double>): Map<String, Double> =
    scores.mapValues { it.value * 1.1 }

// 24. Проверить, пуст ли словарь ошибок компиляции — isEmpty
fun areCompilationErrorsEmpty(errors: Map<String, String>): Boolean =
    errors.isEmpty()

// 25. Проверить, что словарь нагрузочных результатов не пуст — isNotEmpty
fun hasLoadTestResults(results: Map<String, String>): Boolean =
    results.isNotEmpty()

// 26. Проверить, что все автотесты прошли успешно — all
fun allTestsPassed(results: Map<String, String>): Boolean =
    results.all { it.value == "passed" }

// 27. Проверить, что есть хотя бы один тест с ошибкой — containsValue
fun hasAnyFailedTest(results: Map<String, String>): Boolean =
    results.containsValue("failed")

// 28. Оставить неуспешные тесты сервисов, в названии которых есть “optional” — filter
fun filterFailedOptionalServices(results: Map<String, String>): Map<String, String> =
    results.filter { it.value != "passed" && it.key.contains("optional", ignoreCase = true) }