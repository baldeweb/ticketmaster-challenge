package com.wallace.ticketmaster.data.storage

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DataStoreManager(val context: Context) {
    private val Context.dataStore by preferencesDataStore(name = "events_data_store")

    companion object {
        val EVENTS_RESPONSE_KEY = stringPreferencesKey("events_response_key")
    }

    suspend fun saveEventsResponse(response: String) {
        context.dataStore.edit { preferences ->
            preferences[EVENTS_RESPONSE_KEY] = response
        }
    }

    val eventsResponse: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[EVENTS_RESPONSE_KEY]
        }
}
