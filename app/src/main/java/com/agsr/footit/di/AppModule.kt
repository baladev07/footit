package com.agsr.footit.di

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStoreFile
import androidx.room.Room
import androidx.room.RoomDatabase
import com.agsr.footit.feature_agsr.data.datasource.FootItDatabase
import com.agsr.footit.feature_agsr.data.datasource.GoalsDao
import com.agsr.footit.feature_agsr.data.datasource.StepsDao
import com.agsr.footit.feature_agsr.domain.repository.GoalSettingRepos
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import androidx.datastore.preferences.core.Preferences

import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent:: class)
object AppModule {

    @Provides
    @Singleton
    fun goalSettingRepos(goalsDao: GoalsDao, stepsDao : StepsDao) : GoalSettingRepos = GoalSettingRepos(goalsDao, stepsDao)
    @Provides
    @Singleton
    fun provideFootItdataBase(@ApplicationContext context : Context) : FootItDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            FootItDatabase::class.java,
            "db_footit"
            ).build()
    }

    @Provides
    fun getDataStore(@ApplicationContext context: Context): DataStore<Preferences> {
        return PreferenceDataStoreFactory.create(
            corruptionHandler = ReplaceFileCorruptionHandler(
                produceNewData = { emptyPreferences() }
            ),
            produceFile = { context.preferencesDataStoreFile("app_data") }
        )
    }

}