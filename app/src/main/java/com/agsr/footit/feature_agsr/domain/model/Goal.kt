package com.agsr.footit.feature_agsr.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey
import java.util.*
import java.util.Calendar;

@Entity(
//    foreignKeys  = [ForeignKey(
//        entity = User::class,
//        parentColumns =  arrayOf("UserId"),
//        childColumns =  arrayOf("GoalId"),
//        onUpdate = ForeignKey.CASCADE,
//        onDelete = ForeignKey.CASCADE
//    )]
    tableName = "Goal"
)
data class Goal(
    var GoalName : String = "",
    var StepCount : String = "",
    var IsGoalActive : Boolean = false,
    @ColumnInfo(defaultValue = Calendar.DATE.toString())
    var CreatedTimeStamp : String = "",
    @ColumnInfo(defaultValue = Calendar.DATE.toString())
    var UpdatedTimeStamp : String = "",
    @ColumnInfo(defaultValue = "false")
    var IsDeleted : Boolean = false,
    //keys
    @PrimaryKey(autoGenerate = true)
    var GoalId : Int = 0
)

