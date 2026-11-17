package com.yeferson.lab13animaciones.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Ejercicio2Screen() {
    var isBlue by remember { mutableStateOf(true) }
    val currentColor = if (isBlue) Color(0xFF3985FF) else Color(0xFFB9F36A)
    val colorName = if (isBlue) "OCEAN BLUE" else "NEON GREEN"
    val hexCode = if (isBlue) "#3985FF" else "#B9F36A"

    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(24.dp))

        Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(28.dp), colors = CardDefaults.cardColors(containerColor = Color(0xFF151D2C))) {
            Column(modifier = Modifier.padding(18.dp)) {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                    Text("PREVISUALIZACIÓN", color = Color(0xFF9AA3B2), fontSize = 10.sp, fontWeight = FontWeight.Bold)
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(modifier = Modifier.size(7.dp).background(Color(0xFFB9F36A), CircleShape))
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("EN VIVO", color = Color(0xFFB9F36A), fontSize = 10.sp)
                    }
                }

                Spacer(modifier = Modifier.height(14.dp))

                Box(modifier = Modifier.fillMaxWidth().height(190.dp).clip(RoundedCornerShape(22.dp)).background(Brush.linearGradient(listOf(currentColor, currentColor.copy(alpha = 0.72f)))), contentAlignment = Alignment.Center) {
                    Box(modifier = Modifier.size(145.dp).border(1.dp, Color.White.copy(alpha = 0.25f), CircleShape).padding(12.dp).clip(CircleShape).background(Color.White.copy(alpha = 0.12f)), contentAlignment = Alignment.Center) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text("Aa", color = Color.White, fontSize = 48.sp, fontWeight = FontWeight.Bold)
                            Text("COLOR", color = Color.White, fontSize = 10.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                    Text("LIVE PREVIEW", modifier = Modifier.align(Alignment.BottomStart).padding(14.dp), color = Color.White.copy(alpha = 0.8f), fontSize = 9.sp, fontWeight = FontWeight.Bold)
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text("COLOR SELECCIONADO", color = Color(0xFF9AA3B2), fontSize = 10.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(10.dp))

                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Box(modifier = Modifier.size(42.dp).clip(RoundedCornerShape(12.dp)).background(currentColor))
                    Spacer(modifier = Modifier.width(12.dp))
                    Column(modifier = Modifier.weight(1f)) {
                        Text(colorName, color = Color.White, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        Text(hexCode, color = Color(0xFF9AA3B2), fontSize = 12.sp)
                    }
                    Text("●", color = currentColor, fontSize = 23.sp)
                }

                Spacer(modifier = Modifier.height(18.dp))
                HorizontalDivider(color = Color.White.copy(alpha = 0.08f))
                Spacer(modifier = Modifier.height(18.dp))

                Text("CAMBIAR PALETA", color = Color(0xFF9AA3B2), fontSize = 10.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(12.dp))

                Button(onClick = { isBlue = !isBlue }, modifier = Modifier.fillMaxWidth().height(52.dp), shape = RoundedCornerShape(15.dp), colors = ButtonDefaults.buttonColors(containerColor = currentColor)) {
                    Text(if (isBlue) "CAMBIAR A VERDE" else "CAMBIAR A AZUL", color = Color(0xFF101522), fontSize = 11.sp, fontWeight = FontWeight.Bold)
                }
            }
        }

        Spacer(modifier = Modifier.height(15.dp))

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
            Text("●", color = Color(0xFF3985FF), fontSize = 12.sp)
            Spacer(modifier = Modifier.width(6.dp))
            Text("AZUL", color = Color(0xFF9AA3B2), fontSize = 10.sp)
            Spacer(modifier = Modifier.width(18.dp))
            Text("●", color = Color(0xFFB9F36A), fontSize = 12.sp)
            Spacer(modifier = Modifier.width(6.dp))
            Text("VERDE", color = Color(0xFF9AA3B2), fontSize = 10.sp)
        }
    }
}