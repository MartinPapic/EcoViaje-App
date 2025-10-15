package com.ecoviaje.app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.ecoviaje.app.model.* class CatalogoViewModel : ViewModel() {

    // Lista de viajes observables por la UI (View)
    var viajes by mutableStateOf(getInventarioInicial())
        private set

    // Colección de viajes inicial (Ejemplo de inventario)
    private fun getInventarioInicial(): List<Viaje> {
        // Uso de una colección mutable para agregar datos
        return mutableListOf<Viaje>().apply {
            add(ViajeAventura("Trekking Glaciar", "Patagonia", 5, 250000.0))
            add(ViajeCultural("Ruta Artesanal", "Valparaíso", 3, 120000.0))
            // Un viaje 'caro' para la demostración
            add(ViajeAventura("Expedición Atacama", "Atacama", 4, 350000.0))
            add(ViajeCultural("Historia Precolombina", "Arica", 2, 95000.0))
        }
    }

    // Función de Colección: Filtrar viajes caros (> $200.000)
    fun getViajesCaros(): List<Viaje> {
        return viajes
            // Utiliza 'filter' para la condición
            .filter { it.precioPorPersona > 200000.0 }
            // Utiliza 'sortedByDescending' para ordenarlos
            .sortedByDescending { it.precioPorPersona }
    }

    // Función de Colección: Calcular precio promedio
    fun getPrecioPromedio(): String {
        // Utiliza 'map' y 'average' para las métricas
        val promedio = viajes.map { it.precioPorPersona }.average()
        return "%.2f".format(promedio)
    }

    // Función de Colección: Encontrar el viaje más económico
    fun getViajeMasBarato(): Viaje? {
        // Utiliza 'minByOrNull'
        return viajes.minByOrNull { it.precioPorPersona }
    }
}