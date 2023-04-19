package com.agsr.footit.feature_agsr.presentation.footit_layout.component.bottoomNav

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.agsr.footit.R
import com.agsr.footit.feature_agsr.domain.repository.GoalSettingRepos
import com.agsr.footit.feature_agsr.presentation.ViewModels.AppPreferenceVM
import com.agsr.footit.feature_agsr.presentation.ViewModels.GoalsVM


//@Preview
@Composable
@ExperimentalAnimationApi
fun NavBarScreen(goalsRepos : GoalSettingRepos,appPreferenceVM: AppPreferenceVM) {
    val navController = rememberNavController()
    Scaffold(
        content =  { BottomNavGraph(navController = navController,
            modifier = Modifier.padding(it),appPreferenceVM,
            goalsRepos)} ,
        bottomBar = { BottomBar(navController = navController) },
    )
}


@Composable
fun BottomBar(navController: NavHostController) {
    var currentScreen = remember { mutableStateOf(NavBarItem.HOME) }
    NavigationBar(contentColor = Color.Magenta,tonalElevation = 8.dp) {
        NavigationBarItem(selected = (currentScreen.value.ordinal == 0),
            onClick = { navController.navigate("profile"); currentScreen.value = NavBarItem.HISTORY},
            icon =
            {
                Icon(Icons.Filled.History, contentDescription = "History")
            })

        NavigationBarItem(selected = (currentScreen.value.ordinal == 1),
            onClick = { navController.navigate("home") ;  currentScreen.value = NavBarItem.HOME},
            icon =
            {
                androidx.compose.material3.Icon(painterResource(R.drawable.ic_accesibility), contentDescription = "Home")
            })

        NavigationBarItem(selected = (currentScreen.value.ordinal == 2), onClick =
            { navController.navigate("report"); currentScreen.value = NavBarItem.GOALS},
            icon =
            {
                androidx.compose.material3.Icon(Icons.Filled.GolfCourse, contentDescription = "Goals")
            })
        }
}

enum class NavBarItem {
    HISTORY,
    HOME,
    GOALS
}
