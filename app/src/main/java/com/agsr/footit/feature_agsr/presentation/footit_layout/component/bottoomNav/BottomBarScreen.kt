package com.agsr.footit.feature_agsr.presentation.footit_layout.component.bottoomNav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.GolfCourse
import androidx.compose.material.icons.rounded.History
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.agsr.footit.R

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val iconType: ImageVector,
    val icon_focused: Int
) {

    // for home
    object Steps : BottomBarScreen(
        route = "home",
        title = "Steps",
        iconType = Icons.Rounded.Home,
        icon_focused = R.drawable.ic_bottom_home_focused
    )

    // for report
    object Goals : BottomBarScreen(
        route = "report",
        title = "Goals",
        iconType = Icons.Rounded.GolfCourse,
        icon_focused = R.drawable.ic_bottom_report_focused
    )

    // for report
    object History : BottomBarScreen(
        route = "profile",
        title = "History",
        iconType = Icons.Rounded.History,
        icon_focused = R.drawable.ic_bottom_profile_focused
    )

    object Settings : BottomBarScreen(
        route = "settings",
        title = "Settings",
        iconType = Icons.Rounded.Settings,
        icon_focused = R.drawable.ic_bottom_home_focused
    )
}