package com.example.appecoviaje.viewmodel

import androidx.lifecycle.ViewModel
import com.example.appecoviaje.model.Viaje
import com.example.appecoviaje.model.ViajeAventura
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class TripPlanningUiState(
    val searchQuery: String = "",
    val startDate: Long? = null,
    val endDate: Long? = null,
    val searchResults: List<Viaje> = emptyList()
)

class TripPlanningViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(TripPlanningUiState())
    val uiState: StateFlow<TripPlanningUiState> = _uiState.asStateFlow()

    fun onSearchQueryChanged(query: String) {
        _uiState.update { it.copy(searchQuery = query) }
        // In a real app, you would perform a search here
        // For now, we'll just return a mock list
        _uiState.update {
            it.copy(
                searchResults = listOf(
                    ViajeAventura(
                        "Mock Trip 1",
                        "Mock Destination 1",
                        3,
                        100.0
                    ),
                    ViajeAventura(
                        "Mock Trip 2",
                        "Mock Destination 2",
                        5,
                        200.0
                    )
                )
            )
        }
    }

    fun onDateRangeSelected(startDate: Long, endDate: Long) {
        _uiState.update {
            it.copy(
                startDate = startDate,
                endDate = endDate
            )
        }
    }
}
