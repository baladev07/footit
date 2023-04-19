package com.app_preference.di

import com.app_preference.AppPreference
import com.app_preference.data.AppPreferenceDataStore
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@InstallIn(ViewModelComponent::class)
@Module
abstract class AppPreferencesModule {

    @Binds
    abstract fun bindAppPreferences(impl: AppPreferenceDataStore): AppPreference

}