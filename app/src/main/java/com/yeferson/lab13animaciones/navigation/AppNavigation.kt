package com.yeferson.lab13animaciones.navigation

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.yeferson.lab13animaciones.components.BottomNavigation
import com.yeferson.lab13animaciones.screens.*

@Composable
fun AppNavigation() {
    var selectedIndex by remember { mutableIntStateOf(0) }

    val titles = listOf("Animación de visibilidad", "Transiciones de color", "Movimiento y tamaño", "Cambio de contenido")

    Scaffold(
        containerColor = Color(0xFF0B0F19),
        bottomBar = { BottomNavigation(selectedIndex = selectedIndex, onItemSelected = { selectedIndex = it }) }
    ) { innerPadding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(innerPadding).padding(horizontal = 20.dp, vertical = 16.dp)
        ) {
            Text(text = "MOTION LAB / 2026", color = Color(0xFFB9F36A), fontSize = 11.sp)
            Text(text = titles[selectedIndex], color = Color.White, fontSize = 25.sp, style = MaterialTheme.typography.headlineMedium)

            AnimatedContent(
                targetState = selectedIndex,
                transitionSpec = { fadeIn(tween(350)) togetherWith fadeOut(tween(200)) },
                label = "ScreenTransition"
            ) { index ->
                when (index) {
                    0 -> Ejercicio1Screen()
                    1 -> Ejercicio2Screen()
                    2 -> Ejercicio3Screen()
                    else -> Ejercicio4Screen()
                }
            }
        }
    }
}