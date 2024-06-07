package models

data class Zoologico(
    val id: Int,
    val nombre: String,
    val ubicacion: String,
    val fechaFundacion: String,
    val numeroTotalAnimales: Int,
    val animales: MutableList<Animal> = mutableListOf()
)