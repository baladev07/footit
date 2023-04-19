package com.agsr.footit.feature_agsr.presentation.footit_activity_history.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.agsr.footit.feature_agsr.domain.model.Steps
import com.agsr.footit.feature_agsr.presentation.footit_steps.components.pregressPercentage
import kotlin.math.roundToInt

val Purple700 = Color(0xFF3700B3)
val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Teal200 = Color(0xFF03DAC5)

@Composable
fun CustomProgressBar(step : Steps) {
    val context = LocalContext.current
    var progressCount: Int = setprogress(step.StepCount, step.GoalStep?: 0);
    var progress by remember { mutableStateOf(0f) }

    when (progressCount) {
        0 -> progress = 0.0f
        1 -> progress = 0.1f
        2 -> progress = 0.2f
        3 -> progress = 0.3f
        4 -> progress = 0.4f
        5 -> progress = 0.5f
        6 -> progress = 0.6f
        7 -> progress = 0.7f
        8 -> progress = 0.8f
        9 -> progress = 0.9f
        10 -> progress = 1.0f
    }

    val size by animateFloatAsState(
        targetValue = progress,
        tween(
            durationMillis = 1000,
            delayMillis = 200,
            easing = LinearOutSlowInEasing
        )
    )

    // This is to start the animation when the activity is opened
    LaunchedEffect(Unit) {
        size
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 0.dp, start = 30.dp, end = 30.dp)
    ) {
        // for the text above the progressBar
        Row(
            modifier = Modifier
                .widthIn(min = 30.dp)
                .fillMaxWidth(size),
            horizontalArrangement = Arrangement.End
        ) {
//            Text(
//                color = Color.Black,
//                text = ((Math.abs(step.StepCount.toDouble() / step.GoalStep.toDouble()) * 100).toInt()).toString()
//                        )
        }
        // Progress Bar
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(22.dp).padding(0.dp,5.dp,0.dp, 5.dp)
        ) {
            // for the background of the ProgressBar
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(9.dp))
                    .background(Purple200)
            )
            // for the progress of the ProgressBar
            Box(
                modifier = Modifier
                    .fillMaxWidth(size)
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(9.dp))
                    .background(Purple700)
                    .animateContentSize()
            )
        }

    }
}
fun setprogress(steps : Int, goal : Int) : Int {
    if (steps == null || goal == null)
        return 0;
    else if( steps > goal )
    {
        return 10;
    }
    else {
        return (goal.toFloat() / steps.toFloat()).roundToInt()
    }
    //return ((goal/10))%10;
}