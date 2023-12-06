package com.example.kt_lr2.ui.planets

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kt_lr2.R
import com.example.kt_lr2.domain.planet.Planet
import com.example.kt_lr2.ui.PlanetsAppTopBar

@Composable
fun PlanetScreen(planetsState: PlanetsUIState, onRetry: () -> Unit, modifier: Modifier = Modifier) {
    when(planetsState) {
        is PlanetsUIState.Loading -> LoadingScreen(modifier)
        is PlanetsUIState.Failure -> ErrorScreen(onRetry)
        is PlanetsUIState.Success -> PlanetsGridScreen(planetsState.planets)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlanetsGridScreen(planets: List<Planet>, modifier: Modifier = Modifier) {
    Scaffold (
        topBar = {
            PlanetsAppTopBar(modifier)
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {}){
                Icon(Icons.Filled.Add, "Floating action button")
            }
        },
        modifier = modifier.padding(10.dp),
    ) {
        PlanetsList(planets, it)
    }
}

@Composable
fun PlanetsList(planets: List<Planet>,paddingValues: PaddingValues, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(200.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        items(items = planets, key = { planet -> planet. Name} ) {planet ->
            PlanetCard(planet, modifier.padding(paddingValues))
        }
    }
}

@Preview
@Composable
fun PlanetsListPreview(){
    PlanetsList(listOf(
        Planet("Mercury", "Milky Way", "57.91", "47.87"),
        Planet("Venus", "Milky Way", "108.2", "35.02"),),
        PaddingValues(4.dp)
    )
}

@Composable
fun PlanetCard(planet: Planet, modifier: Modifier = Modifier) {
    Box (
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        Row() {
            Icon(Icons.Filled.Email, "Mars")
            Column() {
                // Planet name
                Text(text = planet.Name)

                //Galaxy name
                Text(text = planet.Galaxy)

                Row (
                    horizontalArrangement = Arrangement.SpaceBetween,
                ){
                    // distance to the planet
                    Text(text = "${planet.Distance} km  ")

                    //planet speed
                    Text(text = "${planet.Speed} m/s")
                }
            }
        }
    }
}

@Preview
@Composable
fun PlanetCardPreview(){
    PlanetCard(
        Planet("Venus", "Milky Way", "108.2", "35.02")
    )
}

/**
 * The home screen displaying error message with re-attempt button.
 */
@Composable
fun ErrorScreen(retryAction: () -> Unit, modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = stringResource(R.string.loading_failed), modifier = Modifier.padding(16.dp))
            Button(onClick = retryAction) {
                Text(stringResource(R.string.retry))
            }
        }
    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Text(text = "Loading...", modifier= modifier)
}