package com.example.appecoviaje.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

sealed interface RegistrationUiState {
    object Idle : RegistrationUiState
    object Loading : RegistrationUiState
    object Success : RegistrationUiState
    data class Error(val message: String) : RegistrationUiState
}

class RegistrationViewModel : ViewModel() {

    private val _username = MutableStateFlow("")
    val username: StateFlow<String> = _username.asStateFlow()

    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email.asStateFlow()

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password.asStateFlow()

    private val _registrationState = MutableStateFlow<RegistrationUiState>(RegistrationUiState.Idle)
    val registrationState: StateFlow<RegistrationUiState> = _registrationState.asStateFlow()

    fun onUsernameChange(username: String) {
        _username.value = username
    }

    fun onEmailChange(email: String) {
        _email.value = email
    }

    fun onPasswordChange(password: String) {
        _password.value = password
    }

    fun register() {
        viewModelScope.launch {
            // Reset state and show loading
            _registrationState.update { RegistrationUiState.Loading }
            delay(1000) // Simulate network delay

            if (_username.value.isBlank() || _email.value.isBlank() || _password.value.isBlank()) {
                _registrationState.update { RegistrationUiState.Error("All fields are required.") }
                return@launch
            }

            // Simulate a check for existing users
            if (_email.value == "a@a.a") {
                _registrationState.update { RegistrationUiState.Error("User already exists.") }
                return@launch
            }

            // Simulate a successful registration
            _registrationState.update { RegistrationUiState.Success }
        }
    }
}
