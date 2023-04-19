package com.agsr.footit.feature_agsr.presentation.ViewModels

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.agsr.footit.feature_agsr.domain.model.Steps
import com.agsr.footit.feature_agsr.domain.repository.GoalSettingRepos
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import javax.inject.Inject

class HistoryScreenVM
@Inject constructor(private val goalSettingRepos : GoalSettingRepos) {
    var sdf = SimpleDateFormat("dd/MM/yyyy");
    var allStepsActivity : LiveData<List<Steps>> = goalSettingRepos.allSteps
    var showFilterDialog = mutableStateOf(false);
    var fromDateFilter = mutableStateOf(Date());
    var toDateFilter = mutableStateOf(Date());
    var stepsList = mutableStateListOf(Steps());
    var openFromDate = mutableStateOf(false)
    var openToDate = mutableStateOf(false)
    var enableFilterApply = mutableStateOf(false);
    var isFilterApplied = mutableStateOf(false);
    var today = mutableStateOf(setTodayDate());

    fun init()  {
        goalSettingRepos?.getSteps();
//        if(allStepsActivity != null && allStepsActivity.value != null &&
//                allStepsActivity.value.isNotEmpty())
//        {
            //allStepsActivity.value = allStepsActivity.value!!.sortedByDescending { steps -> steps.ActivityDate };
//        }
    }

    fun setTodayDate() : String {
        var time = Calendar.getInstance();
        val formatter = SimpleDateFormat("dd/MM/yyyy")
        return formatter.format(time.time);
    }

    fun getDayNameByDate(dateString : String)  : String {
        var dateObject= sdf.parse(dateString);
        return SimpleDateFormat("EEEE", Locale.ENGLISH).format(dateObject.getTime()).toString()
    }

    fun filterActivities() : SnapshotStateList<Steps> {
        val sdf = SimpleDateFormat("dd/MM/yyyy");
        if (fromDateFilter.value  != Date() && stepsList.isNotEmpty()) {
            isFilterApplied.value = true;
            stepsList = stepsList.filter { x ->
                x.ActivityDate != "" &&
                        sdf.parse(x.ActivityDate) >= fromDateFilter.value
            }.toMutableStateList();
        }

        if(toDateFilter.value != Date() &&  stepsList.isNotEmpty()) {
            isFilterApplied.value = true;
            stepsList = stepsList.filter { x ->
                x.ActivityDate != "" &&
                        sdf.parse(x.ActivityDate) <= toDateFilter.value
            }.toMutableStateList();
        }
        showFilterDialog.value = false;
        refreshHistoryList();

        return stepsList;
    }

    fun getDateFormatFromTimeStamp(timeStatmp : Long ) : Date {
        var toDate = Date(timeStatmp);
        return toDate;
    }

    fun refreshHistoryList() {
        if(stepsList.count() > 1)
        {
            var stepRemoved = stepsList.removeAt (stepsList.count() -1)
            stepsList.add(stepRemoved)
        }
    }

    fun formatDate(dateString : String)  : String {
            //Tue Feb 21 11:28:21 GMT 2023
        var patternObserved = "EEE MMM dd HH:mm:ss z yyyy"
        //var dateType = LocalDateTime.parse(dateString, DateTimeFormatter.ofPattern(patternObserved))
        var sdf = SimpleDateFormat("dd/MM/YYYY")
        return sdf.format("");
    }

    fun getTodayDateAsString() : String {
        var time = Calendar.getInstance();
        val formatter = SimpleDateFormat("dd/MM/yyyy")
        return formatter.format(time.time);
    }
}