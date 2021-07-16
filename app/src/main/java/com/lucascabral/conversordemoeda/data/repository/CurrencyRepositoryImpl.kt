package com.lucascabral.conversordemoeda.data.repository

import com.lucascabral.conversordemoeda.data.api.CurrencyApi
import com.lucascabral.conversordemoeda.data.model.CurrencyResponse
import com.lucascabral.conversordemoeda.utils.Resource
import javax.inject.Inject

class CurrencyRepositoryImpl @Inject constructor(
    private val api: CurrencyApi
) : CurrencyRepository {
    override suspend fun getRates(base: String): Resource<CurrencyResponse> {

        return try {
            val response = api.getRates(base)
            val result = response.body()
            if (response.isSuccessful && result != null) {
                Resource.Success(result)
            } else {
                Resource.Error(response.message())
            }
        } catch (ex: Exception) {
            Resource.Error(ex.message ?: "An error occurred")
        }
    }
}