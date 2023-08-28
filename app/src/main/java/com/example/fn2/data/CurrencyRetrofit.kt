package com.example.fn2.data

import com.google.gson.annotations.SerializedName


data class CurrencyRateResponse(
    @SerializedName("com/example/fn2/data")
    val listOfRates: Map<String, Double>
)
class CurrencyRetrofit {
}