package com.example.appecoviaje.ui

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.material3.* // for Scaffold, TopAppBar, Card, etc.
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.appecoviaje.model.Viaje
import com.example.appecoviaje.viewmodel.CatalogoViewModel
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatalogoScreen(viewModel: CatalogoViewModel = viewModel()) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("AppEcoViaje - Catálogo Sostenible") }) }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            // Sección 1: Todos los Viajes (Uso de Polimorfismo en itemContent)
            item { Text("🌎 Viajes Disponibles", style = MaterialTheme.typography.headlineSmall) }
            items(viewModel.viajes) { viaje ->
                ViajeCard(viaje = viaje)
                Spacer(modifier = Modifier.height(8.dp))
            }

            // Sección 2: Viajes Caros (Uso de la función de colección filter)
            item {
                Spacer(modifier = Modifier.height(16.dp))
                Text("💎 Viajes Exclusivos (> $200k)", style = MaterialTheme.typography.headlineSmall)
            }
            items(viewModel.getViajesCaros()) { viaje ->
                ViajeCard(viaje = viaje)
                Spacer(modifier = Modifier.height(8.dp))
            }

            // Sección 3: Métricas (Uso de funciones de colección average y minByOrNull)
            item {
                Spacer(modifier = Modifier.height(16.dp))
                Text("📊 Métricas del Catálogo", style = MaterialTheme.typography.headlineSmall)
                Text("Precio Promedio: $${viewModel.getPrecioPromedio()}")
                Text("Viaje más económico: ${viewModel.getViajeMasBarato()?.nombre} ($${viewModel.getViajeMasBarato()?.precioPorPersona})")
            }
        }
    }
}
