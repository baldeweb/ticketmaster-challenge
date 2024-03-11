package com.wallace.ticketmaster.domain.dto

data class BuySessionDTO(
    val imageSeatMapUrl: String? = null,
    val overallMessageParam: String? = null,
    val lowestPrice: String? = null,
    val highestPrice: String? = null,
    val buyUrl: String? = null
)
