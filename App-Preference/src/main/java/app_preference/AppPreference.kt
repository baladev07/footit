package com.app_preference

import kotlinx.coroutines.flow.Flow

interface AppPreference {

    fun canEditGoal():Flow<Boolean>

    suspend fun saveCanEditGoalPreference(value:Boolean)

    fun canEditHistory():Flow<Boolean>

    suspend fun saveCanEditHistoryPreference(value:Boolean)
}