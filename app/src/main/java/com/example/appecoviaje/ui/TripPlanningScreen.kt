package com.example.appecoviaje.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.appecoviaje.viewmodel.TripPlanningViewModel
import androidx.compose.foundation.lazy.items

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TripPlanningScreen(viewModel: TripPlanningViewModel = viewModel()) {
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Planificar Viaje") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            // Search Bar
            OutlinedTextField(
                value = uiState.searchQuery,
                onValueChange = { viewModel.onSearchQueryChanged(it) },
                label = { Text("Buscar destino") },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))

            // Date Selection
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Fechas:", style = MaterialTheme.typography.titleMedium)
                Spacer(modifier = Modifier.width(8.dp))
                OutlinedButton(onClick = { /* TODO: Show Date Picker */ }) {
                    Text("Seleccionar")
                }
            }
            Spacer(modifier = Modifier.height(16.dp))

            // Filter Options
            Text("Filtros:", style = MaterialTheme.typography.titleMedium)
            // TODO: Add filter chips or dropdowns

            Spacer(modifier = Modifier.height(16.dp))

            // Trip Results
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(uiState.searchResults) { viaje ->
                    ViajeCard(viaje = viaje)
                }
            }
        }
    }
}
