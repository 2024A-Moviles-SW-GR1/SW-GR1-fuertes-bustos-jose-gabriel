package services

import models.Animal
import models.Zoologico
import java.io.File

object AnimalService {

    fun crearAnimal(id: Int, nombre: String, especie: String, edad: Int, peso: Double, esSalvaje: Boolean): Animal {
        return Animal(id, nombre, especie, edad, peso, esSalvaje)
    }

    fun actualizarAnimal(zoologico: Zoologico, id: Int, nuevoNombre: String, nuevaEspecie: String, nuevaEdad: Int, nuevoPeso: Double, nuevoEsSalvaje: Boolean) {
        val animalIndex = zoologico.animales.indexOfFirst { it.id == id }
        if (animalIndex != -1) {
            zoologico.animales[animalIndex] = Animal(id, nuevoNombre, nuevaEspecie, nuevaEdad, nuevoPeso, nuevoEsSalvaje)
        }
    }

    fun borrarAnimal(zoologico: Zoologico, id: Int) {
        val animalIndex = zoologico.animales.indexOfFirst { it.id == id }
        if (animalIndex != -1) {
            zoologico.animales.removeAt(animalIndex)
        }
    }
}
