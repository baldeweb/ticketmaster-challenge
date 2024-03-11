package com.wallace.ticketmaster.domain.usecase

import com.wallace.ticketmaster.domain.dto.BaseResponse
import retrofit2.Response

interface EventsUseCase {
    suspend fun execute(): Response<BaseResponse?>?
}