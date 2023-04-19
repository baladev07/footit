package com.agsr.footit.feature_agsr.data.datasource

import androidx.room.*
import kotlinx.coroutines.flow.Flow

//user defined packages
import com.agsr.footit.feature_agsr.domain.model.User
@Dao
interface UserDao {

    @Query("SELECT * FROM User")
    fun getUser(): Flow<List<User>>

    @Query("SELECT * FROM User WHERE UserId = :UserId")
    suspend fun getUserById(UserId: Int): User?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

}