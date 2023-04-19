package com.agsr.footit.feature_agsr.presentation.footit_steps

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class StepsState(
    var goalProgressPercenteage : MutableState<Float> = mutableStateOf(0f),
    var goalStep : MutableState<Int> = mutableStateOf(1000),
    var goalId : MutableState<Int> = mutableStateOf(1),
    var goalDropDownExpanded : MutableState<Boolean>  = mutableStateOf(false),
    var stepsProgressed : MutableState<Int> = mutableStateOf(600)
)