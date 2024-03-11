package com.wallace.ticketmaster.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import com.wallace.ticketmaster.domain.dto.BuySessionDTO
import com.wallace.ticketmaster.presentation.compose.base.TicketMasterTheme
import com.wallace.ticketmaster.presentation.compose.components.AlertDialogCustom
import com.wallace.ticketmaster.presentation.compose.components.StatusBarCustom
import com.wallace.ticketmaster.presentation.compose.screen.EventScreen
import com.wallace.ticketmaster.presentation.compose.screen.SeatingMapAreaScreen
import com.wallace.ticketmaster.presentation.compose.screen.SplashScreen
import com.wallace.ticketmaster.presentation.viewmodel.EventsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    private val viewModel: EventsViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TicketMasterTheme {
                var currentScreen by remember { mutableStateOf("SplashScreen") }
                var buySessionDTO by remember { mutableStateOf(BuySessionDTO()) }
                val splashScreenOpacity = remember { Animatable(1f) }
                val screenOpacity = remember { Animatable(0f) }
                val showDialog = remember { mutableStateOf(false) }
                val dialogContent = remember { mutableStateOf("") }

                LaunchedEffect(key1 = true) {
                    splashScreenOpacity.animateTo(
                        targetValue = 0f,
                        animationSpec = tween(
                            durationMillis = 2000,
                            easing = FastOutLinearInEasing
                        )
                    )
                    currentScreen = "EventScreen"
                    screenOpacity.animateTo(
                        targetValue = 1f,
                        animationSpec = tween(
                            durationMillis = 1000,
                            easing = LinearOutSlowInEasing
                        )
                    )
                }

                Box(modifier = Modifier.fillMaxSize()) {
                    when (currentScreen) {
                        "SplashScreen" -> {
                            SplashScreen(
                                modifier = Modifier
                                    .graphicsLayer { alpha = splashScreenOpacity.value }
                                    .statusBarsPadding()
                            )
                        }

                        "EventScreen" -> EventScreen(
                            viewModel = viewModel,
                            onEventCardClick = {
                                buySessionDTO = it
                                currentScreen = "SeatingMapAreaScreen"
                           },
                            modifier = Modifier.graphicsLayer { alpha = screenOpacity.value }
                        )

                        "SeatingMapAreaScreen" -> SeatingMapAreaScreen(
                            dto = buySessionDTO,
                            modifier = Modifier.graphicsLayer { alpha = screenOpacity.value },
                            onBack = { currentScreen = "EventScreen" },
                        )

                    }

                    if (showDialog.value) {
                        AlertDialogCustom(
                            onDismiss = { showDialog.value = false },
                            text = dialogContent.value
                        )
                    }

                    StatusBarCustom(color = 0xFFABABA8)
                }
            }
        }
    }
}