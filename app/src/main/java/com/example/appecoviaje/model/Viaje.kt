package com.ecoviaje.app.model

// Clase abstracta que define el contrato base para todos los viajes (Herencia y Abstracción)
abstract class Viaje(
    val nombre: String,
    val destino: String,
    val duracionDias: Int,
    val precioPorPersona: Double
) {
    // Función abstracta que requiere una implementación específica (Polimorfismo)
    abstract fun descripcion(): String

    // Lógica de negocio (Función común)
    fun valorTotal(cantidadPersonas: Int): Double = precioPorPersona * cantidadPersonas
}

// Subclase para viajes enfocados en la naturaleza
class ViajeAventura(nombre: String, destino: String, duracion: Int, precio: Double) :
    Viaje(nombre, destino, duracionDias = duracion, precioPorPersona = precio) {
    // Implementación específica (Polimorfismo)
    override fun descripcion() = "Aventura: $nombre en $destino (${duracionDias} días). 🏞️"
}

// Subclase para viajes enfocados en las personas
class ViajeCultural(nombre: String, destino: String, duracion: Int, precio: Double) :
    Viaje(nombre, destino, duracionDias = duracion, precioPorPersona = precio) {
    // Implementación específica (Polimorfismo)
    override fun descripcion() = "Cultural: $nombre en $destino (${duracionDias} días). 🛖"
}