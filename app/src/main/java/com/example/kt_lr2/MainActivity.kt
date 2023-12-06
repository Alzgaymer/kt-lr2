package com.example.kt_lr2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.kt_lr2.ui.AppViewModelProvider
import com.example.kt_lr2.ui.planets.PlanetScreen
import com.example.kt_lr2.ui.planets.PlanetViewModel
import com.example.kt_lr2.ui.theme.Ktlr2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Ktlr2Theme {
                val viewModel:PlanetViewModel = viewModel(factory = AppViewModelProvider.Factory)
                val planetsState = viewModel.uiState.collectAsState().value
                PlanetScreen(planetsState, onRetry = viewModel::getPlanets)
            }
        }
    }
}

