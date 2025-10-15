package com.example.appecoviaje

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.example.appecoviaje.ui.theme.AppEcoViajeTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface

import com.ecoviaje.app.ui.CatalogoScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Aquí es donde definimos el contenido visual de la actividad
        setContent {
            // Aplicamos el tema de la aplicación
            AppEcoViajeTheme {
                // Una superficie que ocupa todo el espacio con el color de fondo del tema
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // ¡Llamamos a nuestra pantalla principal!
                    CatalogoScreen()
                }
            }
        }
    }
}