package com.example.appecoviaje.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

sealed interface LoginUiState {
    object Idle : LoginUiState
    object Loading : LoginUiState
    object Success : LoginUiState
    data class Error(val message: String) : LoginUiState
}

class LoginViewModel : ViewModel() {

    private val _email = MutableStateFlow("")
    val email: StateFlow<String> = _email.asStateFlow()

    private val _password = MutableStateFlow("")
    val password: StateFlow<String> = _password.asStateFlow()

    private val _loginState = MutableStateFlow<LoginUiState>(LoginUiState.Idle)
    val loginState: StateFlow<LoginUiState> = _loginState.asStateFlow()

    fun onEmailChange(email: String) {
        _email.value = email
    }

    fun onPasswordChange(password: String) {
        _password.value = password
    }

    fun login() {
        viewModelScope.launch {
            // Reset state and show loading
            _loginState.update { LoginUiState.Loading }
            delay(1000) // Simulate network delay

            if (_email.value.isBlank() || _password.value.isBlank()) {
                _loginState.update { LoginUiState.Error("Email and password cannot be empty.") }
                return@launch
            }

            // Simulate a successful login with a hardcoded user
            if (_email.value == "a@a.a" && _password.value == "a") {
                _loginState.update { LoginUiState.Success }
            } else {
                _loginState.update { LoginUiState.Error("Invalid credentials.") }
            }
        }
    }
}
