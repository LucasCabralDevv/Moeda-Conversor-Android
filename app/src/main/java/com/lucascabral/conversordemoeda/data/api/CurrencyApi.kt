package com.lucascabral.conversordemoeda.data.api

import com.lucascabral.conversordemoeda.data.model.CurrencyResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

const val ACCESS_KEY = "2d78b5f770582b556034a15b71e185d2"

interface CurrencyApi {

    @GET("latest/?access_key=$ACCESS_KEY")
    suspend fun getRates(
        @Query("base") base: String
    ): Response<CurrencyResponse>
}