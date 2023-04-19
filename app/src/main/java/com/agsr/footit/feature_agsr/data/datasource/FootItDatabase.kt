package com.agsr.footit.feature_agsr.data.datasource

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.agsr.footit.feature_agsr.domain.model.*

@Database(entities = [User::class, Steps::class, Goal :: class], version = 4,exportSchema = true)
abstract class FootItDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao;
    abstract fun stepsDao(): StepsDao
    abstract fun goalsDao(): GoalsDao;


    companion object {
        const val DATABASE_NAME = "db_footit"

        @Volatile
        private var INSTANCE:FootItDatabase?=null

        fun getInstance(context:Context):FootItDatabase
        {
            synchronized(this)
            {
                var instance = INSTANCE
                if(instance == null)
                {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        FootItDatabase::class.java,
                        "db_footit"
                    ).fallbackToDestructiveMigration()
                        .addCallback(object : RoomDatabase.Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            db.execSQL(
                                "INSERT INTO Goal (GoalName, StepCount,IsGoalActive, CreatedTimeStamp, UpdatedTimeStamp, IsDeleted) VALUES ('Default goals', '2500', 1, '','', 0)"
                            )
                        }
                    }).build()

                    INSTANCE = instance
                }

                return instance;
                }
        }
    }
}
