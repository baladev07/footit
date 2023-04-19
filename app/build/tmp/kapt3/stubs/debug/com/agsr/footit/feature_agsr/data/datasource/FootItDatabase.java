package com.agsr.footit.feature_agsr.data.datasource;

import java.lang.System;

@androidx.room.Database(entities = {com.agsr.footit.feature_agsr.domain.model.User.class, com.agsr.footit.feature_agsr.domain.model.Steps.class, com.agsr.footit.feature_agsr.domain.model.Goal.class}, version = 4, exportSchema = true)
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\n"}, d2 = {"Lcom/agsr/footit/feature_agsr/data/datasource/FootItDatabase;", "Landroidx/room/RoomDatabase;", "()V", "goalsDao", "Lcom/agsr/footit/feature_agsr/data/datasource/GoalsDao;", "stepsDao", "Lcom/agsr/footit/feature_agsr/data/datasource/StepsDao;", "userDao", "Lcom/agsr/footit/feature_agsr/data/datasource/UserDao;", "Companion", "app_debug"})
public abstract class FootItDatabase extends androidx.room.RoomDatabase {
    @org.jetbrains.annotations.NotNull()
    public static final com.agsr.footit.feature_agsr.data.datasource.FootItDatabase.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DATABASE_NAME = "db_footit";
    @kotlin.jvm.Volatile()
    private static volatile com.agsr.footit.feature_agsr.data.datasource.FootItDatabase INSTANCE;
    
    public FootItDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.agsr.footit.feature_agsr.data.datasource.UserDao userDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.agsr.footit.feature_agsr.data.datasource.StepsDao stepsDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.agsr.footit.feature_agsr.data.datasource.GoalsDao goalsDao();
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/agsr/footit/feature_agsr/data/datasource/FootItDatabase$Companion;", "", "()V", "DATABASE_NAME", "", "INSTANCE", "Lcom/agsr/footit/feature_agsr/data/datasource/FootItDatabase;", "getInstance", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.agsr.footit.feature_agsr.data.datasource.FootItDatabase getInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
    }
}