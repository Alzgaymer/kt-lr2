package com.example.kt_lr2.ui.planets

import com.example.kt_lr2.domain.planet.Planet
import kotlinx.coroutines.flow.MutableStateFlow

sealed interface PlanetsUIState{
    data class Success(val planets: List<Planet>) : PlanetsUIState
    object Loading : PlanetsUIState
    object Failure : PlanetsUIState
}