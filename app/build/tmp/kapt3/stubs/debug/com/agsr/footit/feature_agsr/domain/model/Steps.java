package com.agsr.footit.feature_agsr.domain.model;

import java.lang.System;

@androidx.room.Entity(tableName = "Steps")
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b0\b\u0087\b\u0018\u00002\u00020\u0001Ba\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u000eJ\t\u0010*\u001a\u00020\u0003H\u00c6\u0003J\t\u0010+\u001a\u00020\u0005H\u00c6\u0003J\t\u0010,\u001a\u00020\u0005H\u00c6\u0003J\t\u0010-\u001a\u00020\u0005H\u00c6\u0003J\t\u0010.\u001a\u00020\tH\u00c6\u0003J\u0010\u0010/\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0016J\t\u00100\u001a\u00020\u0005H\u00c6\u0003J\t\u00101\u001a\u00020\u0003H\u00c6\u0003J\t\u00102\u001a\u00020\u0003H\u00c6\u0003Jj\u00103\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003H\u00c6\u0001\u00a2\u0006\u0002\u00104J\u0013\u00105\u001a\u00020\t2\b\u00106\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00107\u001a\u00020\u0003H\u00d6\u0001J\t\u00108\u001a\u00020\u0005H\u00d6\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001e\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u000b\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010\u001fR\u001e\u0010\r\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001d\"\u0004\b\'\u0010\u001fR\u001e\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0010\"\u0004\b)\u0010\u0012\u00a8\u00069"}, d2 = {"Lcom/agsr/footit/feature_agsr/domain/model/Steps;", "", "StepCount", "", "ActivityDate", "", "CreatedTimeStamp", "UpdatedTimeStamp", "IsDeleted", "", "GoalId", "GoalName", "GoalStep", "StepId", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/String;II)V", "getActivityDate", "()Ljava/lang/String;", "setActivityDate", "(Ljava/lang/String;)V", "getCreatedTimeStamp", "setCreatedTimeStamp", "getGoalId", "()Ljava/lang/Integer;", "setGoalId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getGoalName", "setGoalName", "getGoalStep", "()I", "setGoalStep", "(I)V", "getIsDeleted", "()Z", "setIsDeleted", "(Z)V", "getStepCount", "setStepCount", "getStepId", "setStepId", "getUpdatedTimeStamp", "setUpdatedTimeStamp", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Integer;Ljava/lang/String;II)Lcom/agsr/footit/feature_agsr/domain/model/Steps;", "equals", "other", "hashCode", "toString", "app_debug"})
public final class Steps {
    private int StepCount;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String ActivityDate;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(defaultValue = "5")
    private java.lang.String CreatedTimeStamp;
    @org.jetbrains.annotations.NotNull()
    @androidx.room.ColumnInfo(defaultValue = "5")
    private java.lang.String UpdatedTimeStamp;
    @androidx.room.ColumnInfo(defaultValue = "false")
    private boolean IsDeleted;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer GoalId;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String GoalName;
    private int GoalStep;
    @androidx.room.PrimaryKey(autoGenerate = true)
    private int StepId;
    
    @org.jetbrains.annotations.NotNull()
    public final com.agsr.footit.feature_agsr.domain.model.Steps copy(int StepCount, @org.jetbrains.annotations.NotNull()
    java.lang.String ActivityDate, @org.jetbrains.annotations.NotNull()
    java.lang.String CreatedTimeStamp, @org.jetbrains.annotations.NotNull()
    java.lang.String UpdatedTimeStamp, boolean IsDeleted, @org.jetbrains.annotations.Nullable()
    java.lang.Integer GoalId, @org.jetbrains.annotations.NotNull()
    java.lang.String GoalName, int GoalStep, int StepId) {
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
    
    public Steps() {
        super();
    }
    
    public Steps(int StepCount, @org.jetbrains.annotations.NotNull()
    java.lang.String ActivityDate, @org.jetbrains.annotations.NotNull()
    java.lang.String CreatedTimeStamp, @org.jetbrains.annotations.NotNull()
    java.lang.String UpdatedTimeStamp, boolean IsDeleted, @org.jetbrains.annotations.Nullable()
    java.lang.Integer GoalId, @org.jetbrains.annotations.NotNull()
    java.lang.String GoalName, int GoalStep, int StepId) {
        super();
    }
    
    public final int component1() {
        return 0;
    }
    
    public final int getStepCount() {
        return 0;
    }
    
    public final void setStepCount(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getActivityDate() {
        return null;
    }
    
    public final void setActivityDate(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
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
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUpdatedTimeStamp() {
        return null;
    }
    
    public final void setUpdatedTimeStamp(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean component5() {
        return false;
    }
    
    public final boolean getIsDeleted() {
        return false;
    }
    
    public final void setIsDeleted(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getGoalId() {
        return null;
    }
    
    public final void setGoalId(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getGoalName() {
        return null;
    }
    
    public final void setGoalName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final int component8() {
        return 0;
    }
    
    public final int getGoalStep() {
        return 0;
    }
    
    public final void setGoalStep(int p0) {
    }
    
    public final int component9() {
        return 0;
    }
    
    public final int getStepId() {
        return 0;
    }
    
    public final void setStepId(int p0) {
    }
}