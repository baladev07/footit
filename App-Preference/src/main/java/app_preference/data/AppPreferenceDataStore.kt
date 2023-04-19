package com.app_preference.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.app_preference.AppPreference
import com.app_preference.data.KEYS.KEY_EDIT_GOAL
import com.app_preference.data.KEYS.KEY_EDIT_HISTORY
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AppPreferenceDataStore @Inject constructor(private val dataStore: DataStore<androidx.datastore.preferences.core.Preferences>):
    AppPreference {
    override fun canEditGoal(): Flow<Boolean> {
        return dataStore.data.map { it[KEY_EDIT_GOAL]=="true"}
    }

    override suspend fun saveCanEditGoalPreference(value: Boolean) {
        dataStore.edit { preference ->
            preference[KEY_EDIT_GOAL] = value.toString()
        }
    }

    override fun canEditHistory(): Flow<Boolean> {
        return dataStore.data.map { it[KEY_EDIT_HISTORY] =="true"}
    }

    override suspend fun saveCanEditHistoryPreference(value: Boolean) {
        dataStore.edit { preference ->
            preference[KEY_EDIT_HISTORY] = value.toString()
        }
    }


}

object KEYS {
    val KEY_EDIT_GOAL = stringPreferencesKey("edit_goal")
    val KEY_EDIT_HISTORY = stringPreferencesKey("edit_history")
}