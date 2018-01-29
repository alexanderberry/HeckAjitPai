package com.example.berry.heckajitpai

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

/**
 * Created by per6 on 1/23/18.
 */
interface FilingSearchAPI {
    @Headers("Accept: application/json")
    @GET("filings")
    fun getFilings(@Query("api_key") apiKey: String, @Query("q") query: String, @Query("type") type: String,
                   @Query("filers.name") name: String): Call<Filings>
}