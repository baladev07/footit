package com.agsr.footit.feature_agsr.presentation

import android.os.Bundle
import android.view.Window
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.MaterialTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.agsr.footit.feature_agsr.presentation.footit_layout.component.bottoomNav.NavBarScreen
import com.agsr.footit.feature_agsr.presentation.util.Screen
import dagger.hilt.android.AndroidEntryPoint
import androidx.compose.material3.*
import com.agsr.footit.di.AppModule
import com.agsr.footit.feature_agsr.data.datasource.FootItDatabase
import com.agsr.footit.feature_agsr.domain.repository.GoalSettingRepos
import com.agsr.footit.feature_agsr.presentation.ViewModels.AppPreferenceVM
import com.agsr.footit.feature_agsr.presentation.ViewModels.GoalsVM
import com.agsr.footit.feature_agsr.presentation.ViewModels.StepsVM
import com.agsr.footit.ui.theme.CleanArchitectureFootItAppTheme
import com.app_preference.data.AppPreferenceDataStore

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val goalsVM : GoalsVM by viewModels()
    val stepsVM : StepsVM by viewModels()

    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val footItDatabase = FootItDatabase.getInstance(application)
        val goalsDao = footItDatabase.goalsDao();
        val stepsDao = footItDatabase.stepsDao();
        var goalsRepos = GoalSettingRepos(goalsDao, stepsDao)
        val context = applicationContext
        val dataStore = AppModule.getDataStore(context)
        val appPreferenceVM = AppPreferenceVM(AppPreferenceDataStore(dataStore))

        window.requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS)
        setContent {
            CleanArchitectureFootItAppTheme() {
                Surface(color = MaterialTheme.colors.background) {
                            val navController = rememberNavController()
                            NavHost(
                                navController = navController,
                                startDestination = Screen.stepsScreen.route)
                            {
                                composable(route = Screen.stepsScreen.route) {
                                NavBarScreen(goalsRepos,appPreferenceVM)
                            }
                        }
                    }
                }
            }
        }
    }
