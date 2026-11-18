package com.yeferson.lab13animaciones.screens

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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

enum class ScreenState {
    LOADING, CONTENT, ERROR
}

@Composable
fun Ejercicio4Screen() {
    var currentState by remember { mutableStateOf(ScreenState.LOADING) }

    Column(
        modifier = Modifier.fillMaxWidth().verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(18.dp))
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(28.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF151D2C))
        ) {
            Column(modifier = Modifier.padding(18.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text("NEXUS / SYSTEM", color = Color.White, fontSize = 13.sp, fontWeight = FontWeight.Bold)
                        Text("STATE CONTROL CENTER", color = Color(0xFF8490A3), fontSize = 9.sp)
                    }
                    Box(
                        modifier = Modifier.clip(RoundedCornerShape(10.dp))
                            .background(Color(0xFF263247))
                            .padding(horizontal = 10.dp, vertical = 7.dp)
                    ) {
                        Text("LIVE  •  2026", color = Color(0xFFB9F36A), fontSize = 9.sp, fontWeight = FontWeight.Bold)
                    }
                }

                Spacer(modifier = Modifier.height(22.dp))
                Text("Monitor de estados", color = Color.White, fontSize = 22.sp, fontWeight = FontWeight.Bold)
                Text("Visualiza y controla el flujo de una solicitud.", color = Color(0xFF9AA3B2), fontSize = 11.sp)
                Spacer(modifier = Modifier.height(20.dp))
                AnimatedContent(
                    targetState = currentState,
                    label = "StateTransition"
                ) { targetState ->
                    val accentColor = when (targetState) {
                        ScreenState.LOADING -> Color(0xFF55A6FF)
                        ScreenState.CONTENT -> Color(0xFFB9F36A)
                        ScreenState.ERROR -> Color(0xFFFF647C)
                    }
                    val stateTitle = when (targetState) {
                        ScreenState.LOADING -> "Procesando solicitud"
                        ScreenState.CONTENT -> "Proceso completado"
                        ScreenState.ERROR -> "Error en el proceso"
                    }
                    val stateMessage = when (targetState) {
                        ScreenState.LOADING -> "Estamos preparando tus datos. La solicitud se encuentra en proceso."
                        ScreenState.CONTENT -> "Toda la información se ha procesado correctamente y está disponible."
                        ScreenState.ERROR -> "No pudimos completar la solicitud. Revisa la información e inténtalo nuevamente."
                    }
                    val stateSymbol = when (targetState) {
                        ScreenState.LOADING -> "◌"
                        ScreenState.CONTENT -> "✓"
                        ScreenState.ERROR -> "!"
                    }
                    val stateLabel = when (targetState) {
                        ScreenState.LOADING -> "EN PROCESO"
                        ScreenState.CONTENT -> "COMPLETADO"
                        ScreenState.ERROR -> "REQUIERE ATENCIÓN"
                    }
                    val stateNumber = when (targetState) {
                        ScreenState.LOADING -> "01"
                        ScreenState.CONTENT -> "02"
                        ScreenState.ERROR -> "03"
                    }
                    Column {
                        Box(
                            modifier = Modifier.fillMaxWidth().height(205.dp)
                                .clip(RoundedCornerShape(23.dp))
                                .background(Brush.linearGradient(listOf(Color(0xFF202D42), Color(0xFF0D1422))))
                                .border(1.dp, accentColor.copy(alpha = 0.25f), RoundedCornerShape(23.dp))
                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize().padding(17.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Text("CURRENT STATE", color = Color(0xFF9AA3B2), fontSize = 9.sp, fontWeight = FontWeight.Bold)
                                    Text("#$stateNumber", color = accentColor, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                                }
                                Spacer(modifier = Modifier.height(12.dp))
                                Box(
                                    modifier = Modifier.size(76.dp).clip(CircleShape)
                                        .background(accentColor.copy(alpha = 0.13f))
                                        .border(1.dp, accentColor.copy(alpha = 0.45f), CircleShape),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(stateSymbol, color = accentColor, fontSize = 42.sp, fontWeight = FontWeight.Bold)
                                }
                                Spacer(modifier = Modifier.height(13.dp))
                                Text(stateTitle, color = Color.White, fontSize = 19.sp, fontWeight = FontWeight.Bold)
                                Spacer(modifier = Modifier.height(5.dp))
                                Box(
                                    modifier = Modifier.clip(RoundedCornerShape(20.dp))
                                        .background(accentColor.copy(alpha = 0.13f))
                                        .padding(horizontal = 12.dp, vertical = 5.dp)
                                ) {
                                    Text(stateLabel, color = accentColor, fontSize = 9.sp, fontWeight = FontWeight.Bold)
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(17.dp))
                        Text("INFORMACIÓN DEL PROCESO", color = Color(0xFF9AA3B2), fontSize = 10.sp, fontWeight = FontWeight.Bold)
                        Spacer(modifier = Modifier.height(9.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(16.dp))
                                .background(Color(0xFF0D1422)).padding(14.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(modifier = Modifier.width(3.dp).height(45.dp).clip(CircleShape).background(accentColor))
                            Spacer(modifier = Modifier.width(12.dp))
                            Text(stateMessage, color = Color(0xFFD0D6E0), fontSize = 11.sp, lineHeight = 17.sp)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))
                Text("CAMBIAR ESTADO", color = Color(0xFF9AA3B2), fontSize = 10.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(11.dp))
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Button(
                        onClick = { currentState = ScreenState.LOADING },
                        modifier = Modifier.weight(1f).height(47.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = if (currentState == ScreenState.LOADING) Color(0xFF3985FF) else Color(0xFF263247)),
                        contentPadding = PaddingValues(horizontal = 4.dp)
                    ) {
                        Text("CARGA", color = Color.White, fontSize = 9.sp, fontWeight = FontWeight.Bold)
                    }
                    Button(
                        onClick = { currentState = ScreenState.CONTENT },
                        modifier = Modifier.weight(1f).height(47.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = if (currentState == ScreenState.CONTENT) Color(0xFFB9F36A) else Color(0xFF263247)),
                        contentPadding = PaddingValues(horizontal = 4.dp)
                    ) {
                        Text("CONTENIDO", color = if (currentState == ScreenState.CONTENT) Color(0xFF101522) else Color.White, fontSize = 9.sp, fontWeight = FontWeight.Bold)
                    }
                    Button(
                        onClick = { currentState = ScreenState.ERROR },
                        modifier = Modifier.weight(1f).height(47.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = if (currentState == ScreenState.ERROR) Color(0xFFFF647C) else Color(0xFF263247)),
                        contentPadding = PaddingValues(horizontal = 4.dp)
                    ) {
                        Text("ERROR", color = Color.White, fontSize = 9.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(15.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("●", color = Color(0xFF55A6FF), fontSize = 11.sp)
            Spacer(modifier = Modifier.width(5.dp))
            Text("LOADING", color = Color(0xFF9AA3B2), fontSize = 9.sp)
            Spacer(modifier = Modifier.width(13.dp))
            Text("●", color = Color(0xFFB9F36A), fontSize = 11.sp)
            Spacer(modifier = Modifier.width(5.dp))
            Text("SUCCESS", color = Color(0xFF9AA3B2), fontSize = 9.sp)
            Spacer(modifier = Modifier.width(13.dp))
            Text("●", color = Color(0xFFFF647C), fontSize = 11.sp)
            Spacer(modifier = Modifier.width(5.dp))
            Text("ERROR", color = Color(0xFF9AA3B2), fontSize = 9.sp)
        }
        Spacer(modifier = Modifier.height(15.dp))
    }
}