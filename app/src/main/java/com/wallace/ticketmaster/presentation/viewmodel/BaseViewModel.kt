package com.wallace.ticketmaster.presentation.viewmodel

import androidx.lifecycle.ViewModel
import retrofit2.Response
import java.net.HttpURLConnection

open class BaseViewModel: ViewModel() {

    protected suspend fun <T> serviceCaller(
        api: Response<T>?,
        onResponse: suspend (T?) -> Unit,
        onErrorResponse: (Throwable) -> Unit
    ) {
        when {
            (HttpURLConnection.HTTP_OK..HttpURLConnection.HTTP_PARTIAL).find { it == api?.code() } != null -> {
                api?.body()?.let {
                    onResponse.invoke(it)
                } ?: run {
                    onErrorResponse.invoke(Throwable("Empty Body"))
                }
            }

            HttpURLConnection.HTTP_UNAUTHORIZED == api?.code() -> onErrorResponse.invoke(Throwable("Unauthorized"))
            (HttpURLConnection.HTTP_BAD_REQUEST..HttpURLConnection.HTTP_VERSION).find { it == api?.code() } != null -> {
                onErrorResponse.invoke(Throwable("Client Error"))
            }

            else -> onErrorResponse.invoke(Throwable("Unknown Error"))
        }
    }
}