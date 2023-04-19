package com.agsr.footit.feature_agsr.presentation.ViewModels

import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.agsr.footit.feature_agsr.domain.model.Goal
import com.agsr.footit.feature_agsr.domain.model.Steps
import com.agsr.footit.feature_agsr.domain.repository.GoalSettingRepos
import kotlinx.coroutines.Job
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class StepsVM
@Inject constructor(private val goalSettingRepos : GoalSettingRepos)
    : ViewModel() {
    //db variables
    var allDaysSteps : LiveData<List<Steps>> = goalSettingRepos.allSteps;
    var allGoalsList: LiveData<List<Goal>> = goalSettingRepos.allGoals;

    //show hide variables
    var isAddEditStepDialog = mutableStateOf(false);
    var goalDropDownExpanded = mutableStateOf(false);
    var showActivityDatePicker = mutableStateOf(false);

    //messages variables
    var goalAchievementText = mutableStateOf("");

    //state variables
    var stepsProgressed : MutableState<Int?> = mutableStateOf(0);
    var goalProgressPercenteage = mutableStateOf(0f);
    var stepsToAdd : MutableState<Int?> =  mutableStateOf(0);
    var stepsToCompleteGoal = mutableStateOf(0);

    //db variables
    var onTheDayGoalId = mutableStateOf(0);
    var onTheDayGoalName = mutableStateOf("")
    var onTheDayGoalStepCount = mutableStateOf(0)
    var ontheGoDate =  mutableStateOf("")
    var ontheDateStepsObj = mutableStateOf(Steps());
    var activeGoalObj = mutableStateOf(Goal());

    //util variables
    val numberPattern =  Regex("^\\d+\$");

    init {
        ontheGoDate.value = getTodayDateAsString();
    }

    fun initData() {
        goalSettingRepos?.getGoals();
        goalSettingRepos?.getSteps();
        //set current date to date object
        setDefaultValues();
       // insertDefaultGoalIffNoDefaultGoal();
    }

    fun setDefaultValues() {
        getActiveGoalFromGoalsList()
        getStepsByOnTheGoDate();

        //set on the go date value
        stepsProgressed.value = ontheDateStepsObj.value.StepCount;
    }

    fun getStepsByOnTheGoDate() {
        if(allDaysSteps !=  null && allDaysSteps.value != null &&
                    allDaysSteps!!.value!!.isNotEmpty())
        {
            //get current steps by date in list
            var filteredList = allDaysSteps!!.value!!.filter { step -> step.ActivityDate == ontheGoDate.value }
            if(filteredList !=  null && filteredList != null &&
                filteredList!!.isNotEmpty())
            {
                //set data from DB
                ontheDateStepsObj.value = filteredList[0];
                if(ontheDateStepsObj.value.GoalId != null)
                onTheDayGoalId.value = ontheDateStepsObj.value.GoalId!!;
                else
                    onTheDayGoalId.value = 0;
                onTheDayGoalName.value = ontheDateStepsObj.value.GoalName;
                onTheDayGoalStepCount.value = ontheDateStepsObj.value.GoalStep;
            }
            else {
                //create new instance and set data
                ontheDateStepsObj.value = Steps();
                //set active goal from goal page
                ontheDateStepsObj.value.GoalId = activeGoalObj.value.GoalId
                if(activeGoalObj.value.StepCount != null && activeGoalObj.value.StepCount != "")
                {
                    ontheDateStepsObj.value.GoalStep = activeGoalObj.value.StepCount.toInt();
                    onTheDayGoalName.value = activeGoalObj.value.GoalName
                    onTheDayGoalStepCount.value = ontheDateStepsObj.value.GoalStep;
                }
                else {
                    onTheDayGoalStepCount.value = 0;
                    ontheDateStepsObj.value.GoalStep = 0;
                    onTheDayGoalName.value = activeGoalObj.value.GoalName
                }
                ontheDateStepsObj.value.GoalName = activeGoalObj.value.GoalName
            }
        }
    }

    fun getActiveGoalFromGoalsList() {
        if(allGoalsList !=  null && allGoalsList.value != null &&
            allGoalsList!!.value!!.isNotEmpty()) {
            var filteredList = allGoalsList!!.value!!.filter { goal -> goal.IsGoalActive == true }
            if(filteredList !=  null && filteredList != null &&
                filteredList!!.isNotEmpty())
            {
                if(ontheDateStepsObj.value.GoalId == 0 || ontheDateStepsObj.value.GoalId == null) {
                    //set data from DB
                    activeGoalObj.value = filteredList[0];
                    onTheDayGoalId.value = activeGoalObj.value.GoalId;
                    onTheDayGoalName.value = activeGoalObj.value.GoalName;
                    if(activeGoalObj.value.StepCount != null && activeGoalObj.value.StepCount != "")
                    onTheDayGoalStepCount.value = "33".toInt()
                    else
                    onTheDayGoalStepCount.value = 0

                }
            }
        }
    }

    // on change and on input functions
    fun onGoalChange(goalId : Int) {
        ontheDateStepsObj.value.GoalId = goalId;
        if(goalId > 0) {
            if (allGoalsList != null && allGoalsList.value != null &&
                allGoalsList!!.value!!.isNotEmpty()
            ) {
                var filteredList = allGoalsList!!.value!!.filter { goal -> goal.GoalId == goalId }
                if (filteredList != null && filteredList != null &&
                    filteredList!!.isNotEmpty()
                ) {
                    //set data from DB
                    activeGoalObj.value = filteredList[0];
                    onTheDayGoalId.value = activeGoalObj.value.GoalId
                    onTheDayGoalName.value = activeGoalObj.value.GoalName
                    onTheDayGoalStepCount.value = activeGoalObj.value.StepCount.toInt()

                    ontheDateStepsObj.value.GoalId = activeGoalObj.value.GoalId;
                    ontheDateStepsObj.value.GoalStep = activeGoalObj.value.StepCount.toInt();
                    ontheDateStepsObj.value.GoalName = activeGoalObj.value.GoalName;
                    setProgressPercentage();
                    findStepsToAchieveTheGoal();
                    goalSettingRepos.updateStep(ontheDateStepsObj.value)
                }
            }
        }
        else {
            ontheDateStepsObj.value.GoalId = goalId;

            //set data from DB
            onTheDayGoalId.value = 0
            onTheDayGoalName.value = "-- Select One-- "
            onTheDayGoalStepCount.value = 0

            ontheDateStepsObj.value.GoalId = 0
            ontheDateStepsObj.value.GoalName  = "-- Select One --"
            ontheDateStepsObj.value.GoalStep = 0

            setProgressPercentage();
            findStepsToAchieveTheGoal();
            goalSettingRepos.updateStep(ontheDateStepsObj.value)
        }
        goalDropDownExpanded.value = false;
    }

    @OptIn(ExperimentalMaterial3Api::class)
    fun onDateChange(datePickerState : DatePickerState) {
        var timeStatmp : Long = if (datePickerState.selectedDateMillis != null) datePickerState.selectedDateMillis!! else 0;
        var sdf = SimpleDateFormat("dd/MM/YYYY")
        var date =  Date(timeStatmp);
        ontheGoDate.value =  sdf.format(date);
        showActivityDatePicker.value = false;
        setDefaultValues();
        setProgressPercentage();
        findStepsToAchieveTheGoal();
        goalSettingRepos?.getSteps();
    }

    // on steps entry from text box
    fun onStepsEntry(stepsValue : String) {
        if (stepsValue.isNotEmpty() && stepsValue != null)
        {
            if(stepsValue.matches(numberPattern))
            stepsToAdd.value = stepsValue.trim().toInt()
        }
        else
            stepsToAdd.value = null
    }

    fun addStepToProgress() {
        if(stepsToAdd.value != null) {
            if (stepsProgressed!!.value != null && stepsProgressed!!.value!! > 0) {
                stepsProgressed!!.value = stepsProgressed!!.value!! + stepsToAdd!!.value!!;
            } else {
                stepsProgressed!!.value = stepsToAdd.value;
            }
        }
        //set progress percentage
        //setProgressPercentage();
        ontheDateStepsObj.value.StepCount = stepsProgressed!!.value!!;
        insertOrUpdateOnTheDaySteps();
        stepsToAdd.value = null;
    }

    fun resetStepsActivityOntheGoDate() {
        if(onTheDayGoalId.value > 0) {
            if(ontheDateStepsObj.value != null)
            {
                    ontheDateStepsObj.value.StepCount = 0;
            }
            goalSettingRepos.updateStep(ontheDateStepsObj.value);
            stepsProgressed.value = 0;
            stepsToAdd.value = null;
        }
        else {
            ontheDateStepsObj.value = Steps();
        }
        setProgressPercentage();
        findStepsToAchieveTheGoal();
    }

    //db update insert functions
    fun insertOrUpdateOnTheDaySteps() {
        if(ontheDateStepsObj != null && ontheDateStepsObj.value != null)
        {
            if(ontheDateStepsObj.value.StepId > 0)
            {
                // update
                goalSettingRepos?.updateStep(stepObj = ontheDateStepsObj.value)
            }
            else {
                // insert
                setDataToCurrentStepObject()
                goalSettingRepos?.insertStep(stepObj = ontheDateStepsObj.value);
            }
        }
    }

    fun setDataToCurrentStepObject() {
        val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val current = formatter.format(Calendar.getInstance().time);
        ontheDateStepsObj.value = Steps(
            ActivityDate = ontheGoDate.value,
            StepId =  0,
            StepCount = stepsProgressed!!.value!!,
            UpdatedTimeStamp = current,
            CreatedTimeStamp = current,
            GoalId = onTheDayGoalId.value,
            IsDeleted = false,
            GoalStep = onTheDayGoalStepCount.value,
            GoalName = onTheDayGoalName.value,
        )
    }

    //UI functions
    fun setProgressPercentage() {
        if((ontheDateStepsObj.value.GoalStep != 0 && ontheDateStepsObj.value.GoalStep > 0) &&
            (stepsProgressed!!.value != null && stepsProgressed!!.value!! > 0))
        {
            var ratio = stepsProgressed!!.value!!.toFloat() / ontheDateStepsObj.value.GoalStep.toFloat();
            var percentage = ratio* 100;
            goalProgressPercenteage.value = percentage;
        }
        else {
            goalProgressPercenteage.value = 0f
        }
        generateGoalCompletednessText()
    }

    fun findStepsToAchieveTheGoal() {
        if((ontheDateStepsObj.value.GoalStep != 0 && ontheDateStepsObj.value.GoalStep > 0) &&
            (stepsProgressed!!.value != null && stepsProgressed!!.value!! > 0))
        {
            if(ontheDateStepsObj.value.GoalStep >= stepsProgressed!!.value!!)
            stepsToCompleteGoal.value = ontheDateStepsObj.value.GoalStep - stepsProgressed!!.value!!;
        }
        else if (stepsProgressed!!.value != null && stepsProgressed!!.value!! == 0)
        {
            stepsToCompleteGoal.value = ontheDateStepsObj.value.GoalStep;
        }
    }

    fun generateGoalCompletednessText() {
        if(stepsProgressed != null && stepsProgressed!!.value != null) {
            if (stepsProgressed!!.value!! < ontheDateStepsObj.value.GoalStep)
                goalAchievementText.value = stepsToCompleteGoal.value.toString() + " steps to achieve the goal";
            else if (stepsProgressed!!.value!! == ontheDateStepsObj.value.GoalStep)
                goalAchievementText.value = "Goal Achieved";
            else if (stepsProgressed!!.value!! > ontheDateStepsObj.value.GoalStep)
                goalAchievementText.value = "Goal overachieved";
        }
    }

    //Utils
    fun getTodayDateAsString() : String {
        var time = Calendar.getInstance();
        val formatter = SimpleDateFormat("dd/MM/yyyy")
        return formatter.format(time.time);
    }

    fun getIntegersFromString(input: String): Int {
        val pattern = Regex("(?<=(\\d|-))(\\D+)(\\s)")
        val formatted = pattern.replace(input, "")
        if(formatted != "")
            return  formatted.toInt()
        else
        return 0
    }
}




