package com.wallace.ticketmaster.data.service

import com.wallace.ticketmaster.data.Constants.BASE_URL
import okhttp3.Request
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.HttpURLConnection.HTTP_BAD_REQUEST
import java.net.HttpURLConnection.HTTP_OK
import java.net.HttpURLConnection.HTTP_PARTIAL
import java.net.HttpURLConnection.HTTP_UNAUTHORIZED
import java.net.HttpURLConnection.HTTP_VERSION
import java.util.concurrent.TimeUnit

class ServiceManager {

    inline fun <reified T> create(): T {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(getOkHttpClient().build())
            .build()

        return retrofit.create(T::class.java)
    }

    fun getOkHttpClient(): OkHttpClient.Builder {
        val okHttpClient: OkHttpClient.Builder = OkHttpClient.Builder()
        okHttpClient.connectTimeout(60L, TimeUnit.SECONDS)
        okHttpClient.readTimeout(60L, TimeUnit.SECONDS)
        okHttpClient.writeTimeout(60L, TimeUnit.SECONDS)

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        okHttpClient.addInterceptor(interceptor)
        return okHttpClient
    }
}
