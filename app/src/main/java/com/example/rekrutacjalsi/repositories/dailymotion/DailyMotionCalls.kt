package com.example.rekrutacjalsi.repositories.dailymotion

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface DailyMotionCalls {

    @GET("/users")
    suspend fun getUsers(): Response<DailyMotionUsers>

    companion object{
        private val BASEURL = "https://api.dailymotion.com/"

        val service = Retrofit.Builder().baseUrl(BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DailyMotionCalls::class.java)
    }
}