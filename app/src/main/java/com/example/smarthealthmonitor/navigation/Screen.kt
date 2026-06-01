package com.example.smarthealthmonitor.navigation

sealed class Screen(

    val route: String
) {

    data object Login : Screen(
        "login"
    )

    data object Dashboard : Screen(
        "dashboard"
    )

    data object Historial : Screen(
        "historial"
    )

    data object Alerta : Screen(
        "alerta"
    )
}