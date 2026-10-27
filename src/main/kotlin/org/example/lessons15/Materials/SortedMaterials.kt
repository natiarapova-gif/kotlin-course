package org.example.lessons15.Materials

//6. Третий класс при добавлении строки должен отсортировать весь список метиралов в
//алфавитном порядке включая добавляемый материал.

class SortedMaterials : Materials() {
    override fun addMaterial(material: String) {
        materials.add(material)
        materials.sort() // Сортируем весь список после добавления
    }
}