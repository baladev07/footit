package com.agsr.footit.feature_agsr.presentation.footit_steps;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 2, d1 = {"\u0000*\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007\u001a\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007\u001a\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007\u001a\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007\u001a\u0010\u0010\u0012\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007\u001a\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007\u001a\u000e\u0010\u0014\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n\u001a\u0018\u0010\u0015\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007\" \u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0016"}, d2 = {"stepsList", "", "Lcom/agsr/footit/feature_agsr/domain/model/Steps;", "getStepsList", "()Ljava/util/List;", "setStepsList", "(Ljava/util/List;)V", "AddEditStepContents", "", "stepsVM", "Lcom/agsr/footit/feature_agsr/presentation/ViewModels/StepsVM;", "AddEditStepsDialog", "StepsScreen", "goalsSettingRepos", "Lcom/agsr/footit/feature_agsr/domain/repository/GoalSettingRepos;", "navController", "Landroidx/navigation/NavController;", "activityDatePicker", "dropDownChooser", "dropDownGoalsList", "showAddStepsDialog", "stepScreenElements", "app_debug"})
public final class StepsScreenKt {
    @org.jetbrains.annotations.NotNull()
    private static java.util.List<com.agsr.footit.feature_agsr.domain.model.Steps> stepsList;
    
    @org.jetbrains.annotations.NotNull()
    public static final java.util.List<com.agsr.footit.feature_agsr.domain.model.Steps> getStepsList() {
        return null;
    }
    
    public static final void setStepsList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.agsr.footit.feature_agsr.domain.model.Steps> p0) {
    }
    
    @androidx.compose.runtime.Composable()
    @androidx.compose.ui.tooling.preview.Preview()
    public static final void StepsScreen(@org.jetbrains.annotations.NotNull()
    com.agsr.footit.feature_agsr.domain.repository.GoalSettingRepos goalsSettingRepos, @org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController) {
    }
    
    @androidx.compose.runtime.Composable()
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    public static final void stepScreenElements(@org.jetbrains.annotations.NotNull()
    com.agsr.footit.feature_agsr.presentation.ViewModels.StepsVM stepsVM, @org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController) {
    }
    
    public static final void showAddStepsDialog(@org.jetbrains.annotations.NotNull()
    com.agsr.footit.feature_agsr.presentation.ViewModels.StepsVM stepsVM) {
    }
    
    @androidx.compose.runtime.Composable()
    @androidx.compose.material3.ExperimentalMaterial3Api()
    public static final void AddEditStepsDialog(@org.jetbrains.annotations.NotNull()
    com.agsr.footit.feature_agsr.presentation.ViewModels.StepsVM stepsVM) {
    }
    
    @androidx.compose.runtime.Composable()
    @androidx.compose.material3.ExperimentalMaterial3Api()
    public static final void AddEditStepContents(@org.jetbrains.annotations.NotNull()
    com.agsr.footit.feature_agsr.presentation.ViewModels.StepsVM stepsVM) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void dropDownChooser(@org.jetbrains.annotations.NotNull()
    com.agsr.footit.feature_agsr.presentation.ViewModels.StepsVM stepsVM) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void dropDownGoalsList(@org.jetbrains.annotations.NotNull()
    com.agsr.footit.feature_agsr.presentation.ViewModels.StepsVM stepsVM) {
    }
    
    @androidx.compose.runtime.Composable()
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    public static final void activityDatePicker(@org.jetbrains.annotations.NotNull()
    com.agsr.footit.feature_agsr.presentation.ViewModels.StepsVM stepsVM) {
    }
}