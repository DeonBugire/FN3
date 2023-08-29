package com.example.fn2.domain

import com.google.gson.annotations.SerializedName

data class Currencies(
    @SerializedName("com/example/fn2/data")
    val listOfRates: Map<String, Double>?
)