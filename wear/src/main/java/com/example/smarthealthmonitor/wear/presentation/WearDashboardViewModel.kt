package com.example.smarthealthmonitor.wear.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class WearDashboardViewModel : ViewModel() {

    // TEMPORAL
    // Después lo conectaremos al Repository real
    val fc: StateFlow<Int> =
        kotlinx.coroutines.flow.flowOf(72)
            .stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5_000),
                72
            )
}