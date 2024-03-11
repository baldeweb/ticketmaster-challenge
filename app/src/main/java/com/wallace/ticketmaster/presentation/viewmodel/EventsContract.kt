package com.wallace.ticketmaster.presentation.viewmodel

interface EventsContract {
    interface ViewModel {
        fun getEvents()
        fun updateSearchQuery(query: String)
    }
}