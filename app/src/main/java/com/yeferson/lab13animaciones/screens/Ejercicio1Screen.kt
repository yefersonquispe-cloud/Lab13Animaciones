package com.yeferson.lab13animaciones.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Ejercicio1Screen() {
    var isVisible by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("ANIMACIÓN 01", color = Color(0xFFB9F36A), fontSize = 11.sp)
        Spacer(modifier = Modifier.height(20.dp))

        Card(
            modifier = Modifier.fillMaxWidth().height(280.dp),
            shape = RoundedCornerShape(24.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF151D2C))
        ) {
            Column(
                modifier = Modifier.fillMaxSize().padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Control de visibilidad", color = Color.White, fontSize = 19.sp)

                AnimatedVisibility(visible = isVisible) {
                    Box(
                        modifier = Modifier.size(110.dp).background(Color(0xFFB9F36A), RoundedCornerShape(22.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("VISIBLE", color = Color(0xFF101522), fontSize = 13.sp)
                    }
                }

                if (!isVisible) {
                    Text("Elemento oculto", color = Color(0xFF9AA3B2), fontSize = 14.sp)
                }

                Button(
                    onClick = { isVisible = !isVisible },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFB9F36A)),
                    shape = RoundedCornerShape(14.dp)
                ) {
                    Text(if (isVisible) "OCULTAR ELEMENTO" else "MOSTRAR ELEMENTO", color = Color(0xFF101522))
                }
            }
        }
    }
}