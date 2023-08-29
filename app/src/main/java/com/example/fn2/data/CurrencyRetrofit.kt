package com.example.fn2.data


import com.example.fn2.domain.Currencies
import retrofit2.http.GET


interface CurrencyAPI {
    @GET("latest?apikey=fca_live_xlJOAdBc3gF8c5MmDinU2EJuWYyryvYuXIp5RPcl")
    suspend fun getCurrency(): Currencies
}