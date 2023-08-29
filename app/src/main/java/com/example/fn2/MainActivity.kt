package com.example.fn2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.example.fn2.data.CurrencyAPI
import com.example.fn2.domain.Currencies
import com.example.fn2.presentation.Greeting
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var currentCurrency =
                remember { Currencies(listOfRates = null) }

            val scope = rememberCoroutineScope()
            val retrofit = Retrofit.Builder()
                .baseUrl("https://api.freecurrencyapi.com/v1/")
                .addConverterFactory(GsonConverterFactory.create()).build()
            val currencyAPI = retrofit.create(CurrencyAPI::class.java)

            Card {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Greeting (modifier = Modifier
                        .background(Color.Red)
                        .fillMaxWidth()
                        .weight(1f))
                    Box(modifier = Modifier.weight(6f))
                    { Text (text = "${currentCurrency.listOfRates}") }

                    Button(modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f), onClick = {

                        CoroutineScope(Dispatchers.IO).launch {
                            currentCurrency = currencyAPI.getCurrency()
                            runOnUiThread {

                            }
                        }
                    }) {
                        Text("Refresh", fontSize = 25.sp)
                    }
                }
            }


        }

    }
}




