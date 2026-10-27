package org.example.lessons15.Materials

// 4. Первый класс должен вставлять строку на дно контейнера (должно появиться под индексом 0)

class BottomInsertMaterials : Materials() {
    override fun addMaterial(material: String) {
        materials.add(0, material)
    }
}