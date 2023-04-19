package com.agsr.footit.feature_agsr.data.datasource;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fH\'J\u0019\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"Lcom/agsr/footit/feature_agsr/data/datasource/GoalsDao;", "", "deleteGoal", "", "goal", "Lcom/agsr/footit/feature_agsr/domain/model/Goal;", "(Lcom/agsr/footit/feature_agsr/domain/model/Goal;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGoalById", "GoalId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGoals", "", "insertGoal", "updateGoal", "app_debug"})
public abstract interface GoalsDao {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM Goal WHERE IsDeleted = false")
    public abstract java.util.List<com.agsr.footit.feature_agsr.domain.model.Goal> getGoals();
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM Goal WHERE GoalId = :GoalId")
    public abstract java.lang.Object getGoalById(int GoalId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.agsr.footit.feature_agsr.domain.model.Goal> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert(onConflict = 1)
    public abstract java.lang.Object insertGoal(@org.jetbrains.annotations.NotNull()
    com.agsr.footit.feature_agsr.domain.model.Goal goal, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Update()
    public abstract java.lang.Object updateGoal(@org.jetbrains.annotations.NotNull()
    com.agsr.footit.feature_agsr.domain.model.Goal goal, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Delete()
    public abstract java.lang.Object deleteGoal(@org.jetbrains.annotations.NotNull()
    com.agsr.footit.feature_agsr.domain.model.Goal goal, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
}