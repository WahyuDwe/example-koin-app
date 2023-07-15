package com.dwi.mykoinapp.data.api

import com.dwi.mykoinapp.data.model.HeadlineResponse
import com.dwi.mykoinapp.utils.Constanta.API_KEY
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MyApi {

    @GET("top-headlines")
    fun getHeadLine(
        @Query("country") countryCode: String = "us",
        @Query("apiKey") apiKey: String = API_KEY,
    ): Call<HeadlineResponse>
}