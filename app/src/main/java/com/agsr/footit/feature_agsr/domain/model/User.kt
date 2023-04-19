package com.agsr.footit.feature_agsr.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity (
    tableName = "user"
        )
data class  User (
    val FirstName : String,
    val LastName : String,
    val DateFormatType : Int,
    val MetricType : Int,
    @ColumnInfo(defaultValue = Calendar.DATE.toString())
    val CreatedTimeStamp : String,
    @ColumnInfo(defaultValue = Calendar.DATE.toString())
    val UpdatedTimeStamp : String,
    @ColumnInfo(defaultValue = "false")
    val IsDeleted : Boolean,
    //keys
    @PrimaryKey val UserId: Int
) {

}