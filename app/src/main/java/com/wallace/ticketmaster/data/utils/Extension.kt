package com.wallace.ticketmaster.data.utils

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.Uri
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*

fun String.convertHumanDateTime(): String {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault()).apply {
        timeZone = TimeZone.getTimeZone("UTC")
    }
    val outputFormat = SimpleDateFormat("yyyy-MM-dd 'at' HH'h'mm", Locale.getDefault())
    return this.let {
        inputFormat.parse(it)?.let { date ->
            outputFormat.format(date)
        } ?: "Invalid Date"
    }
}

fun Double.toCurrency(): String {
    val formatter = NumberFormat.getNumberInstance(Locale.US).apply {
        minimumFractionDigits = 2
        maximumFractionDigits = 2
    }
    val formattedNumber = formatter.format(this)
    return "US$ $formattedNumber"
}

fun Context.openBrowse(url: String) {
    this.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
}

fun Context.hasNetworkConnection(): Boolean {
    val connectivityManager = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val networkInfo = connectivityManager.activeNetworkInfo
    return networkInfo?.isConnectedOrConnecting == true
}