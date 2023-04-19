package com.agsr.footit.feature_agsr.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.*

@Entity(
tableName = "Steps"
)
data class Steps (
    var StepCount : Int = 0,
    var ActivityDate : String = "",
    @ColumnInfo(defaultValue = Calendar.DATE.toString())
    var CreatedTimeStamp : String = "",
    @ColumnInfo(defaultValue = Calendar.DATE.toString())
    var UpdatedTimeStamp : String = "",
    @ColumnInfo(defaultValue = "false")
    var IsDeleted : Boolean = false,
    var GoalId : Int? = null,
    var GoalName : String = "",
    var GoalStep : Int = 0,
    //keys
    @PrimaryKey(autoGenerate = true)
    var StepId : Int = 0 )
{}