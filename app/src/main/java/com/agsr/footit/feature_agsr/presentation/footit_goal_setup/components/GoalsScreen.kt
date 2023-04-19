package com.agsr.footit.feature_agsr.presentation.footit_goal_setup.components

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import  androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.agsr.footit.feature_agsr.domain.model.Goal

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.GolfCourse
import androidx.compose.material3.*
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.window.DialogProperties
import com.agsr.footit.R
import com.agsr.footit.feature_agsr.domain.repository.GoalSettingRepos
import com.agsr.footit.feature_agsr.presentation.ViewModels.GoalsVM
import com.agsr.footit.feature_agsr.presentation.footit_goal_setup.components.components.*
import me.saket.swipe.SwipeAction
import me.saket.swipe.SwipeableActionsBox
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.agsr.footit.feature_agsr.presentation.ViewModels.AppPreferenceVM
import kotlinx.coroutines.launch


//@Preview
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GoalsScreen(goalSettingRepos: GoalSettingRepos, appPreferenceVM: AppPreferenceVM) {
    var goalsVM = GoalsVM(goalSettingRepos);
    goalsVM.goalStateObject = remember { mutableStateOf(Goal()) }
    goalsVM.addOrEditGalDialoge = remember { mutableStateOf(false) };
    goalsVM.goalName = remember { mutableStateOf("") };
    goalsVM.goalStepCount = remember { mutableStateOf("") };
    goalsVM.goalIsActive = remember { mutableStateOf(false) }
    goalsVM.goalId = remember { mutableStateOf(0) };
    goalsVM.isAdded = remember { mutableStateOf(false) };
    goalsVM.isUpdated = remember { mutableStateOf(false) };
    goalsVM.goalNameErrorMessage = remember { mutableStateOf("") };
    goalsVM.goalStepErrorMessage = remember { mutableStateOf("") };

    val mLocalContext = LocalContext.current
    Scaffold(snackbarHost =
    {
        SnackbarHost(
            hostState = goalsVM.getSnackBarState(),
            snackbar = {
                Snackbar(
                    action = {
                        TextButton(onClick = {
                            if (goalsVM.deletedGoal != null) {
                                goalsVM.deletedGoal!!.GoalId = 0
                                goalsVM.insertGoalData(goalsVM.deletedGoal!!)
                                goalsVM.getSnackBarState().currentSnackbarData?.dismiss()
                            }
                        }) {
                            Text("undo", color = Color.White)
                        }
                    }
                ) {
                    Text(text = "undo delete", color = Color.White)
                }
            },
        )
    }
    ) {
        goalsVM.init();
        goalsVM.getActiveGoalSelected();
        Column(
            modifier = Modifier.padding(it)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp), horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Active Goal",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp
                    )
                )
            }
            Row(
                modifier = Modifier
                    .padding(10.dp)
            ) {

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .padding(16.dp, 0.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(
                                brush = Brush.linearGradient(
                                    colors = listOf(
                                        Color(android.graphics.Color.parseColor("#764EBC")),
                                        Color(android.graphics.Color.parseColor("#D54BCD"))
                                    )
                                )
                            )
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.Start
                        ) {
                            Icon(
                                imageVector = ImageVector.vectorResource(id = com.agsr.footit.R.drawable.ic_active_ripple),
                                contentDescription = "",
                                modifier = Modifier.padding(15.dp, 0.dp, 0.dp, 0.dp)
                            )
                        }
                        Column(
                            modifier = Modifier.fillMaxSize(),
                        ) {
                            Text(
                                modifier = Modifier
                                    .padding(10.dp, 18.dp, 10.dp, 0.dp)
                                    .fillMaxWidth(),
                                text = goalsVM.activeGoalObject.value.GoalName,
                                style = MaterialTheme.typography.headlineLarge,
                                textAlign = TextAlign.End,
                                color = Color(android.graphics.Color.parseColor("#F2F2F2"))
                            )

                            Text(
                                modifier = Modifier
                                    .padding(10.dp, 0.dp, 10.dp, 0.dp)
                                    .fillMaxWidth(),
                                text = goalsVM.activeGoalObject.value.StepCount,
                                style = MaterialTheme.typography.headlineMedium,
                                textAlign = TextAlign.End,
                                color = Color(android.graphics.Color.parseColor("#F2F2F2"))

                            )
                        }
                    }
                }
            }
            Divider()



            Row(
                modifier = Modifier
                    .padding(20.dp, 10.dp)
                    .height(265.dp)
                    .clip(RoundedCornerShape(25.dp))
            ) {
                listOfGoals(goalsVM, appPreferenceVM)
            }

            Row() {
                Box(
                    //contentAlignment = androidx.compose.ui.Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Column() {
                        val canEditGoal: Boolean by appPreferenceVM.canEditGoal.collectAsState()
                        Row(
                            modifier = Modifier
                                .padding(20.dp, 10.dp, 30.dp, 15.dp)
                                .fillMaxWidth()
                        ) {
                            Text(
                                text = buildAnnotatedString {
                                    withStyle(
                                        style = SpanStyle(
                                            fontSize = 22.sp,
                                            fontStyle = FontStyle.Italic
                                        )
                                    ) {
                                        append("• ")
                                    }
                                    append("Swipe right to set a goal active\n")
                                    withStyle(style = SpanStyle(fontSize = 22.sp)) {
                                        append("• ")
                                    }
                                    append("Swipe left to delete a goal\n")
//                                    if (canEditGoal) {
                                        withStyle(style = SpanStyle(fontSize = 22.sp)) {
                                            append("• ")
                                        }
                                        append("Hold to edit a goal\n")
//                                    }
                                }
                            )
                        }
                    }
                    Column(
                        modifier = Modifier
                            .wrapContentSize()
                            .align(Alignment.BottomEnd)
                    ) {
                        Row(
                            modifier = Modifier
                                .wrapContentSize()
                                .padding(20.dp, 20.dp, 20.dp, 20.dp)
                        )
                        {
                            addGoalFloatingButton(goalsVM)
                        }
                    }
                }
            }
            if (goalsVM.addOrEditGalDialoge.value == true) {
                showHideAddorEditGoal(goalsVM)
            }
        }

    }
    ShowToasters(goalsVM)
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun listOfGoals(goalsVM: GoalsVM, appPreferenceVM: AppPreferenceVM) {
    val goalsList: List<Goal> by goalsVM.goalsList.observeAsState(initial = listOf())
    if (goalsList != null && goalsList!!.isNotEmpty() && goalsList!!.count() > 0) {
        showGoalsWithSwipeList(goalsVM, goalsList, appPreferenceVM)
    } else {
        Column(modifier = Modifier.fillMaxSize()) {
            Row(modifier = Modifier.fillMaxWidth())
            {
                Text(
                    "No Goals to Show",
                    style = TextStyle(fontWeight = FontWeight.Bold)
                )
            }
            Spacer(modifier = Modifier)
            Row(modifier = Modifier.fillMaxWidth()) { Text("Please add goals by pressing plus button") }
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
@ExperimentalMaterial3Api
fun showGoalsWithSwipeList(
    goalsVM: GoalsVM,
    goalsList: List<Goal>,
    appPreferenceVM: AppPreferenceVM
) {
    var showDialog = remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope();
    val canEditGoal: Boolean by appPreferenceVM.canEditGoal.collectAsState()
    if (goalsList.isNotEmpty()) {
        val Purple700 = Color(0xFF3700B3)
        val Purple200 = Color(0xFFBB86FC)
        val Purple500 = Color(0xFF6200EE)
        LazyColumn(
            modifier = Modifier
                .wrapContentSize()
                .background(Purple200)
                .clip(RoundedCornerShape(25.dp)),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 6.dp),
        ) {
            items(goalsVM.goalsList!!.value!!) { goal ->
                //Row(modifier = Modifier.wrapContentSize().background(Purple200)) {
                //Box (modifier = Modifier.wrapContentSize().background(Purple200)){
                // Fetching local context
                val mLocalContext = LocalContext.current
                // Creating a Swipe Action for Left Swipe;

                val mSetActive = SwipeAction(
                    icon = painterResource(R.drawable.ic_set_active),
                    background = Color.Green,
                    isUndo = true,
                    onSwipe = {
                        goalsVM.setOnlyOneGoalAsActive(goal.GoalId);
                        Toast.makeText(mLocalContext, "Goal set active", Toast.LENGTH_SHORT).show()
                    }
                )

                // Creating a Swipe Action for Right Swipe;
                val mDelete = SwipeAction(
                    icon = painterResource(R.drawable.ic_delete_outlined),
                    background = Color.Red,
                    isUndo = true,
                    onSwipe = {
                        if (goal.GoalId != goalsVM.activeGoalObject.value.GoalId && goal.GoalId != 1) {
                            showDialog.value = true
                        } else {
                            Toast.makeText(
                                mLocalContext,
                                "Active Goal can't be deleted",
                                Toast.LENGTH_SHORT
                            ).show();
                        }
                    }
                )
                if (!goal.IsDeleted && goal.GoalId > 0) {
                    SwipeableActionsBox(
                        startActions = listOf(mSetActive),
                        endActions = listOf(mDelete)
                    )
                    {

                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                //.clip(RoundedCornerShape(25.dp))
                                .background(Purple200)
                                .padding(8.dp)
                                .combinedClickable(
                                    // onLongClick = goalsVM.editAGoal(goal)
                                    onLongClickLabel = "Edit",
                                    onLongClick = {
                                        if (goal.GoalId != 1 && !goal.IsGoalActive && canEditGoal)
                                        {
                                            goalsVM.editAGoal(goal);
                                            goalsVM.setGoalValuesFromDialog(); } else {
                                            if (goal.GoalId == 1 && canEditGoal)
                                                Toast
                                                    .makeText(
                                                        mLocalContext,
                                                        "Can't edit default goal",
                                                        Toast.LENGTH_SHORT
                                                    )
                                                    .show()
                                            else if (canEditGoal)
                                                Toast
                                                    .makeText(
                                                        mLocalContext,
                                                        "Can't edit active goal",
                                                        Toast.LENGTH_SHORT
                                                    )
                                                    .show()
                                        }
                                       if(!canEditGoal)
                                       {
                                           Toast
                                               .makeText(
                                                   mLocalContext,
                                                   "Enable edit goal option in settings to edit the goal.",
                                                   Toast.LENGTH_SHORT
                                               )
                                               .show()
                                       }
                                    },
                                    onDoubleClick = {

                                    },
                                    onClick = {}
                                ),
                            elevation = CardDefaults.elevatedCardElevation())
                        {

                            ListItem(
                                headlineText = { Text(goal.GoalName) },
                                modifier = Modifier.background(Purple200),
                                supportingText = { Text(goal.StepCount + " steps") },
//                                                leadingContent = {
//                                                    if (goal.IsGoalActive)
//                                                        Icon(
//                                                            Icons.Filled.Done,
//                                                            contentDescription = goal.GoalName + "is set as Active",
//                                                        )
//                                                },
                            )
                        }

                    }
                }

                if (showDialog.value) {
                    alert(showDialog = showDialog, onConfirm =
                    {
                        showDialog.value = false
                        coroutineScope.launch {
                            goalsVM.setCurrentDeleteDGoal(goal)
                            goalsVM.deleteGoal(goal)
                            goalsVM.getSnackBarState().showSnackbar("")
                        }

                    }) {
                        showDialog.value = false
                    }
                }
                Divider()
            }
        }
    }
}

@Composable
fun showHideAddorEditGoal(goalsVM: GoalsVM) {
    Box() {
        val snackBarStateAddOrEdit = remember { SnackbarHostState() }

        AlertDialog(
            onDismissRequest = { goalsVM.addOrEditGalDialoge.value = false },
            modifier = Modifier
                .height(460.dp)
                .width(370.dp),
            icon = {
                androidx.compose.material3.Icon(
                    Icons.Filled.GolfCourse,
                    contentDescription = "Goals"
                )
            },
            title = { Text(if (goalsVM.goalStateObject.value.GoalId > 0) "Update Goal" else "Add Goal") },
            properties = DialogProperties(true, true),
            confirmButton = {
                TextButton(
                    onClick = {
                        goalsVM.onConfirmGoalDialog();
                    },
                    enabled = (goalsVM.goalStepErrorMessage.value == "" && goalsVM.goalNameErrorMessage.value == ""
                            && goalsVM.goalName.value != "" && goalsVM.goalStepCount.value != ""),
                    content = { Text("Ok") })
            },
            dismissButton = {
                TextButton(
                    onClick = { goalsVM.onDismisDialog() },
                    content = { Text("Cancel") })
            },
            text = { AddEditGoalPopup(goalsVM) }
        )
        SnackbarHost(
            modifier = Modifier.align(Alignment.BottomCenter),
            hostState = snackBarStateAddOrEdit
        ) {
            CustomSnackBar(
                title = "Changes saved"
            ) {}
        }
    }
}

@Composable
fun addGoalFloatingButton(goalsVM: GoalsVM) {
    FloatingActionButton(
        onClick = { goalsVM.addOrEditGalDialoge.value = true }
    ) { Icon(Icons.Filled.Add, "Localized description") }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEditGoalPopup(goalsVM: GoalsVM) {
    Column() {

        Row(modifier = Modifier.padding(10.dp)) {
            OutlinedTextField(
                value = goalsVM.goalName.value,
                onValueChange = { goalsVM.goalName.value = it; goalsVM.validateGoalName() },
                label = { Text("Goal Name") },
                isError = goalsVM.goalNameErrorMessage.value != "",
                supportingText = {
                    Text(text = goalsVM.goalNameErrorMessage.value)
                }
            )
        }
        Row(modifier = Modifier.padding(10.dp)) {
            OutlinedTextField(
                value = goalsVM.goalStepCount.value,
                onValueChange = { goalsVM.goalStepCount.value = it; goalsVM.validateGoalStep() },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                label = { Text("Steps") },
                isError = goalsVM.goalStepErrorMessage.value != "",
                supportingText = { Text(text = goalsVM.goalStepErrorMessage.value)
                }
            )
        }

        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Set Active")
            Switch(
                modifier = Modifier
                    .semantics { contentDescription = "Set active" }
                    .align(
                        Alignment.Bottom
                    ),
                checked = goalsVM.goalIsActive.value,
                onCheckedChange = { goalsVM.goalIsActive.value = it })
        }
    }
}

@Composable
fun CustomSnackBar(
    modifier: Modifier = Modifier,
    title: String,
    onAction: () -> Unit
) {
    androidx.compose.material.Snackbar(
        elevation = 0.dp,
        backgroundColor = Color.Transparent
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Column(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color(color = android.graphics.Color.parseColor("#6750A4")),
                                Color(color = android.graphics.Color.parseColor("#6750A4"))
                            )
                        )
                    )
                    .padding(start = 10.dp, top = 50.dp, bottom = 12.dp, end = 10.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = title,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 10.sp,
                )
            }

        }
    }

}


@Composable
fun ShowToasters(goalsVM: GoalsVM) {
    val mLocalContext = LocalContext.current
    if (goalsVM.isAdded.value == true) {
        Toast.makeText(mLocalContext, "Goal Added", Toast.LENGTH_SHORT).show();
        goalsVM.isAdded.value = false;
    }
    if (goalsVM.isUpdated.value == true) {
        Toast.makeText(mLocalContext, "Goal Updated", Toast.LENGTH_SHORT).show()
        goalsVM.isUpdated.value = false;
    }
}


@Composable
fun alert(
    showDialog: MutableState<Boolean>,
    onConfirm: () -> Unit,
    onDismiss: () -> Unit
) {
    if (showDialog.value) {
        AlertDialog(onDismissRequest = onDismiss, title = {
            Text(text = "Delete Goal")
        }, confirmButton = {
            TextButton(onClick = onConfirm) {
                Text(text = "delete")
            }
        }, dismissButton = {
            TextButton(onClick = onDismiss) {
                Text(text = "cancel")
            }
        }, text = {
            Text(text = "Are you sure you want to delete this goal?")
        })
    }
}
