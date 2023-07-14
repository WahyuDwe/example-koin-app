package com.dwi.mykoinapp.data.api

import com.dwi.mykoinapp.data.model.HeadlineResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MyApi {

    @GET("top-headlines")
    fun getHeadLine(
        @Query("country") countryCode: String = "us",
        @Query("apiKey") apiKey: String = "fdc836aab9254a9f97aa57c313c8b84c",
    ): Call<HeadlineResponse>
}