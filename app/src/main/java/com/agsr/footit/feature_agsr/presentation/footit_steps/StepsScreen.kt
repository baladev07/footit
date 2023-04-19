package com.agsr.footit.feature_agsr.presentation.footit_steps


import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import com.agsr.footit.feature_agsr.domain.model.Goal
import com.agsr.footit.feature_agsr.domain.model.Steps
import com.agsr.footit.feature_agsr.domain.repository.GoalSettingRepos
import com.agsr.footit.feature_agsr.presentation.ViewModels.AppPreferenceVM
import com.agsr.footit.feature_agsr.presentation.ViewModels.StepsVM
import com.agsr.footit.feature_agsr.presentation.footit_layout.component.bottoomNav.BottomBarScreen
import com.agsr.footit.feature_agsr.presentation.footit_steps.components.setStepsProgressBar
import java.text.SimpleDateFormat
import java.util.*

var stepsList = listOf(Steps());


@Composable
public fun StepsScreen(goalsSettingRepos: GoalSettingRepos,navController: NavController, appPreferenceVM: AppPreferenceVM) {
    var stepsVM =  StepsVM(goalsSettingRepos);
    stepsVM.goalProgressPercenteage = remember { mutableStateOf(0f) }
    stepsVM.goalDropDownExpanded = remember { mutableStateOf(false) };
    stepsVM.isAddEditStepDialog = remember { mutableStateOf(false) };
    stepsVM.showActivityDatePicker = remember { mutableStateOf(false)};
    stepsVM.goalAchievementText = remember { mutableStateOf("") }

    //new varaible declarations
    stepsVM.onTheDayGoalId = remember { mutableStateOf(0) }
    stepsVM.onTheDayGoalName = remember { mutableStateOf("") }
    stepsVM.onTheDayGoalStepCount = remember { mutableStateOf(0) }
    stepsVM.ontheGoDate = remember { mutableStateOf(stepsVM.getTodayDateAsString()) }
    stepsVM.ontheDateStepsObj = remember { mutableStateOf(Steps()) };
    stepsVM.activeGoalObj = remember { mutableStateOf(Goal()) }
    stepsVM.stepsToAdd = remember { mutableStateOf(null)}
    stepsVM.stepsToCompleteGoal = remember {mutableStateOf(0) };
    stepsVM.initData();

    if(stepsVM.ontheDateStepsObj.value != null && stepsVM.ontheDateStepsObj.value.StepCount > 0)
    {
        stepsVM.stepsProgressed = remember { mutableStateOf(stepsVM.ontheDateStepsObj.value.StepCount) };
    }
    else {
        stepsVM.stepsProgressed = remember { mutableStateOf(0) };
    }
    stepsVM.setProgressPercentage();
    stepsVM.findStepsToAchieveTheGoal();
    stepsList = stepsVM.allDaysSteps.observeAsState(initial = listOf()).value


    stepScreenElements(stepsVM,navController, appPreferenceVM)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun stepScreenElements(stepsVM : StepsVM,navController: NavController, appPreferenceVM : AppPreferenceVM) {
    val canEditHistory : Boolean by appPreferenceVM.canEditHistory.collectAsState()
    val mLocalContext = LocalContext.current
    Surface(
            modifier = Modifier.fillMaxSize(),
    ) {
            Card(
                modifier = Modifier.size(width = 180.dp, height = 180.dp),
            ) {
                Box(Modifier.fillMaxSize()) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
//                            if(canEditHistory)
                            androidx.compose.material3.IconButton(
                                onClick = {
                                    if(canEditHistory)
                                    {
                                        stepsVM.showActivityDatePicker.value = true
                                    }
                                    else
                                    {
                                        Toast.makeText(mLocalContext, "Enable history edit settings to choose and edit history.", Toast.LENGTH_SHORT).show()
                                    }
                                          },
                                modifier = Modifier,
                                enabled = true,
                                colors = IconButtonDefaults.filledIconButtonColors(),
                                content = {  androidx.compose.material.Icon(imageVector = Icons.Filled.DateRange, contentDescription = "" )}
                            )

                            Text(
                                modifier =
                                if(canEditHistory)
                                    Modifier.padding(32.dp, 12.dp)
                                else Modifier.padding(120.dp, 12.dp,0.dp, 0.dp),
                                text = stepsVM.ontheGoDate.value.toString(),
                                fontSize = 22.sp,
                                textAlign = TextAlign.Center
                            )

                            androidx.compose.material3.IconButton(
                                onClick = { navController.navigate(BottomBarScreen.Settings.route)},
                                modifier = Modifier,
                                enabled = true,
                                colors = IconButtonDefaults.filledIconButtonColors(),
                                content = {  androidx.compose.material.Icon(imageVector = Icons.Filled.Settings, contentDescription = "" )}
                            )
                        }
                        Row() {
                            setStepsProgressBar(stepsVM)
                            //barActivity()
                        }
                        Row() {
                            if(stepsVM.goalProgressPercenteage != null &&
                                stepsVM.goalProgressPercenteage.value > 0 &&
                                stepsVM.goalProgressPercenteage.value <= 100f ) {
                                Button(onClick = { /*TODO*/ }) {
                                    Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                                    Text(stepsVM.goalProgressPercenteage.value.toInt().toString() + " %  goal progressed")
                                }
                            }
                        }

                        Row(modifier = Modifier.padding(5.dp)) {
                            TextField(
                                modifier = Modifier
                                    .padding(70.dp, 20.dp)
                                    .fillMaxWidth(),
                                value = if(stepsVM.stepsToAdd!!.value != null)  stepsVM.stepsToAdd!!.value.toString() else  "",
                                onValueChange = {
                                    stepsVM.onStepsEntry(it)
                                },
                                label = {Text("Enter steps")},
                                keyboardOptions =  KeyboardOptions(keyboardType = KeyboardType.Number),
                                trailingIcon = {
                                    IconButton(
                                    onClick = {
                                        stepsVM.addStepToProgress();

                                    }
                                ) {
                                    Icon(imageVector = ImageVector.vectorResource(id = com.agsr.footit.R.drawable.ic_send), "")
                                    }
                                }
                            )
                        }
                        Row( modifier = Modifier
                            .fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                            ) {
                            OutlinedTextField(
                                value = stepsVM.onTheDayGoalName.value,
                                modifier = Modifier
                                    .padding(70.dp, 10.dp)
                                    .fillMaxWidth(),
                                onValueChange = {},
                                readOnly = true,
                                label = { androidx.compose.material3.Text("Choose Goal") },
                                trailingIcon = { IconButton(onClick = { stepsVM.goalDropDownExpanded.value = true  }) {
                                    Icon(Icons.Default.MoreVert, contentDescription = "")
                                }},
                            )
                            dropDownChooser(stepsVM)
                        }

                        if(stepsVM.stepsProgressed != null && stepsVM.stepsProgressed!!.value != null
                            && stepsVM.stepsProgressed.value!! > 0) {
                            Button(onClick = { stepsVM.resetStepsActivityOntheGoDate() }) {
                                Text("Reset Steps")
                            }
                        }

                        //AddEditStepsDialog()
                        if(stepsList != null && stepsList.count() > 0 )
                        {
                            //Text(stepsList.count().toString())
                        }
                        else {
                            //Text("0")
                        }

                        Row() {
                            if(stepsVM.onTheDayGoalId.value > 0 && stepsVM.stepsProgressed != null && stepsVM.stepsProgressed!!.value!! != null && stepsVM.stepsProgressed!!.value!! > 0) {
                                ElevatedFilterChip(
                                    selected = true,
                                    onClick = { /* Do something! */ },
                                    label = { Text(stepsVM.goalAchievementText.value) },
                                    leadingIcon = {
                                        if (stepsVM.stepsProgressed != null && stepsVM.stepsProgressed!!.value!! != null && stepsVM.stepsProgressed!!.value!! > 0) {
                                            if (stepsVM.stepsProgressed!!.value!! > stepsVM.ontheDateStepsObj.value.GoalStep) {
                                                Icon(
                                                    painterResource(id = com.agsr.footit.R.drawable.badge_1361),
                                                    contentDescription = "Localized description",
                                                    Modifier.size(AssistChipDefaults.IconSize)
                                                )
                                            } else if (stepsVM.stepsProgressed!!.value!! == stepsVM.ontheDateStepsObj.value.GoalStep && stepsVM.stepsProgressed!!.value!! > 0) {
                                                Icon(
                                                    painterResource(id = com.agsr.footit.R.drawable.badge_1361),
                                                    contentDescription = "Localized description",
                                                    Modifier.size(AssistChipDefaults.IconSize)
                                                )
                                            }
                                        }
                                    },
                                    shape = FilterChipDefaults.shape,
                                    colors = FilterChipDefaults.elevatedFilterChipColors(),
                                    elevation = FilterChipDefaults.elevatedFilterChipElevation(),
                                )
                            }
                        }
                    }
                }
            }



            activityDatePicker(stepsVM);
        }
}

