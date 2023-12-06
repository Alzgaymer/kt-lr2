package com.example.kt_lr2.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.LinearGradientShader
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.kt_lr2.R
import com.example.kt_lr2.ui.theme.Ktlr2Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlanetsAppTopBar(modifier: Modifier = Modifier) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.top_app_bar_title),
                fontSize = 18.sp,
                color = Color.Black
            )
        },
        scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(),
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Color.Transparent,
        ),
        modifier = Modifier.background(
            Brush.horizontalGradient(
                colors = listOf(
                    Color.White,
                    Color.Cyan
                )
            )
        ),
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun PlanetsAppTopBarPreview() {
    Ktlr2Theme {
        PlanetsAppTopBar()
    }
}