package com.wallace.ticketmaster.presentation.compose.components

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext

@Composable
fun StatusBarCustom(color: Long) {
    val activity = (LocalContext.current as? Activity)
    SideEffect {
        activity?.window?.statusBarColor = Color(color = color).toArgb()
    }
}