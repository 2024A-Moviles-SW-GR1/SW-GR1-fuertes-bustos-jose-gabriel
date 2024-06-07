package models

data class Animal(
    val id: Int,
    val nombre: String,
    val especie: String,
    val edad: Int,
    val peso: Double,
    val esSalvaje: Boolean
)