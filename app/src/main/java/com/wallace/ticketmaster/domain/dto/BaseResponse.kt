package com.wallace.ticketmaster.domain.dto

import com.google.gson.annotations.SerializedName

class BaseResponse(
    @SerializedName("_embedded")
    val embedded: EventsModel? = null,
    @SerializedName("_links")
    val links: LinksModel? = null,
    @SerializedName("page")
    val page: PageModel? = null
)

data class EventsModel(
    @SerializedName("events")
    val events: ArrayList<EventModel>? = arrayListOf()
)

data class LinksModel(
    @SerializedName("first")
    val first: LinkModel? = null,
    @SerializedName("self")
    val self: LinkModel? = null,
    @SerializedName("next")
    val next: LinkModel? = null,
    @SerializedName("last")
    val last: LinkModel? = null
)

data class LinkModel(
    @SerializedName("href")
    val href: String? = null
)

data class PageModel(
    @SerializedName("size")
    val size: Int? = null,
    @SerializedName("totalElements")
    val totalElements: Long? = null,
    @SerializedName("totalPages")
    val totalPages: Int? = null,
    @SerializedName("number")
    val number: Int? = null
)
