package com.example.appecoviaje.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.appecoviaje.model.Viaje

@Composable
fun ViajeCard(viaje: Viaje) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(text = viaje.descripcion(), style = androidx.compose.material3.MaterialTheme.typography.titleMedium)
            Text(text = "Precio por persona: $${viaje.precioPorPersona}", style = androidx.compose.material3.MaterialTheme.typography.bodyMedium)
        }
    }
}
