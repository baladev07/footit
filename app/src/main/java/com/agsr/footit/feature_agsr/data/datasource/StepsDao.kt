package com.agsr.footit.feature_agsr.data.datasource

import androidx.room.*
import com.agsr.footit.feature_agsr.domain.model.Steps
import kotlinx.coroutines.flow.Flow
@Dao
interface StepsDao {
    @Query("SELECT * FROM Steps WHERE IsDeleted = false ORDER BY ActivityDate Desc")
    fun getSteps(): List<Steps>

    @Query("SELECT * FROM Steps WHERE ActivityDate = :ActivityDate AND IsDeleted = false")
    fun getStepsByDate(ActivityDate: String): Steps

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSteps(steps: Steps)

    @Update
    suspend fun updateSteps(steps : Steps)

    @Delete
    suspend fun deleteSteps(steps: Steps)
}