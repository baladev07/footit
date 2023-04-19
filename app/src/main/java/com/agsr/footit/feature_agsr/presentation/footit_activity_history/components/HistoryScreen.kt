package com.agsr.footit.feature_agsr.presentation.footit_activity_history.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.GolfCourse
import androidx.compose.material.icons.outlined.CalendarMonth
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.agsr.footit.feature_agsr.domain.model.Steps
import com.agsr.footit.feature_agsr.domain.repository.GoalSettingRepos
import com.agsr.footit.feature_agsr.presentation.ViewModels.HistoryScreenVM
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun HistoryScreen(goalSettingRepos: GoalSettingRepos) {
    var historyVM = HistoryScreenVM(goalSettingRepos)
    //var allActivities =  historyVM.allStepsActivity.observeAsState(initial = listOf())

    var allActivities =  historyVM.allStepsActivity.value;
    historyVM.enableFilterApply = remember{ mutableStateOf(false) }
    historyVM.stepsList = remember { mutableStateListOf(Steps()) }
    historyVM.openFromDate = remember { mutableStateOf(false) }
    historyVM.init();
    if(allActivities != null && allActivities.isNotEmpty())
    {
        allActivities = allActivities.sortedByDescending { SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).parse(it.ActivityDate) }
    }
    historyVM.showFilterDialog = remember { mutableStateOf(false) }
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column () {
            Row (modifier = Modifier
                .wrapContentSize()
                .padding(10.dp, 10.dp, 10.dp, 10.dp)) {
                AllActivities(historyVM, allActivities)
            }
        }
    }
//    BottomSheetDrawer(historyVM)
}

@Composable
fun AllActivities(historyScreenVM: HistoryScreenVM, allActivities : List<Steps>?) {
    if(allActivities!= null
        && allActivities.isNotEmpty() && allActivities.size>1) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp)
        )
        {
            items(allActivities) { activity ->
                activityPerDayCard(activity, historyScreenVM)
            }
        }
    }
    else {
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement =Arrangement.Center)
        {
            Card(modifier = Modifier.fillMaxSize()) {
                Text("No historical activity",
                    color = Color.Black)
            }
        }
    }
}

@Composable
fun activityPerDayCard(step : Steps, historyScreenVM: HistoryScreenVM) {
      if (step.StepCount > 0 && step.ActivityDate != historyScreenVM.getTodayDateAsString()) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color((0xf8c1a3)))
                .padding(12.dp)
                .clickable { },
            elevation = CardDefaults.elevatedCardElevation(),
        ) {
            Column(
                modifier = Modifier.padding(15.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        color = Color.Black,
                        text = historyScreenVM.getDayNameByDate(step.ActivityDate),
                        fontSize = 20.sp
                    )
                    Text(
                        color = Color.Black,
                        //text = step.ActivityDate.dropLast(5)
                        text = step.ActivityDate
                    )
                }
                Row()
                {
                    Text(
                        color = Color.Black,
                        text = step.StepCount.toString(),
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Medium,
                    )
                    Text(
                        modifier = Modifier.padding(top = 14.dp),
                        color = Color.Black,
                        text = "/" + step.GoalStep + " steps",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Medium,
                    )
                }

                CustomProgressBar(step)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        color = Color.Black,
                        text = getCompletionText(step),
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Medium
                    )
                        Text(
                            color = Color.Black,
                            text = step.GoalName,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Medium
                        )
                }
            }
        }
    }
}

@Composable
fun filterOptionsFloatButton(historyScreenVM: HistoryScreenVM) {
    FloatingActionButton(
        onClick = { historyScreenVM.showFilterDialog.value = true }
    ) { androidx.compose.material.Icon(ImageVector.vectorResource(id = com.agsr.footit.R.drawable.ic_filter_alt), "Localized description") }
}

fun getCompletionText(step : Steps) : String {
    var percentageOfCompletion = ((step.StepCount.toDouble() / step.GoalStep.toDouble()) * 100).toInt();
    if(percentageOfCompletion <= 100)
    {
        return Math.abs(percentageOfCompletion).toString()  + "% of goal Progress"
    }
    else {
        return "Goal overachieved"
    }
}

