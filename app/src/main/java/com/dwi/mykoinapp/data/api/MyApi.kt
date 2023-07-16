package com.dwi.mykoinapp.data.api

import com.dwi.mykoinapp.BuildConfig
import com.dwi.mykoinapp.data.model.ArticlesItem
import com.dwi.mykoinapp.data.model.HeadlineResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MyApi {

    /**
     * @param countryCode is a code of country that we want to get the headline news
     * @param apiKey is an api key from newsapi.org you can get it by register to newsapi.org
     **/
    @GET("everything")
    suspend fun getHeadLine(
        @Query("pageSize") pageSize: Int,
        @Query("page") page: Int,
        @Query("q") keyword: String = "apple",
        @Query("apiKey") apiKey: String = BuildConfig.API_KEY,
    ): HeadlineResponse
}