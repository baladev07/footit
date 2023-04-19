package com.agsr.footit.feature_agsr.domain.repository

import androidx.lifecycle.MutableLiveData
import com.agsr.footit.feature_agsr.data.datasource.GoalsDao
import com.agsr.footit.feature_agsr.data.datasource.StepsDao
import com.agsr.footit.feature_agsr.domain.model.Goal
import com.agsr.footit.feature_agsr.domain.model.Steps
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class GoalSettingRepos (private val goalsDao : GoalsDao, private val stepsDao: StepsDao)  {

    private val corotineScope  = CoroutineScope(Dispatchers.Main)
    val allGoals = MutableLiveData<List<Goal>>()
    var allSteps =  MutableLiveData<List<Steps>>();
    var stepsByDate =  MutableLiveData<Steps>();

    fun insertGoal(goalObj : Goal) {
        corotineScope.launch(Dispatchers.IO) {
            goalsDao.insertGoal(goalObj);
        }
    }

    fun getGoals() {
        corotineScope.launch(Dispatchers.IO) {
            allGoals.postValue(goalsDao.getGoals())
        }
    }

    fun updateGoal(goalObj : Goal) {
        corotineScope.launch(Dispatchers.IO) {
            goalsDao.updateGoal(goalObj);
            getGoals();
        }
    }

    fun deleteGoal(goalObj : Goal) {
        corotineScope.launch(Dispatchers.IO) {
            goalsDao.deleteGoal(goalObj.GoalId);
            getGoals();
        }
    }

    //steps section
    fun getSteps() {
        corotineScope.launch(Dispatchers.IO) {
            allSteps.postValue(stepsDao.getSteps())
        }
    }

    fun getStepsByDate(activityDate : String) {
        corotineScope.launch(Dispatchers.IO) {
            stepsByDate.postValue(stepsDao.getStepsByDate(activityDate))
        }
    }


    fun insertStep(stepObj : Steps) {
        corotineScope.launch(Dispatchers.IO) {
            stepsDao.insertSteps(stepObj);
        }
    }

    fun updateStep(stepObj : Steps) {
        corotineScope.launch(Dispatchers.IO) {
            stepsDao.updateSteps(stepObj);
        }
    }

}