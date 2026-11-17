package com.yeferson.lab13animaciones.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class NavigationItem(val title: String, val shortName: String, val symbol: String)

private val navigationItems = listOf(
    NavigationItem("Visibilidad", "01", "◉"),
    NavigationItem("Colores", "02", "◈"),
    NavigationItem("Movimiento", "03", "↗"),
    NavigationItem("Contenido", "04", "▣")
)

@Composable
fun BottomNavigation(selectedIndex: Int, onItemSelected: (Int) -> Unit) {
    NavigationBar(containerColor = Color(0xFF101522), contentColor = Color.White, tonalElevation = 0.dp) {
        navigationItems.forEachIndexed { index, item ->
            val selected = selectedIndex == index
            val indicatorColor = animateColorAsState(if (selected) Color(0xFFB9F36A) else Color.Transparent, label = "indicatorColor")
            NavigationBarItem(
                selected = selected,
                onClick = { onItemSelected(index) },
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = item.symbol,
                            fontSize = 22.sp,
                            color = if (selected) Color(0xFF101522) else Color(0xFF9AA3B2),
                            modifier = Modifier.clip(RoundedCornerShape(12.dp)).background(indicatorColor.value).padding(horizontal = 13.dp, vertical = 4.dp)
                        )
                        Text(text = item.shortName, fontSize = 9.sp, color = if (selected) Color(0xFFB9F36A) else Color(0xFF9AA3B2))
                    }
                },
                label = { Text(text = item.title, fontSize = 9.sp) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0xFF101522),
                    selectedTextColor = Color(0xFFB9F36A),
                    unselectedIconColor = Color(0xFF9AA3B2),
                    unselectedTextColor = Color(0xFF9AA3B2),
                    indicatorColor = Color.Transparent
                )
            )
        }
    }
}