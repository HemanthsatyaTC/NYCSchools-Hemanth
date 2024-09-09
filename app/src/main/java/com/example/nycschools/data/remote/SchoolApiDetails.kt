package com.example.nycschools.data.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object SchoolApiDetails {

    //https://data.cityofnewyork.us/resource/s3k6-pzi2.json

    const val BASE_URL = "https://data.cityofnewyork.us/"
    const val END_POINTS = "resource/s3k6-pzi2.json"

    val retrofitDetails = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(
            OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                })
                .build()
        )
        .build()
        .create(SchoolApiInterface::class.java)
}