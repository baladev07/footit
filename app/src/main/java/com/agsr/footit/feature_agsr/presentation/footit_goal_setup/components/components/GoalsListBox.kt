package com.agsr.footit.feature_agsr.presentation.footit_goal_setup.components.components

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import me.saket.swipe.SwipeAction
import me.saket.swipe.SwipeableActionsBox
import com.agsr.footit.R
import com.agsr.footit.feature_agsr.domain.model.Goal

@Composable
public fun GoalsSwipeBox(goalsList : SnapshotStateList<Goal>) {
    // A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Black
    ) {
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            GoalTitleWithSwipeActions(goalsList)
        }
    }
}

@Composable()
public fun GoalTitleWithSwipeActions(goalsList : SnapshotStateList<Goal>) {
    // Fetching local context
    val mLocalContext = LocalContext.current

    // Creating a Swipe Action for Left Swipe;
    // setting icon, background and what
    // happens when swiped
    val mSetActive = SwipeAction(
        icon = painterResource(R.drawable.ic_set_active),
        background = Color.Green,
        isUndo = true,
        onSwipe = { Toast.makeText(mLocalContext, "Set Active",Toast.LENGTH_LONG).show()}
    )

    // Creating a Swipe Action for Right Swipe;
    // setting icon, background and what happens when swiped
    val mDelete = SwipeAction(
        icon = painterResource(R.drawable.ic_delete_outlined    ),
        background = Color.Red,
        isUndo = true,
        onSwipe = { Toast.makeText(mLocalContext, "Delete",Toast.LENGTH_LONG).show()}
    )

    if(goalsList.isNotEmpty()) {
        // Creating a Swipe Action Box with start
        // action as calling and end action as sending message
        for(goal in goalsList) {
            SwipeableActionsBox(startActions = listOf(mSetActive), endActions = listOf(mDelete)) {

//                if(goal.IsGoalActive)
//                    listOfGoals(goalsList)
//                else
//                    listOfGoals(goalsList)

            }
        }
    }
}

@Composable
fun ActiveGoalSwipeBox(goal : Goal) {
    // Creating a Button inside Swipe Action Box
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Magenta),
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = goal.GoalName, fontSize = 20.sp, color = Color.White)
    }
}

@Composable
fun NonActiveGoalSwipeBox(goal : Goal) {
    // Creating a Button inside Swipe Action Box
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray),
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = goal.GoalName, fontSize = 20.sp, color = Color.White)
    }

}