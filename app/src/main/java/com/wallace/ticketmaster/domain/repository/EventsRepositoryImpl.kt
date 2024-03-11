package com.wallace.ticketmaster.domain.repository

import com.wallace.ticketmaster.data.service.ServiceManager
import com.wallace.ticketmaster.data.service.TicketMasterAPI
import com.wallace.ticketmaster.domain.dto.BaseResponse
import retrofit2.Response

class EventsRepositoryImpl: EventsRepository {
    private val service = ServiceManager().create<TicketMasterAPI>()

    override suspend fun getEvents(apiKey: String): Response<BaseResponse?>? {
        return service.getEvents(apiKey)
    }
}