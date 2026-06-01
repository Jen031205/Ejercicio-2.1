package com.example.smarthealthmonitor.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.smarthealthmonitor.data.models.LecturaFC
import com.example.smarthealthmonitor.data.models.MockData
import com.example.smarthealthmonitor.ui.components.FilaHistorial
import com.example.smarthealthmonitor.ui.components.TarjetaDato
import com.example.smarthealthmonitor.ui.theme.SmartHealthMonitorTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(
    onHistorialClick: () -> Unit = {},
    onAlertClick: () -> Unit = {},

    fc: Int = MockData.fcActual,
    pasos: Int = MockData.pasosActual,
    historial: List<LecturaFC> = MockData.historialFC
) {

    SmartHealthMonitorTheme {

        Scaffold(

            topBar = {

                TopAppBar(

                    title = {

                        Text(
                            text = "SmartHealth",
                            style = MaterialTheme.typography.titleLarge
                        )
                    },

                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        titleContentColor = MaterialTheme.colorScheme.onPrimary
                    )
                )
            },

            floatingActionButton = {

                FloatingActionButton(
                    onClick = onAlertClick,
                    containerColor = MaterialTheme.colorScheme.error
                ) {

                    Icon(
                        imageVector = Icons.Default.Warning,
                        contentDescription = "Enviar alerta",
                        tint = MaterialTheme.colorScheme.onError
                    )
                }
            }

        ) { paddingValues ->

            LazyColumn(

                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),

                contentPadding = PaddingValues(16.dp),

                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                item {

                    TarjetaDato(
                        valor = "$fc",
                        unidad = "bpm",
                        label = "Frecuencia cardíaca",
                        colorValor = MaterialTheme.colorScheme.error
                    )
                }

                item {

                    TarjetaDato(
                        valor = "%,d".format(pasos),
                        unidad = "pasos",
                        label = "Pasos del día",
                        colorValor = MaterialTheme.colorScheme.primary
                    )
                }

                item {

                    Row(
                        modifier = Modifier.fillMaxWidth(),

                        horizontalArrangement = Arrangement.SpaceBetween,

                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            text = "Historial reciente",
                            style = MaterialTheme.typography.titleMedium
                        )

                        TextButton(
                            onClick = onHistorialClick
                        ) {

                            Text("Ver todo")
                        }
                    }
                }

                items(
                    historial,
                    key = { it.id }
                ) { lectura ->

                    FilaHistorial(
                        lectura = lectura
                    )
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
    name = "Dashboard Light",
    showSystemUi = true,
    device = "id:pixel_6"
)

@Preview(
    showBackground = true,
    name = "Dashboard Dark",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)

@Composable
fun DashboardScreenPreview() {

    SmartHealthMonitorTheme {

        DashboardScreen()
    }
}