package com.wallace.ticketmaster.domain.repository

import com.wallace.ticketmaster.domain.dto.BaseResponse
import retrofit2.Response

interface EventsRepository {
    suspend fun getEvents(apiKey: String): Response<BaseResponse?>?
}