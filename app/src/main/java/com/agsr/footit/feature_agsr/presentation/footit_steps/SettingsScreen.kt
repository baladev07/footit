package com.agsr.footit.feature_agsr.presentation.footit_steps

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.agsr.footit.feature_agsr.presentation.ViewModels.AppPreferenceVM


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SettingsScreen(navController:NavController,appPreferenceVM: AppPreferenceVM)
{
    val canEditGoal: Boolean by appPreferenceVM.canEditGoal.collectAsState()
    val canEditHistory: Boolean by appPreferenceVM.canEditHistory.collectAsState()
    Scaffold(topBar = {
        TopAppBar(
            title =
            {
                Text(text = "Settings", color = Color.Black, style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 24.sp))
            },
            modifier = Modifier.background(Color.DarkGray),
            colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = Color(android.graphics.Color.parseColor("#C794EE"))),
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        Icons.Filled.ArrowBack,
                        contentDescription = "",
                        tint = Color.White
                    )
                }
            }
        )})
    {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column() {
                Card( modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp),shape= RectangleShape
                ) {
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween)
                    {
                        Text(text = "Edit a goal", color = Color.Black, textAlign = TextAlign.Justify, modifier = Modifier.padding(10.dp,10.dp,0.dp,0.dp), style = TextStyle(fontSize = 24.sp))
                        Switch(
                            modifier = Modifier.semantics { contentDescription = "Set active" }.padding(10.dp,0.dp,10.dp,0.dp),
                            checked = canEditGoal,
                            onCheckedChange = {appPreferenceVM.saveCanEditGoalPreference(it)})

                    }
                }
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp),shape= RectangleShape)
                {
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween)
                    {
                        Text(text = "Edit a history", color = Color.Black, textAlign = TextAlign.Justify, modifier = Modifier.padding(10.dp,10.dp,0.dp,0.dp), style = TextStyle(fontSize = 24.sp))
                        Switch(
                            modifier = Modifier.semantics { contentDescription = "Set active" }.padding(10.dp,0.dp,10.dp,0.dp),
                            checked = canEditHistory,
                            onCheckedChange = {appPreferenceVM.saveCanEditHistoryPreference(it)})

                    }
                }
            }
        }
    }
}