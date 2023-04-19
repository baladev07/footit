package com.agsr.footit.feature_agsr.presentation.footit_goal_setup.components;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 2, d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a(\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0007\u001a\u0018\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007\u001a\u0010\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0010\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a4\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\nH\u0007\u001a\u0018\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0007\u001a&\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00140\u001c2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007\u001a\u0010\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u00a8\u0006\u001e"}, d2 = {"AddEditGoalPopup", "", "goalsVM", "Lcom/agsr/footit/feature_agsr/presentation/ViewModels/GoalsVM;", "CustomSnackBar", "modifier", "Landroidx/compose/ui/Modifier;", "title", "", "onAction", "Lkotlin/Function0;", "GoalsScreen", "goalSettingRepos", "Lcom/agsr/footit/feature_agsr/domain/repository/GoalSettingRepos;", "appPreferenceVM", "Lcom/agsr/footit/feature_agsr/presentation/ViewModels/AppPreferenceVM;", "ShowToasters", "addGoalFloatingButton", "alert", "goal", "Lcom/agsr/footit/feature_agsr/domain/model/Goal;", "showDialog", "Landroidx/compose/runtime/MutableState;", "", "onDismiss", "listOfGoals", "showGoalsWithSwipeList", "goalsList", "", "showHideAddorEditGoal", "app_debug"})
public final class GoalsScreenKt {
    
    @androidx.compose.runtime.Composable()
    public static final void GoalsScreen(@org.jetbrains.annotations.NotNull()
    com.agsr.footit.feature_agsr.domain.repository.GoalSettingRepos goalSettingRepos, @org.jetbrains.annotations.NotNull()
    com.agsr.footit.feature_agsr.presentation.ViewModels.AppPreferenceVM appPreferenceVM) {
    }
    
    @androidx.compose.runtime.Composable()
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    public static final void listOfGoals(@org.jetbrains.annotations.NotNull()
    com.agsr.footit.feature_agsr.presentation.ViewModels.GoalsVM goalsVM, @org.jetbrains.annotations.NotNull()
    com.agsr.footit.feature_agsr.presentation.ViewModels.AppPreferenceVM appPreferenceVM) {
    }
    
    @androidx.compose.material3.ExperimentalMaterial3Api()
    @androidx.compose.runtime.Composable()
    @kotlin.OptIn(markerClass = {androidx.compose.foundation.ExperimentalFoundationApi.class})
    public static final void showGoalsWithSwipeList(@org.jetbrains.annotations.NotNull()
    com.agsr.footit.feature_agsr.presentation.ViewModels.GoalsVM goalsVM, @org.jetbrains.annotations.NotNull()
    java.util.List<com.agsr.footit.feature_agsr.domain.model.Goal> goalsList, @org.jetbrains.annotations.NotNull()
    com.agsr.footit.feature_agsr.presentation.ViewModels.AppPreferenceVM appPreferenceVM) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void showHideAddorEditGoal(@org.jetbrains.annotations.NotNull()
    com.agsr.footit.feature_agsr.presentation.ViewModels.GoalsVM goalsVM) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void addGoalFloatingButton(@org.jetbrains.annotations.NotNull()
    com.agsr.footit.feature_agsr.presentation.ViewModels.GoalsVM goalsVM) {
    }
    
    @androidx.compose.runtime.Composable()
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    public static final void AddEditGoalPopup(@org.jetbrains.annotations.NotNull()
    com.agsr.footit.feature_agsr.presentation.ViewModels.GoalsVM goalsVM) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void CustomSnackBar(@org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onAction) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ShowToasters(@org.jetbrains.annotations.NotNull()
    com.agsr.footit.feature_agsr.presentation.ViewModels.GoalsVM goalsVM) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void alert(@org.jetbrains.annotations.NotNull()
    com.agsr.footit.feature_agsr.presentation.ViewModels.GoalsVM goalsVM, @org.jetbrains.annotations.NotNull()
    com.agsr.footit.feature_agsr.domain.model.Goal goal, @org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<java.lang.Boolean> showDialog, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDismiss) {
    }
}