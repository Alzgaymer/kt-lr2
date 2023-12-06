package com.example.kt_lr2.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.kt_lr2.ui.planets.PlanetScreen
import com.example.kt_lr2.ui.planets.PlanetViewModel

object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            PlanetViewModel()
        }
    }
}