package com.agsr.footit.feature_agsr.presentation.footit_steps.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.agsr.footit.feature_agsr.domain.model.Steps
import com.github.tehras.charts.bar.BarChartData
import com.github.tehras.charts.bar.BarChartData.Bar
import com.github.tehras.charts.bar.renderer.label.SimpleValueDrawer
import com.github.tehras.charts.bar.renderer.label.SimpleValueDrawer.DrawLocation.Inside
import com.github.tehras.charts.bar.renderer.label.SimpleValueDrawer.DrawLocation.Outside
import com.github.tehras.charts.bar.renderer.label.SimpleValueDrawer.DrawLocation.XAxis

import com.github.tehras.charts.bar.BarChart
import com.github.tehras.charts.bar.renderer.label.SimpleValueDrawer.DrawLocation

import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import com.github.tehras.charts.bar.BarChart
import java.util.Objects

class ActivityBarChart {
    var labelDrawer: SimpleValueDrawer by mutableStateOf(SimpleValueDrawer(drawLocation = Inside))
        private set

    var labelLocation: DrawLocation = Inside
        set(value) {
            val color = when (value) {
                Inside -> White
                Outside, XAxis -> Black
            }

            labelDrawer = SimpleValueDrawer(
                drawLocation = value,
                labelTextColor = color
            )
            field = value
        }

    var barChartData by
        mutableStateOf(
            BarChartData(
                bars = listOf(
                    Bar(
                        label = "Mon",
                        value = 200f,
                        color = Color(0XFF607D8B)
                    ),
                    Bar(
                        label = "Tue",
                        value = 300f,
                        color = Color(0XFF607D8B)
                    ),
                    Bar(
                        label = "Wed",
                        value = 120f,
                        color = Color(0XFF607D8B)
                    ),
                    Bar(
                        label = "Thu",
                        value = 303f,
                        color = Color(0XFF607D8B)
                    ),
                    Bar(
                        label = "Fri",
                        value = 111f,
                        color = Color(0XFF607D8B)
                    )

                )
            )
        )
}
@Composable
fun StepsActivityBarChart(barChartData: ActivityBarChart) {

    var labelDrawer =  remember {
        mutableStateOf(SimpleValueDrawer(drawLocation = Inside))
    }


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .padding(vertical = 60.dp)
    ) {
        BarChart(
            barChartData = barChartData.barChartData,
            labelDrawer = labelDrawer.value
        )
    }
}

@Composable
fun DrawValueLocation(
    newLocation: (DrawLocation) -> Unit,
    barChartDataModel : ActivityBarChart
) {

    val selectedAlignment = remember(barChartDataModel.labelDrawer) {
        barChartDataModel.labelLocation
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Margins.horizontal, vertical = Margins.vertical)
                .align(Alignment.CenterVertically)
        ) {
            DrawLocation.values().forEach { location ->
                OutlinedButton(
                    border = ButtonDefaults.outlinedBorder.takeIf { selectedAlignment == location },
                    onClick = { newLocation(location) }
                ) {
                    Text(location.name)
                }
            }
        }
    }
}

@Composable
private fun BarChartRow(barChartDataModel: ActivityBarChart) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .padding(vertical = Margins.verticalLarge)
    ) {
        BarChart(
            barChartData = barChartDataModel.barChartData,
            labelDrawer = barChartDataModel.labelDrawer
        )
    }
}

@Composable
public fun BarChartScreenContent() {
    val barChartDataModel = ActivityBarChart()
    Column(
        modifier = Modifier.padding(
            horizontal = Margins.horizontal,
            vertical = Margins.vertical
        )
    ) {
        BarChartRow(barChartDataModel)
    }
}

object Margins {
    val horizontal = 12.dp
    val horizontalLarge = 24.dp
    val vertical = 8.dp
    val verticalLarge = 16.dp
}