package org.example.lessons14


//Задание 6. Класс Rack (Стеллаж)
//Характеристики:
//
//Список полок (shelves): хранит полки стеллажа.
//Максимальное количество полок.
//Методы:
//
//Добавление Полки (addShelf):
//Добавляет новую полку в стеллаж.
//Возвращает true, если полка была успешно добавлена или false если стеллаж уже заполнен или была попытка добавить полку которая уже установлена.
//Удаление Полки (removeShelf):
//Принимает индекс полки для удаления.
//Удаляет полку по указанному индексу.
//Возвращает список предметов полки, если полка была успешно удалена или пустой список если полка не существует.
//Добавление Предмета (addItem):
//Добавляет предмет на первую свободную полку.
//Возвращает true, если предмет успешно добавлен, и false, если на всех полках недостаточно места.
//Удаление Предмета (removeItem):
//Находит и удаляет только один предмет с любой полки.
//Возвращает true, если предмет был удален, и false, если такой предмет не найден.
//Проверка наличия предмета на стеллаже (containsItem):
//Возвращает true если предмет есть на одной из полок
//Получение списка полок (getShelves):
//Возвращает неизменяемый список полок
//Печать Содержимого (printContents):
//Выводит в консоль информацию о каждой полке: индекс, вместимость, оставшуюся вместимость, список предметов. Информацию выводить в наглядном читаемом виде
//Сложное удаление полки (advancedRemoveShelf):
//Принимает индекс полки для удаления
//Перераспределяет предметы по имеющимся полкам, начиная с самых длинных. Если очередной предмет никуда не вмещается, его нужно пропустить и попробовать разместить следующий.
//Удаляет полку с оставшимися предметами
//Возвращает неизменяемый список предметов, которые не удалось удалить или пустой список если полки с таким индексом нет.



class Rack(
    private val maxShelves: Int
) {
    private val shelves = mutableListOf<Shelf>()

    /**
     * Добавляет полку в стеллаж.
     * @return false, если стеллаж заполнен или такая полка уже установлена.
     */
    fun addShelf(shelf: Shelf): Boolean {
        if (shelves.size >= maxShelves) return false
        if (shelves.contains(shelf)) return false
        shelves.add(shelf)
        return true
    }

    /**
     * Удаляет полку по индексу.
     * @return список предметов удалённой полки или пустой список, если полки нет.
     */
    fun removeShelf(index: Int): List<String> {
        if (index !in shelves.indices) return emptyList()
        val removedShelf = shelves.removeAt(index)
        return removedShelf.getItems()
    }

    /**
     * Добавляет предмет на первую полку, где есть место.
     * @return false, если ни на одной полке места недостаточно.
     */
    fun addItem(item: String): Boolean {
        for (shelf in shelves) {
            if (shelf.addItem(item)) return true
        }
        return false
    }

    /**
     * Находит и удаляет только один предмет с любой полки.
     */
    fun removeItem(item: String): Boolean {
        for (shelf in shelves) {
            if (shelf.removeItem(item)) return true
        }
        return false
    }

    /**
     * Проверяет наличие предмета на любой полке стеллажа.
     */
    fun containsItem(item: String): Boolean {
        return shelves.any { it.containsItem(item) }
    }

    /**
     * Возвращает неизменяемый список полок.
     */
    fun getShelves(): List<Shelf> {
        return shelves.toList()
    }

    /**
     * Выводит информацию о каждой полке: индекс, вместимость,
     * оставшуюся вместимость и список предметов.
     */
    fun printContents() {
        println("Стеллаж (полок: ${shelves.size}/$maxShelves)")
        if (shelves.isEmpty()) {
            println("  Полок нет")
            return
        }
        shelves.forEachIndexed { index, shelf ->
            println(
                "  Полка #$index: вместимость=${shelf.capacity}, " +
                        "осталось=${shelf.remainingCapacity()}, " +
                        "предметы=${shelf.getItems()}"
            )
        }
    }

    /**
     * Удаляет полку по индексу, пытаясь перераспределить её предметы
     * по остальным полкам, начиная с самых длинных названий.
     * @return предметы, которые не удалось разместить, или пустой список,
     *         если полки с таким индексом нет.
     */
    fun advancedRemoveShelf(index: Int): List<String> {
        if (index !in shelves.indices) return emptyList()

        val shelfToRemove = shelves[index]
        val itemsToRedistribute = shelfToRemove.getItems()
            .sortedByDescending { it.length }

        val remainingShelves = shelves.filterIndexed { i, _ -> i != index }
        val failedItems = mutableListOf<String>()

        for (item in itemsToRedistribute) {
            var placed = false
            for (shelf in remainingShelves) {
                if (shelf.addItem(item)) {
                    placed = true
                    break
                }
            }
            if (!placed) {
                failedItems.add(item)
            }
        }

        shelves.removeAt(index)
        return failedItems.toList()
    }
}