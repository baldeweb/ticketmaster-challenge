package com.wallace.ticketmaster.presentation.compose.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.wallace.ticketmaster.data.utils.toCurrency
import com.wallace.ticketmaster.domain.dto.BuySessionDTO
import com.wallace.ticketmaster.presentation.compose.EventCard
import com.wallace.ticketmaster.presentation.compose.components.AlertDialogCustom
import com.wallace.ticketmaster.presentation.compose.components.SearchBar
import com.wallace.ticketmaster.presentation.compose.components.StatusBarCustom
import com.wallace.ticketmaster.presentation.viewmodel.EventsViewModel
import java.util.UUID

@Composable
fun EventScreen(
    viewModel: EventsViewModel,
    onEventCardClick: (BuySessionDTO) -> Unit,
    modifier: Modifier = Modifier,
) {
    val events by viewModel.eventsStateFlow.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    var showDialog by remember { mutableStateOf(false) }
    var dialogContent by remember { mutableStateOf("") }

    Column(modifier = modifier) {
        StatusBarCustom(color = 0xFF026CDF)
        if (isLoading) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator(modifier = Modifier.size(100.dp))
            }
        } else {
            if (showDialog) {
                AlertDialogCustom(
                    onDismiss = { showDialog = false },
                    text = dialogContent
                )
            }
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                item {
                    SearchBar(onSearch = { query ->
                        viewModel.updateSearchQuery(query)
                    })
                    Spacer(Modifier.height(48.dp))
                }
                items(
                    items = events,
                    key = { event -> event.id ?: UUID.randomUUID().toString() }
                ) { event ->
                    EventCard(
                        event = event,
                        onPleaseNotesClicked = {
                            dialogContent = event.pleaseNote ?: return@EventCard
                            showDialog = true
                        },
                        onEventCardClick = {
                            onEventCardClick.invoke(
                                BuySessionDTO(
                                    event.seatmap?.staticUrl,
                                    event.ticketLimit?.info,
                                    event.priceRanges?.firstOrNull()?.min?.toCurrency(),
                                    event.priceRanges?.firstOrNull()?.max?.toCurrency(),
                                    event.url
                                )
                            )
                        }
                    )
                }
            }
        }
    }
}