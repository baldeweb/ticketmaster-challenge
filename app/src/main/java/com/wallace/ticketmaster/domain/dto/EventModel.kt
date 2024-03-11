package com.wallace.ticketmaster.domain.dto

import com.google.gson.annotations.SerializedName
import kotlin.math.abs

data class EventModel(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("test")
    val test: Boolean? = null,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("locale")
    val locale: String? = null,
    @SerializedName("images")
    val images: ArrayList<Image> = arrayListOf(),
    @SerializedName("sales")
    val sales: Sales? = null,
    @SerializedName("dates")
    val dates: Dates? = null,
    @SerializedName("classifications")
    val classifications: ArrayList<Classification>? = null,
    @SerializedName("promoter")
    val promoter: Promoter? = null,
    @SerializedName("promoters")
    val promoters: ArrayList<Promoter>? = null,
    @SerializedName("pleaseNote")
    val pleaseNote: String? = null,
    @SerializedName("priceRanges")
    val priceRanges: ArrayList<PriceRange>? = null,
    @SerializedName("seatmap")
    val seatmap: Seatmap? = null,
    @SerializedName("accessibility")
    val accessibility: Accessibility? = null,
    @SerializedName("ticketLimit")
    val ticketLimit: TicketLimit? = null,
    @SerializedName("ageRestrictions")
    val ageRestrictions: AgeRestrictions? = null,
    @SerializedName("ticketing")
    val ticketing: Ticketing? = null,
    @SerializedName("_links")
    val links: LinksModel? = null,
    @SerializedName("page")
    val page: PageModel? = null,
    @SerializedName("_embedded")
    val embeddedEvent: EmbeddedEventModel? = null,
)

data class EmbeddedEventModel(
    @SerializedName("venues")
    val venues: ArrayList<EventModel>? = arrayListOf(),
    @SerializedName("attractions")
    val attractions: ArrayList<AttractionsModel>? = arrayListOf(),
)

data class AttractionsModel(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("test")
    val test: Boolean? = null,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("locale")
    val locale: String? = null,
    @SerializedName("externalLinks")
    val externalLinks: ExternalLinkModel? = null,
    @SerializedName("aliases")
    val aliases: ArrayList<String>? = arrayListOf(),
    @SerializedName("images")
    val images: ArrayList<Image>? = null,
    @SerializedName("classifications")
    val classifications: ArrayList<Classification>? = null,
    @SerializedName("upcomingEvents")
    val upcomingEvents: UpComingEventsModel? = null,
    @SerializedName("_links")
    val links: LinksModel? = null
)

data class UpComingEventsModel(
    @SerializedName("tmr")
    val tmr: Int? = null,
    @SerializedName("ticketmaster")
    val ticketmaster: Int? = null,
    @SerializedName("_total")
    val _total: Int? = null,
    @SerializedName("_filtered")
    val _filtered: Int? = null
)

data class ExternalLinkModel(
    @SerializedName("twitter")
    val twitterList: ArrayList<UrlModel>? = arrayListOf(),
    @SerializedName("wiki")
    val wikiList: ArrayList<UrlModel>? = arrayListOf(),
    @SerializedName("facebook")
    val facebookList: ArrayList<UrlModel>? = arrayListOf(),
    @SerializedName("instagram")
    val instagramList: ArrayList<UrlModel>? = arrayListOf(),
    @SerializedName("homepage")
    val homepageList: ArrayList<UrlModel>? = arrayListOf(),
)

data class UrlModel(
    @SerializedName("url")
    val url: String? = null,
)

data class Image(
    @SerializedName("ratio")
    val ratio: String? = null,
    @SerializedName("url")
    val url: String? = null,
    @SerializedName("width")
    val width: Int? = null,
    @SerializedName("height")
    val height: Int? = null,
    @SerializedName("fallback")
    val fallback: Boolean? = null
)

data class Sales(
    @SerializedName("public")
    val public: PublicSales? = null,
    @SerializedName("presales")
    val presales: ArrayList<Presale>? = arrayListOf()
)

data class PublicSales(
    @SerializedName("startDateTime")
    val startDateTime: String? = null,
    @SerializedName("endDateTime")
    val endDateTime: String? = null,
    @SerializedName("startTBD")
    val startTBD: Boolean? = null,
    @SerializedName("startTBA")
    val startTBA: Boolean? = null
)

data class Presale(
    @SerializedName("startDateTime")
    val startDateTime: String? = null,
    @SerializedName("endDateTime")
    val endDateTime: String? = null,
    @SerializedName("name")
    val name: String? = null
)

data class Dates(
    @SerializedName("start")
    val start: StartDate? = null,
    @SerializedName("timezone")
    val timezone: String? = null,
    @SerializedName("status")
    val status: Status? = null,
    @SerializedName("spanMultipleDays")
    val spanMultipleDays: Boolean? = null
)

data class StartDate(
    @SerializedName("localDate")
    val localDate: String? = null,
    @SerializedName("localTime")
    val localTime: String? = null,
    @SerializedName("dateTime")
    val dateTime: String? = null,
    @SerializedName("dateTBD")
    val dateTBD: Boolean? = null,
    @SerializedName("dateTBA")
    val dateTBA: Boolean? = null,
    @SerializedName("timeTBA")
    val timeTBA: Boolean? = null,
    @SerializedName("noSpecificTime")
    val noSpecificTime: Boolean? = null
)

data class Status(
    @SerializedName("code")
    val code: String? = null
)

data class Seatmap(
    @SerializedName("staticUrl")
    val staticUrl: String? = null
)

data class Accessibility(
    @SerializedName("info")
    val info: String? = null,
    @SerializedName("ticketLimit")
    val ticketLimit: Int? = null
)

data class TicketLimit(
    @SerializedName("info")
    val info: String? = null
)

data class AgeRestrictions(
    @SerializedName("legalAgeEnforced")
    val legalAgeEnforced: Boolean? = null
)

data class Ticketing(
    @SerializedName("safeTix")
    val safeTix: SafeTix? = null,
    @SerializedName("allInclusivePricing")
    val allInclusivePricing: AllInclusivePricing? = null
)

data class SafeTix(
    @SerializedName("enabled")
    val enabled: Boolean? = null
)

data class AllInclusivePricing(
    @SerializedName("enabled")
    val enabled: Boolean? = null
)

data class Classification(
    @SerializedName("primary")
    val primary: Boolean? = null,
    @SerializedName("segment")
    val segment: Segment? = null,
    @SerializedName("genre")
    val genre: Genre? = null,
    @SerializedName("subGenre")
    val subGenre: SubGenre? = null,
    @SerializedName("type")
    val type: Type? = null,
    @SerializedName("subType")
    val subType: SubType? = null,
    @SerializedName("family")
    val family: Boolean? = null
)

data class Segment(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("name")
    val name: String? = null
)

data class Genre(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("name")
    val name: String? = null
)

data class SubGenre(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("name")
    val name: String? = null
)

data class Type(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("name")
    val name: String? = null
)

data class SubType(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("name")
    val name: String? = null
)

data class Promoter(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("name")
    val name: String? = null
)

data class PriceRange(
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("currency")
    val currency: String? = null,
    @SerializedName("min")
    val min: Double? = null,
    @SerializedName("max")
    val max: Double? = null
) {
    fun getAvg() = abs((min ?: 0.0) + (max ?: 0.0))
}