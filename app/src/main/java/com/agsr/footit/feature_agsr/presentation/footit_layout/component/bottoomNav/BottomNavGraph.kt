package com.agsr.footit.feature_agsr.presentation.footit_layout.component.bottoomNav

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.agsr.footit.feature_agsr.domain.repository.GoalSettingRepos
import com.agsr.footit.feature_agsr.presentation.ViewModels.AppPreferenceVM
import com.agsr.footit.feature_agsr.presentation.ViewModels.GoalsVM
import com.agsr.footit.feature_agsr.presentation.footit_activity_history.components.HistoryScreen
import com.agsr.footit.feature_agsr.presentation.footit_goal_setup.components.GoalsScreen
import com.agsr.footit.feature_agsr.presentation.footit_steps.SettingsScreen
import com.agsr.footit.feature_agsr.presentation.footit_steps.StepsScreen

@Composable
@ExperimentalAnimationApi
fun BottomNavGraph(
    navController: NavHostController,
    modifier : Modifier,
    appPreferenceVM: AppPreferenceVM,
    goalSettingRepos: GoalSettingRepos
) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Steps.route,
        modifier =  modifier
    ) {
        composable(route = BottomBarScreen.Steps.route)
        {
            StepsScreen(goalSettingRepos,navController, appPreferenceVM);
        }
        composable(route = BottomBarScreen.Goals.route)
        {
            GoalsScreen(goalSettingRepos,appPreferenceVM);
        }
        composable(route = BottomBarScreen.History.route)
        {
            HistoryScreen(goalSettingRepos)
        }
        composable(route = BottomBarScreen.Settings.route)
        {
            SettingsScreen(navController,appPreferenceVM)
        }
    }
}