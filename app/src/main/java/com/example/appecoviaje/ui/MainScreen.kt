package com.example.appecoviaje.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.appecoviaje.ui.theme.AppEcoViajeTheme
import com.example.appecoviaje.viewmodel.CatalogoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    viewModel: CatalogoViewModel = viewModel(),
    onNavigateToTripPlanning: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("EcoViaje") }
            )
        },
        bottomBar = {
            BottomAppBar {
                IconButton(onClick = { /* do something */ }) {
                    Icon(Icons.Filled.Home, contentDescription = "Catálogo")
                }
                IconButton(onClick = { /* do something */ }) {
                    Icon(Icons.Filled.DateRange, contentDescription = "Reservas")
                }
                IconButton(onClick = { /* do something */ }) {
                    Icon(Icons.Filled.AccountCircle, contentDescription = "Perfil")
                }
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            item {
                Row {
                    Button(onClick = onNavigateToTripPlanning) {
                        Text(text = "Planificar Viaje")
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "Mis Reservas")
                    }
                }
            }
            items(viewModel.viajes) { viaje ->
                ViajeCard(viaje = viaje)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    AppEcoViajeTheme {
        MainScreen(onNavigateToTripPlanning = {})
    }
}
