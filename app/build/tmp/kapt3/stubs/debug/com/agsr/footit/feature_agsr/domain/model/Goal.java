package com.agsr.footit.feature_agsr.domain.model;

import java.lang.System;

@androidx.room.Entity(tableName = "Goal")
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\"\b\u0087\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\t\u0010!\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0003H\u00c6\u0003J\t\u0010#\u001a\u00020\u0006H\u00c6\u0003J\t\u0010$\u001a\u00020\u0003H\u00c6\u0003J\t\u0010%\u001a\u00020\u0003H\u00c6\u0003J\t\u0010&\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\'\u001a\u00020\u000bH\u00c6\u0003JO\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u000bH\u00c6\u0001J\u0013\u0010)\u001a\u00020\u00062\b\u0010*\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010+\u001a\u00020\u000bH\u00d6\u0001J\t\u0010,\u001a\u00020\u0003H\u00d6\u0001R\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u001e\u0010\t\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000e\"\u0004\b\u001e\u0010\u0010R\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000e\"\u0004\b \u0010\u0010\u00a8\u0006-"}, d2 = {"Lcom/agsr/footit/feature_agsr/domain/model/Goal;", "", "GoalName", "", "StepCount", "IsGoalActive", "", "CreatedTimeStamp", "UpdatedTimeStamp", "IsDeleted", "GoalId", "", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZI)V", "getCreatedTimeStamp", "()Ljava/lang/String;", "setCreatedTimeStamp", "(Ljava/lang/String;)V", "getGoalId", "()I", "setGoalId", "(I)V", "getGoalName", "setGoalName", "getIsDeleted", "()Z", "setIsDeleted", "(Z)V", "getIsGoalActive", "setIsGoalActive", "getStepCount", "setStepCount", "getUpdatedTimeStamp", "setUpdatedTimeStamp", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
public final class Goal {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String GoalName;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String StepCount;
    private boolean IsGoalActive;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(defaultValue = "5")
    private java.lang.String CreatedTimeStamp;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(defaultValue = "5")
    private java.lang.String UpdatedTimeStamp;
    @androidx.room.ColumnInfo(defaultValue = "false")
    private boolean IsDeleted;
    @androidx.room.PrimaryKey(autoGenerate = true)
    private int GoalId;
    
    @org.jetbrains.annotations.NotNull()
    public final com.agsr.footit.feature_agsr.domain.model.Goal copy(@org.jetbrains.annotations.NotNull()
    java.lang.String GoalName, @org.jetbrains.annotations.NotNull()
    java.lang.String StepCount, boolean IsGoalActive, @org.jetbrains.annotations.NotNull()
    java.lang.String CreatedTimeStamp, @org.jetbrains.annotations.NotNull()
    java.lang.String UpdatedTimeStamp, boolean IsDeleted, int GoalId) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public Goal() {
        super();
    }
    
    public Goal(@org.jetbrains.annotations.NotNull()
    java.lang.String GoalName, @org.jetbrains.annotations.NotNull()
    java.lang.String StepCount, boolean IsGoalActive, @org.jetbrains.annotations.NotNull()
    java.lang.String CreatedTimeStamp, @org.jetbrains.annotations.NotNull()
    java.lang.String UpdatedTimeStamp, boolean IsDeleted, int GoalId) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getGoalName() {
        return null;
    }
    
    public final void setGoalName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getStepCount() {
        return null;
    }
    
    public final void setStepCount(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean component3() {
        return false;
    }
    
    public final boolean getIsGoalActive() {
        return false;
    }
    
    public final void setIsGoalActive(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCreatedTimeStamp() {
        return null;
    }
    
    public final void setCreatedTimeStamp(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUpdatedTimeStamp() {
        return null;
    }
    
    public final void setUpdatedTimeStamp(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean component6() {
        return false;
    }
    
    public final boolean getIsDeleted() {
        return false;
    }
    
    public final void setIsDeleted(boolean p0) {
    }
    
    public final int component7() {
        return 0;
    }
    
    public final int getGoalId() {
        return 0;
    }
    
    public final void setGoalId(int p0) {
    }
}