package com.yeferson.lab13animaciones.screens

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
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
fun Ejercicio3Screen() {
    var isExpanded by remember { mutableStateOf(false) }
    var offsetFirst by remember { mutableStateOf(true) }
    val targetBoxSize = if (isExpanded) 110.dp else 70.dp
    val boxSize by animateDpAsState(targetValue = targetBoxSize, animationSpec = tween(durationMillis = 800), label = "boxSize")
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(24.dp))
        Card(modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(28.dp), colors = CardDefaults.cardColors(containerColor = Color(0xFF151D2C))) {
            Column(modifier = Modifier.padding(18.dp)) {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                    Text("MOVEMENT STUDIO", color = Color(0xFF9AA3B2), fontSize = 10.sp, fontWeight = FontWeight.Bold)
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Box(modifier = Modifier.size(7.dp).background(Color(0xFFB9F36A), CircleShape))
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("EN VIVO", color = Color(0xFFB9F36A), fontSize = 10.sp)
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))
                Text("Área de movimiento", color = Color.White, fontSize = 19.sp, fontWeight = FontWeight.Bold)
                Text("Modifica el tamaño y la posición del elemento", color = Color(0xFF9AA3B2), fontSize = 11.sp)
                Spacer(modifier = Modifier.height(16.dp))

                BoxWithConstraints(modifier = Modifier.fillMaxWidth().height(230.dp).clip(RoundedCornerShape(22.dp)).background(Color(0xFF0D1422)).border(1.dp, Color.White.copy(alpha = 0.08f), RoundedCornerShape(22.dp))) {
                    val targetX = if (isExpanded) maxWidth - targetBoxSize - 20.dp else 20.dp
                    val targetY = if (isExpanded) maxHeight - targetBoxSize - 20.dp else 20.dp
                    val positionX by animateDpAsState(targetValue = targetX, animationSpec = tween(durationMillis = 800), label = "positionX")
                    val positionY by animateDpAsState(targetValue = targetY, animationSpec = tween(durationMillis = 800), label = "positionY")

                    val boxModifier = if (offsetFirst) Modifier.offset(x = positionX, y = positionY).size(boxSize) else Modifier.size(boxSize).offset(x = positionX, y = positionY)
                    Box(modifier = boxModifier.clip(RoundedCornerShape(22.dp)).background(Brush.linearGradient(listOf(Color(0xFFB9F36A), Color(0xFF65D6C4)))), contentAlignment = Alignment.Center) {
                        Text("03", color = Color(0xFF101522), fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    }
                    Text("PLAY AREA", modifier = Modifier.align(Alignment.BottomStart).padding(12.dp), color = Color(0xFF9AA3B2), fontSize = 9.sp, fontWeight = FontWeight.Bold)
                }
                Spacer(modifier = Modifier.height(18.dp))
                Text("ESTADO ACTUAL", color = Color(0xFF9AA3B2), fontSize = 10.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(10.dp))
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Column {
                        Text("TAMAÑO", color = Color(0xFF9AA3B2), fontSize = 9.sp)
                        Text("${boxSize.value.toInt()} dp", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                    }
                    Column {
                        Text("POSICIÓN", color = Color(0xFF9AA3B2), fontSize = 9.sp)
                        Text(if (isExpanded) "DERECHA / ABAJO" else "IZQUIERDA / ARRIBA", color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold)
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))
                HorizontalDivider(color = Color.White.copy(alpha = 0.08f))
                Spacer(modifier = Modifier.height(14.dp))
                Text("ORDEN DE MODIFICADORES", color = Color(0xFF9AA3B2), fontSize = 10.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(9.dp))
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Button(onClick = { offsetFirst = true }, modifier = Modifier.weight(1f), shape = RoundedCornerShape(12.dp), colors = ButtonDefaults.buttonColors(containerColor = if (offsetFirst) Color(0xFFB9F36A) else Color(0xFF263247))) {
                        Text("OFFSET → SIZE", color = if (offsetFirst) Color(0xFF101522) else Color.White, fontSize = 9.sp, fontWeight = FontWeight.Bold)
                    }
                    Button(onClick = { offsetFirst = false }, modifier = Modifier.weight(1f), shape = RoundedCornerShape(12.dp), colors = ButtonDefaults.buttonColors(containerColor = if (!offsetFirst) Color(0xFFB9F36A) else Color(0xFF263247))) {
                        Text("SIZE → OFFSET", color = if (!offsetFirst) Color(0xFF101522) else Color.White, fontSize = 9.sp, fontWeight = FontWeight.Bold)
                    }
                }
                Spacer(modifier = Modifier.height(14.dp))

                Button(onClick = { isExpanded = !isExpanded }, modifier = Modifier.fillMaxWidth().height(54.dp), shape = RoundedCornerShape(15.dp), colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFB9F36A))) {
                    Text(if (isExpanded) "RESTAURAR POSICIÓN" else "MOVER Y CAMBIAR TAMAÑO", color = Color(0xFF101522), fontSize = 11.sp, fontWeight = FontWeight.Bold)
                }
            }
        }

        Spacer(modifier = Modifier.height(15.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("●", color = Color(0xFFB9F36A), fontSize = 12.sp)
            Spacer(modifier = Modifier.width(7.dp))
            Text("SIZE CONTROL", color = Color(0xFF9AA3B2), fontSize = 10.sp)
            Spacer(modifier = Modifier.width(18.dp))
            Text("●", color = Color(0xFF65D6C4), fontSize = 12.sp)
            Spacer(modifier = Modifier.width(7.dp))
            Text("POSITION CONTROL", color = Color(0xFF9AA3B2), fontSize = 10.sp)
        }
    }
}