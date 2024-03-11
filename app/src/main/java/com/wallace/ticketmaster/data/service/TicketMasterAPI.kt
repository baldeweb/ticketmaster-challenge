package com.wallace.ticketmaster.data.service

import com.wallace.ticketmaster.domain.dto.BaseResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TicketMasterAPI {
    @GET("events.json")
    suspend fun getEvents(@Query("apikey") apiKey: String): Response<BaseResponse?>?
}