package com.agsr.footit.feature_agsr.data.datasource;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003H\'\u00a8\u0006\u0007"}, d2 = {"Lcom/agsr/footit/feature_agsr/data/datasource/UserAndGoalsDao;", "", "loadUserAndGoals", "", "Lcom/agsr/footit/feature_agsr/domain/model/User;", "", "Lcom/agsr/footit/feature_agsr/domain/model/Goal;", "app_debug"})
public abstract interface UserAndGoalsDao {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM User userJOIN Goal goal ON user.UserId = goal.UserId")
    public abstract java.util.Map<com.agsr.footit.feature_agsr.domain.model.User, java.util.List<com.agsr.footit.feature_agsr.domain.model.Goal>> loadUserAndGoals();
}