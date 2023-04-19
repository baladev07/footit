package com.agsr.footit.feature_agsr.data.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0014\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u000bH\u0016J\u001b\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\u0019\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lcom/agsr/footit/feature_agsr/data/repository/UserRepositoryImpl;", "Lcom/agsr/footit/feature_agsr/domain/repository/UserRepository;", "dao", "Lcom/agsr/footit/feature_agsr/data/datasource/UserDao;", "(Lcom/agsr/footit/feature_agsr/data/datasource/UserDao;)V", "deleteUser", "", "user", "Lcom/agsr/footit/feature_agsr/domain/model/User;", "(Lcom/agsr/footit/feature_agsr/domain/model/User;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUser", "Lkotlinx/coroutines/flow/Flow;", "", "getUserById", "UserId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertUser", "app_debug"})
public final class UserRepositoryImpl implements com.agsr.footit.feature_agsr.domain.repository.UserRepository {
    private final com.agsr.footit.feature_agsr.data.datasource.UserDao dao = null;
    
    public UserRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.agsr.footit.feature_agsr.data.datasource.UserDao dao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.agsr.footit.feature_agsr.domain.model.User>> getUser() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getUserById(int UserId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.agsr.footit.feature_agsr.domain.model.User> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object insertUser(@org.jetbrains.annotations.NotNull()
    com.agsr.footit.feature_agsr.domain.model.User user, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object deleteUser(@org.jetbrains.annotations.NotNull()
    com.agsr.footit.feature_agsr.domain.model.User user, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}