fun showAddStepsDialog(stepsVM : StepsVM) {
    stepsVM.isAddEditStepDialog.value = true;
}

@ExperimentalMaterial3Api
@Composable
fun AddEditStepsDialog(stepsVM : StepsVM) {
    if(stepsVM.isAddEditStepDialog.value) {
        androidx.compose.material3.AlertDialog(
            onDismissRequest = { stepsVM.isAddEditStepDialog.value = false },
            modifier = Modifier
                .height(315.dp)
                .width(370.dp),
            properties = DialogProperties(true, true),
            confirmButton =  { TextButton(onClick = { stepsVM.isAddEditStepDialog.value = false ; stepsVM.setProgressPercentage()  }, content= { androidx.compose.material3.Text("Ok") }) },
            text = { AddEditStepContents(stepsVM) }
        )
    }
}

@ExperimentalMaterial3Api
@Composable
fun AddEditStepContents(stepsVM : StepsVM) {
    Column() {
        Row() {
            OutlinedTextField(
                modifier = Modifier
                    .padding(20.dp, 10.dp, 30.dp, 10.dp)
                    .fillMaxWidth(),
                value = stepsVM.stepsProgressed.value.toString(),
                onValueChange = {
                    if (it.isNotEmpty())
                        stepsVM.stepsProgressed.value = it.toInt()
                    else stepsVM.stepsProgressed.value = 0
                },
                label = {Text("Enter steps")},
                keyboardOptions =  KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }
    }
}

@Composable
fun dropDownChooser(stepsVM : StepsVM) {
    if(stepsVM.goalDropDownExpanded.value)
    {
        DropdownMenu(expanded = stepsVM.goalDropDownExpanded.value,
            onDismissRequest = { stepsVM.goalDropDownExpanded.value = false },
            content = {dropDownGoalsList(stepsVM)})
    }
}

@Composable
fun dropDownGoalsList(stepsVM : StepsVM) {
    if(stepsVM.allGoalsList !=  null && stepsVM.allGoalsList!!.value != null) {
        var index = 0;
        stepsVM.allGoalsList.value!!.forEach { goalData: Goal ->

            if(index == 0)
            {
                DropdownMenuItem(
                    text = {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text("-- Select One --")
                        }
                           },
                    onClick = {
                        stepsVM.onGoalChange(0);
                    },
                )
                Divider()
            }

            DropdownMenuItem(
                text = { Text(goalData.GoalName)
                    Row(
                        modifier = Modifier.fillMaxWidth().width(150.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(goalData.GoalName)
                        Text(goalData.StepCount)
                    }
                       },
                onClick = {
                          stepsVM.onGoalChange(goalData.GoalId);
                },
            )
            Divider()
            index++;
            //if(index!= stepsVM.allGoalsList!!.value!!.count() -1)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun activityDatePicker(stepsVM: StepsVM) {
    if (stepsVM.showActivityDatePicker.value == true) {
        val datePickerState = rememberDatePickerState(initialDisplayMode = DisplayMode.Picker)
        val confirmEnabled = remember { derivedStateOf {
            datePickerState.selectedDateMillis != null &&
                    Date(datePickerState.selectedDateMillis!!) < Date() } }
        DatePickerDialog(
            onDismissRequest = {
                stepsVM.showActivityDatePicker.value = false
            },
            confirmButton = {
                TextButton(
                    onClick = {
                       stepsVM.onDateChange(datePickerState)
                    },
                    enabled = confirmEnabled.value
                ) {
                    Text(text = "Ok")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        stepsVM.showActivityDatePicker.value = false
                    }
                ) {
                    Text(text = "Cancel")
                }
            }
        ) {
            DatePicker(state = datePickerState)
        }
    }
}





