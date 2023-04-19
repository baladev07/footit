package com.agsr.footit.feature_agsr.presentation.footit_layout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.agsr.footit.feature_agsr.presentation.ViewModels.StepsVM
import com.agsr.footit.feature_agsr.presentation.footit_steps.components.CircularProgressbar3

@Composable
fun footit_layout_screen(
    navController: NavController,
    viewModel: StepsVM = hiltViewModel()
)
{
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //CircularProgressbar3()
        }
    }
}