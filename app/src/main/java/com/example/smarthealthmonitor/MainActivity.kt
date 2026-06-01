package com.example.smarthealthmonitor

import android.content.res.Configuration
import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

import com.example.smarthealthmonitor.navigation.SmartHealthNavGraph
import com.example.smarthealthmonitor.ui.theme.SmartHealthMonitorTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {

            SmartHealthMonitorTheme {

                // Ahora NavGraph controla toda la navegación
                SmartHealthNavGraph()
            }
        }
    }
}

@Preview(
    name = "App Preview",
    showBackground = true,
    showSystemUi = true,
    device = "id:pixel_6"
)

@Preview(
    name = "App Preview Dark",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)

@Composable
private fun AppPreview() {

    SmartHealthMonitorTheme {

        SmartHealthNavGraph()
    }
}
