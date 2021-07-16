package com.lucascabral.conversordemoeda.data.repository

import com.lucascabral.conversordemoeda.data.model.CurrencyResponse
import com.lucascabral.conversordemoeda.utils.Resource

interface CurrencyRepository {

    suspend fun getRates(base: String): Resource<CurrencyResponse>
}