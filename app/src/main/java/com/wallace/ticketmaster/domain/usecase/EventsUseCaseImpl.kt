package com.wallace.ticketmaster.domain.usecase

import android.content.Context
import com.google.gson.Gson
import com.wallace.ticketmaster.data.Constants.API_KEY
import com.wallace.ticketmaster.data.storage.DataStoreManager
import com.wallace.ticketmaster.data.utils.hasNetworkConnection
import com.wallace.ticketmaster.domain.dto.BaseResponse
import com.wallace.ticketmaster.domain.repository.EventsRepository
import kotlinx.coroutines.flow.first
import retrofit2.Response

class EventsUseCaseImpl(
    private val repository: EventsRepository,
    private val dataStoreManager: DataStoreManager,
    private val context: Context
) : EventsUseCase {

    override suspend fun execute(): Response<BaseResponse?>? {
        return if (context.hasNetworkConnection()) {
            val response = repository.getEvents(API_KEY)
            if (response?.isSuccessful == true) {
                val json = Gson().toJson(response.body())
                dataStoreManager.saveEventsResponse(json)
            }
            response
        } else {
            val json = dataStoreManager.eventsResponse.first()
            Gson().fromJson(json, BaseResponse::class.java)?.let { Response.success(it) }
        }
    }
}