package com.example.kt_lr2.ui.planets

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kt_lr2.domain.planet.Planet
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class PlanetViewModel : ViewModel() {
    private var _uiState = MutableStateFlow<PlanetsUIState>(PlanetsUIState.Failure)
    val uiState: StateFlow<PlanetsUIState> = _uiState

    fun getPlanets() {
        viewModelScope.launch {
            _uiState.value = PlanetsUIState.Success(mockData())
        }
    }

    //FIXME
    private fun mockData(): List<Planet> {
        return listOf(
            Planet("Mercury", "Milky Way", "57.91", "47.87"),
            Planet("Venus", "Milky Way", "108.2", "35.02"),
            Planet("Earth", "Milky Way", "149.6", "29.78"),
            Planet("Mars", "Milky Way", "227.9", "24.07"),
            Planet("Jupiter", "Milky Way", "778.5", "13.07"),
            Planet("Saturn", "Milky Way", "1.43", "9.69"),
            Planet("Uranus", "Milky Way", "2.87", "6.81"),
            Planet("Neptune", "Milky Way", "4.5", "5.43")
        )
    }
}