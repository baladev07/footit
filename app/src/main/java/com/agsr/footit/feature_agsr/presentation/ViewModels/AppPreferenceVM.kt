package com.agsr.footit.feature_agsr.presentation.ViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app_preference.AppPreference
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AppPreferenceVM @Inject constructor(private val appPreference: AppPreference): ViewModel(){


    val canEditGoal: StateFlow<Boolean> = appPreference.canEditGoal()
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(),
            true
        )

    fun saveCanEditGoalPreference(value:Boolean) {
        viewModelScope.launch {
            appPreference.saveCanEditGoalPreference(value)
        }
    }

    val canEditHistory: StateFlow<Boolean> = appPreference.canEditHistory()
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(),
            true
        )

    fun saveCanEditHistoryPreference(value:Boolean) {
        viewModelScope.launch {
            appPreference.saveCanEditHistoryPreference(value)
        }
    }
}