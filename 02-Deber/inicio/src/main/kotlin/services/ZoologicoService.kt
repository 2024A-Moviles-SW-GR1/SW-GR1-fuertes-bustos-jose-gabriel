package services

import models.Zoologico
import models.Animal
import java.io.File

object ZoologicoService {

    fun crearZoologico(id: Int, nombre: String, ubicacion: String, fechaFundacion: String, numeroTotalAnimales: Int): Zoologico {
        return Zoologico(id, nombre, ubicacion, fechaFundacion, numeroTotalAnimales)
    }

    fun leerZoologicos(filePath: String): List<Zoologico> {
        val zoologicos = mutableListOf<Zoologico>()
        val file = File(filePath)
        if (file.exists()) {
            var currentZoologico: Zoologico? = null
            file.forEachLine { line ->
                if (line.startsWith("   ")) {
                    val parts = line.trim().split(",")
                    if (parts.size == 6 && currentZoologico != null) {
                        val animal = Animal(parts[0].toInt(), parts[1], parts[2], parts[3].toInt(), parts[4].toDouble(), parts[5].toBoolean())
                        currentZoologico!!.animales.add(animal)
                    }
                } else {
                    val parts = line.split(",")
                    if (parts.size == 5) {
                        currentZoologico = Zoologico(parts[0].toInt(), parts[1], parts[2], parts[3], parts[4].toInt())
                        zoologicos.add(currentZoologico!!)
                    }
                }
            }
        }
        return zoologicos
    }

    fun actualizarZoologico(filePath: String, id: Int, nuevoNombre: String, nuevaUbicacion: String, nuevaFechaFundacion: String, nuevoNumeroTotalAnimales: Int) {
        val zoologicos = leerZoologicos(filePath).toMutableList()
        val zoologicoIndex = zoologicos.indexOfFirst { it.id == id }
        if (zoologicoIndex != -1) {
            val zoologico = zoologicos[zoologicoIndex]
            zoologicos[zoologicoIndex] = zoologico.copy(
                nombre = nuevoNombre,
                ubicacion = nuevaUbicacion,
                fechaFundacion = nuevaFechaFundacion,
                numeroTotalAnimales = nuevoNumeroTotalAnimales
            )
            guardarZoologicos(filePath, zoologicos)
        }
    }

    fun borrarZoologico(filePath: String, id: Int) {
        val zoologicos = leerZoologicos(filePath).toMutableList()
        val zoologicoIndex = zoologicos.indexOfFirst { it.id == id }
        if (zoologicoIndex != -1) {
            zoologicos.removeAt(zoologicoIndex)
            guardarZoologicos(filePath, zoologicos)
        }
    }

    fun guardarZoologicos(filePath: String, zoologicos: List<Zoologico>) {
        val file = File(filePath)
        file.bufferedWriter().use { out ->
            zoologicos.forEach { zoologico ->
                out.write("${zoologico.id},${zoologico.nombre},${zoologico.ubicacion},${zoologico.fechaFundacion},${zoologico.numeroTotalAnimales}\n")
                zoologico.animales.forEach { animal ->
                    out.write("   ${animal.id},${animal.nombre},${animal.especie},${animal.edad},${animal.peso},${animal.esSalvaje}\n")
                }
            }
        }
    }
}
