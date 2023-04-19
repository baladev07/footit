package com.agsr.footit.feature_agsr.presentation.footit_steps.components

import android.content.res.Resources.Theme
import android.graphics.Paint.Align
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.RunCircle
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.style.TextAlign
import com.agsr.footit.feature_agsr.presentation.ViewModels.StepsVM
import com.agsr.footit.feature_agsr.presentation.footit_steps.showAddStepsDialog

var pregressPercentage = mutableStateOf(0f)
var numberR =
    mutableStateOf(0f)
@Preview
@Composable
fun stepProgress() {
//        CircularProgressIndicator(
//            progress = 4f,
//            modifier = Modifier
//                .height(120.dp)
//                .width(120.dp)
//                .clickable { showAddStepsDialog(stepsVM) }
//        )
        Row (   ) {
            androidx.compose.material3.Text("3740",
            textAlign = TextAlign.Center)
        }
        Row () {
            androidx.compose.material3.Text("steps")
        }

}

@Composable
fun setStepsProgressBar(stepsVM : StepsVM) {
    CircularProgressbar3(stepsVM = stepsVM)
}


@Composable
fun CircularProgressbar3(
    number: Float = pregressPercentage.value,
    numberStyle: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontSize = 28.sp
    ),
    size: Dp = 240.dp,
    indicatorThickness: Dp = 28.dp,
    animationDuration: Int = 1000,
    animationDelay: Int = 0,
    foregroundIndicatorColor: Color = androidx.compose.material3.MaterialTheme.colorScheme.primary,
    backgroundIndicatorColor: Color = Color.LightGray.copy(alpha = 0.3f),
    stepsVM: StepsVM
) {
    var numberR = remember { mutableStateOf(stepsVM.goalProgressPercenteage.value)}
    var stepsStyle: TextStyle = TextStyle(
    fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Light,
    fontSize = 15.sp
    )
    // It remembers the number value
    numberR.value = stepsVM.goalProgressPercenteage.value

    // Number Animation
    val animateNumber = animateFloatAsState(
        targetValue = numberR.value,
        animationSpec = tween(
            durationMillis = animationDuration,
            delayMillis = animationDelay
        )
    )

    // This is to start the animation when the activity is opened
    LaunchedEffect(Unit) {
        numberR.value = stepsVM.goalProgressPercenteage.value
    }

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(size = size),
        ) {
            Canvas(
                modifier = Modifier
                    .size(size = size)
            ) {

                // Background circle
                drawCircle(
                    color = backgroundIndicatorColor,
                    radius = size.toPx() / 2,
                    style = Stroke(width = indicatorThickness.toPx(), cap = StrokeCap.Round)
                )

                val sweepAngle = (animateNumber.value / 100) * 360

                // Foreground circle
                drawArc(
                    color = foregroundIndicatorColor,
                    startAngle = -90f,
                    sweepAngle = sweepAngle,
                    useCenter = false,
                    style = Stroke(indicatorThickness.toPx(), cap = StrokeCap.Round)
                )
            }
            Column(modifier = Modifier.height(120.dp)) {
                Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                    Icon(
                        Icons.Rounded.RunCircle, ""
                    )
                }
                Row(
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                ) {
                    // Text that shows number inside the circle
                    Text(
                        text = if (stepsVM.stepsProgressed.value != null) stepsVM.stepsProgressed.value.toString() else "0",
                        //,
                        style = numberStyle,
                        color = Color.Black
                    )
//                Text(
//                    text = "steps"  ,
//                    style = stepsStyle,
//                    color = Color.Black
//                )
                }
                Spacer(modifier = Modifier.height(72.dp))
                FilledTonalButton(onClick = { /*TODO*/ }) {
                    androidx.compose.material3.Text(
                        if(animateNumber.value < 0 && animateNumber.value > 100) "" else (animateNumber.value).toInt().toString()
                                + "% goal progress") }
            }
        }


//    ButtonProgressbar {
//        numberR = (1..100).random().toFloat()
//    }
}


@Composable
private fun ButtonProgressbar(
    backgroundColor: Color = Color(0xFF35898f),
    onClickButton: () -> Unit
) {
    Button(
        onClick = {
            onClickButton()
        },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor
        )
    ) {
        Text(
            text = "Click to edit Step",
            color = Color.White,
            fontSize = 16.sp
        )
    }
}