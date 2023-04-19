package com.agsr.footit.feature_agsr.data.datasource

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import com.agsr.footit.feature_agsr.domain.model.Goal
import com.agsr.footit.feature_agsr.domain.model.Steps
import kotlinx.coroutines.flow.Flow

@Dao
public interface GoalsDao {
    @Query("SELECT * FROM Goal WHERE IsDeleted = false")
    fun getGoals(): List<Goal>;

    @Query("SELECT * FROM Goal WHERE GoalId = :GoalId")
    suspend fun getGoalById(GoalId: Int): Goal?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGoal(goal: Goal)

    @Update
    suspend fun updateGoal(goal : Goal)

    @Query("DELETE FROM Goal WHERE GoalId = :id")
    suspend fun deleteGoal(id:Int)
}