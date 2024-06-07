import services.ZoologicoService
import services.AnimalService
import models.Animal
import models.Zoologico

fun main() {
    val filePath = "src/resources/zoologicos.txt"

    // Crear zoológicos
    val zoologico1 = ZoologicoService.crearZoologico(1, "Zoológico Central", "Ciudad A", "2000-05-20", 2)
    val zoologico2 = ZoologicoService.crearZoologico(2, "Zoológico del Norte", "Ciudad B", "2010-11-15", 1)

    // Crear animales
    val animal1 = AnimalService.crearAnimal(1, "León", "Panthera leo", 5, 190.5, true)
    val animal2 = AnimalService.crearAnimal(2, "Elefante", "Loxodonta", 10, 5000.0, false)
    val animal3 = AnimalService.crearAnimal(3, "Tigre", "Panthera tigris", 4, 220.7, true)

    // Agregar animales a los zoológicos
    zoologico1.animales.add(animal1)
    zoologico1.animales.add(animal2)
    zoologico2.animales.add(animal3)

    // Guardar zoológicos
    ZoologicoService.guardarZoologicos(filePath, listOf(zoologico1, zoologico2))

    // Leer zoológicos
    val zoologicos = ZoologicoService.leerZoologicos(filePath)
    println("Zoológicos después de crear:")
    zoologicos.forEach { println(it) }

    // Actualizar zoológico
    ZoologicoService.actualizarZoologico(filePath, 1, "Zoológico Central Renovado", "Ciudad A+", "2000-05-21", 3)
    println("Zoológicos después de actualizar:")
    ZoologicoService.leerZoologicos(filePath).forEach { println(it) }

    // Actualizar animal
    AnimalService.actualizarAnimal(zoologico1, 1, "León Africano", "Panthera leo", 6, 195.0, true)
    ZoologicoService.guardarZoologicos(filePath, listOf(zoologico1, zoologico2))
    println("Animales después de actualizar:")
    ZoologicoService.leerZoologicos(filePath).forEach { zoologico ->
        zoologico.animales.forEach { println(it) }
    }

    // Borrar animal
    AnimalService.borrarAnimal(zoologico1, 2)
    ZoologicoService.guardarZoologicos(filePath, listOf(zoologico1, zoologico2))
    println("Animales después de borrar:")
    ZoologicoService.leerZoologicos(filePath).forEach { zoologico ->
        zoologico.animales.forEach { println(it) }
    }

    // Borrar zoológico
    ZoologicoService.borrarZoologico(filePath, 2)
    println("Zoológicos después de borrar:")
    ZoologicoService.leerZoologicos(filePath).forEach { println(it) }
}
