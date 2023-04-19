package com.agsr.footit.feature_agsr.presentation.ViewModels

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.agsr.footit.feature_agsr.domain.model.Goal
import com.agsr.footit.feature_agsr.domain.repository.GoalSettingRepos
import com.agsr.footit.feature_agsr.presentation.footit_goal_setup.components.components.*
import com.agsr.footit.feature_agsr.presentation.footit_layout.component.bottoomNav.BottomBarScreen
import java.util.regex.PatternSyntaxException
import javax.inject.Inject

class GoalsVM
@Inject constructor(private val goalSettingRepos : GoalSettingRepos) : ViewModel(){
    var goalStateObject = mutableStateOf(Goal())
    var addOrEditGalDialoge = mutableStateOf(false)
    var activeGoalObject = mutableStateOf(Goal());
    var goalsList: LiveData<List<Goal>> = goalSettingRepos.allGoals;
    var goalId = mutableStateOf(0)
    var goalName =  mutableStateOf("");
    var goalStepCount = mutableStateOf("");
    var goalIsActive = mutableStateOf(true);
    var isAdded = mutableStateOf(false);
    var isUpdated = mutableStateOf(false);
    var goalStepErrorMessage = mutableStateOf("");
    var goalNameErrorMessage = mutableStateOf("");
    var deletedGoal: Goal? = null;

    //regex
    var goalNamePatter = Regex("^[a-zA-Z0-9 ]*$")
    var goalStepPattern = Regex("^[a-zA-Z0-9 ]*$")
    var isErrorGoalStep = mutableStateOf(false);

    val snackbarHostState = SnackbarHostState()

    init {
        goalSettingRepos?.getGoals();
    }

    //Goals private functions
    fun init()
    {
         goalSettingRepos?.getGoals();
         getActiveGoalSelected();
    }

    fun getSnackBarState():SnackbarHostState
    {
        return snackbarHostState
    }

    fun getActiveGoalSelected(){
        if(goalsList!!.value != null && goalsList!!.value!!.isNotEmpty()) {
            var activeGoalData = goalsList.value!!.filter { goal -> goal.IsGoalActive }
            if(activeGoalData.isNotEmpty())
            {
                activeGoalObject.value = activeGoalData[0];
            }
        }
    }

    fun setOnlyOneGoalAsActive(goalId :Int) {
        if(goalsList.value != null)
        {
           var goalToBeUpdated = goalsList.value!!.find { it.GoalId != goalId && it.IsGoalActive == true};
            if(goalToBeUpdated != null )
            {
                goalToBeUpdated.IsGoalActive = false;
                goalSettingRepos?.updateGoal(goalToBeUpdated)
            }

            goalToBeUpdated = goalsList.value!!.find { it.GoalId == goalId};
            if(goalToBeUpdated != null )
            {
                goalToBeUpdated.IsGoalActive = true;
                goalSettingRepos?.updateGoal(goalToBeUpdated);
                activeGoalObject.value = goalToBeUpdated;
            }
        }
    }

    fun onConfirmGoalDialog() {
            setGoalValuesFromDialog()
            if (goalStateObject.value.IsGoalActive) {
                setOnlyOneGoalAsActive(goalStateObject.value.GoalId)
            }
            if (goalStateObject.value != null && goalStateObject.value.GoalId > 0 && goalStateObject.value.GoalId != 1) {
                updateGoal();
                isUpdated.value = true;
            } else {
                if (goalStateObject.value != null &&
                    goalStateObject.value.GoalName != null &&
                    goalStateObject.value.StepCount.isNotEmpty()
                ) {
                    insertGoalData();
                    isAdded.value = true;
                }
            }
            addOrEditGalDialoge.value = false;
            goalStateObject = mutableStateOf(Goal());
            goalStateObject.value.GoalId = 0;
            resetGoalData();
            goalStateObject.value = Goal();
    }


    fun insertGoalData() {
        goalSettingRepos?.insertGoal(goalStateObject.value)
    }

    fun insertGoalData(goal: Goal) {
        goalSettingRepos.insertGoal(goal)

    }

    fun updateGoal() {
        goalSettingRepos?.updateGoal(goalStateObject.value)
    }

    fun removeGoal(goalId :Int,toDelete:Boolean) {
        if(goalsList.value != null){
            var goalToDelete = goalsList.value!!.filter{ it.GoalId == goalId };
            if(goalToDelete != null && goalToDelete.isNotEmpty())
            {
                goalToDelete[0].IsDeleted = toDelete;
                goalSettingRepos?.updateGoal(goalToDelete[0])
            }
        }
    }

    fun deleteGoal(goal: Goal)
    {
        goalSettingRepos.deleteGoal(goal)
    }

//    fun undoRemoveGoal(goalId :Int) {
//        if(goalsList.value != null){
//            var goalToDelete = goalsList.value!!.filter{ it.GoalId == goalId };
//            if(goalToDelete != null && goalToDelete.isNotEmpty())
//            {
//                goalToDelete[0].IsDeleted = false;
//                goalSettingRepos?.updateGoal(goalToDelete[0])
//            }
//        }
//    }

    fun setCurrentDeleteDGoal(goal:Goal)
    {
        deletedGoal = goal
    }

    fun editAGoal(goal : Goal) {
        goalId.value = goal.GoalId;
        goalName.value = goal.GoalName;
        goalStepCount.value = goal.StepCount;
        goalIsActive.value = goal.IsGoalActive;
        addOrEditGalDialoge.value = true;
    }

    fun resetGoalData() {
        goalId.value = 0;
        goalName.value = "";
        goalStepCount.value = "";
        goalIsActive.value = false;
    }

    fun setGoalValuesFromDialog() {
        goalStateObject.value.GoalId =  goalId.value
        goalStateObject.value.GoalName =  goalName.value;
        goalStateObject.value.IsGoalActive =  goalIsActive.value;
        goalStateObject.value.StepCount =  goalStepCount.value;
    }

    fun onDismisDialog() {
        resetGoalData();
        goalStateObject.value.GoalId =  0;
        goalStateObject.value.GoalName =  "";
        goalStateObject.value.IsGoalActive =  false;
        goalStateObject.value.StepCount = "";
        addOrEditGalDialoge.value = false;
    }

    fun validateGoalName () {
        //goal Name required
        if(goalName.value == "" || goalName.value == null || goalName.value.trim() == "")
        {
            //isErrorGoalNameRequired.value = true;
            goalNameErrorMessage.value = "Goal Name Required";
        }
        //goal Name Invalid
        else if(!goalName.value.matches(Regex("^[a-zA-Z0-9 ]*\$")) || goalName.value.length > 50)
        {
            //isErrorGoalNameInavlid.value = true;
            goalNameErrorMessage.value = "Goal Name Invalid";
        }
        else if(isDuplicateNameFound() && goalId.value == 0)
        {
            //isErrorGoalNameDuplicate.value = true;
            goalNameErrorMessage.value = "Goal name already exist"
        }
        else
        {
            goalNameErrorMessage.value = ""
        }
    }

    fun validateGoalStep() {
        //goal step required
        if(goalStepCount.value == "" || goalStepCount.value == null || goalStepCount.value.trim() == "")
        {
            goalStepErrorMessage.value = "Step Required";
        }
        //goal step Invalid
        else if(!goalStepCount.value.matches(Regex("\\d+")) || goalStepCount.value.length > 6)
        {
            goalStepErrorMessage.value = "Step Invalid";
        }
        else
        {
            goalStepErrorMessage.value = ""
        }
    }

    fun isDuplicateNameFound() : Boolean {
        if(goalsList!!.value != null && goalsList!!.value!!.isNotEmpty()) {
            var duplicateItem = goalsList!!.value!!.filter { goalObj -> goalObj.GoalName == goalName.value.trim() }
            if(duplicateItem != null && duplicateItem.isNotEmpty())
            {
                return true
            }
        }
        // no dups
        return false
    }

}