package com.example.appecoviaje.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.appecoviaje.ui.theme.AppEcoViajeTheme
import com.example.appecoviaje.viewmodel.RegistrationViewModel
import com.example.appecoviaje.viewmodel.RegistrationUiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationScreen(viewModel: RegistrationViewModel = viewModel(), onRegistrationSuccess: () -> Unit) {
    val username by viewModel.username.collectAsState()
    val email by viewModel.email.collectAsState()
    val password by viewModel.password.collectAsState()
    val registrationState by viewModel.registrationState.collectAsState()

    var showError by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Register")
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = username,
            onValueChange = { viewModel.onUsernameChange(it) },
            label = { Text("Username") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = email,
            onValueChange = { viewModel.onEmailChange(it) },
            label = { Text("Email") }
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { viewModel.onPasswordChange(it) },
            label = { Text("Password") }
        )
        Spacer(modifier = Modifier.height(16.dp))

        if (showError) {
            Text(text = errorMessage, color = MaterialTheme.colorScheme.error)
            Spacer(modifier = Modifier.height(8.dp))
        }

        Button(onClick = { viewModel.register() }) {
            Text(text = "Register")
        }
    }

    LaunchedEffect(registrationState) {
        when (val state = registrationState) {
            is RegistrationUiState.Success -> {
                showError = false
                onRegistrationSuccess()
            }
            is RegistrationUiState.Error -> {
                errorMessage = state.message
                showError = true
            }
            else -> {
                showError = false
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegistrationScreenPreview() {
    AppEcoViajeTheme {
        RegistrationScreen(onRegistrationSuccess = {})
    }
}
