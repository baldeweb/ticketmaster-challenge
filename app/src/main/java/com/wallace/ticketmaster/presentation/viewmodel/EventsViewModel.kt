package com.wallace.ticketmaster.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import com.wallace.ticketmaster.domain.dto.EventModel
import com.wallace.ticketmaster.domain.usecase.EventsUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class EventsViewModel(
    private val useCase: EventsUseCase,
    private val dispatcherDefault: CoroutineDispatcher = Dispatchers.Default
) : BaseViewModel(), EventsContract.ViewModel {

    private val _eventsStateFlow = MutableStateFlow<List<EventModel>>(emptyList())
    val eventsStateFlow: StateFlow<List<EventModel>> = _eventsStateFlow.asStateFlow()

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _fullEventsList = mutableListOf<EventModel>()

    init {
        getEvents()
    }

    override fun getEvents() {
        _isLoading.value = true
        viewModelScope.launch(dispatcherDefault) {
            serviceCaller(useCase.execute(), {
                it?.embedded?.events?.let { events ->
                    _fullEventsList.clear()
                    _fullEventsList.addAll(events)
                    _eventsStateFlow.value = events
                }
                _isLoading.value = false
            }, {
                _isLoading.value = false
            })
        }
    }

    override fun updateSearchQuery(query: String) {
        viewModelScope.launch(dispatcherDefault) {
            delay(300)
            val filteredEvents = if (query.isEmpty()) {
                _fullEventsList.toList()
            } else {
                _fullEventsList.filter {
                    it.name?.contains(query, ignoreCase = true) == true
                }
            }
            _eventsStateFlow.value = filteredEvents
        }
    }
}
