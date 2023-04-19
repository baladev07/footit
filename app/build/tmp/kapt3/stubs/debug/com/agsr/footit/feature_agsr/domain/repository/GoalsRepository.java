package com.agsr.footit.feature_agsr.domain.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\'\u0010\u000b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r\u0018\u00010\f2\u0006\u0010\u000e\u001a\u00020\tH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0014\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\fH&J\u0019\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0011"}, d2 = {"Lcom/agsr/footit/feature_agsr/domain/repository/GoalsRepository;", "", "deleteGoal", "", "goal", "Lcom/agsr/footit/feature_agsr/domain/model/Goal;", "(Lcom/agsr/footit/feature_agsr/domain/model/Goal;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGoalById", "GoalId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGoalByUserId", "Lkotlinx/coroutines/flow/Flow;", "", "userId", "getGoals", "insertGoal", "app_debug"})
public abstract interface GoalsRepository {
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.agsr.footit.feature_agsr.domain.model.Goal>> getGoals();
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getGoalById(int GoalId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.agsr.footit.feature_agsr.domain.model.Goal> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getGoalByUserId(int userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends java.util.List<com.agsr.footit.feature_agsr.domain.model.Goal>>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertGoal(@org.jetbrains.annotations.NotNull()
    com.agsr.footit.feature_agsr.domain.model.Goal goal, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteGoal(@org.jetbrains.annotations.NotNull()
    com.agsr.footit.feature_agsr.domain.model.Goal goal, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
}