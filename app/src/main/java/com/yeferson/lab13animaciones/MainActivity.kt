package com.yeferson.lab13animaciones

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.yeferson.lab13animaciones.navigation.AppNavigation
import com.yeferson.lab13animaciones.ui.theme.Lab13AnimacionesTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            Lab13AnimacionesTheme {
                AppNavigation()
            }
        }
    }
}