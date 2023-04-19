package com.agsr.footit.feature_agsr.presentation.util

sealed class Screen (val route: String) {
    object stepsScreen: Screen("steps_screen")
}