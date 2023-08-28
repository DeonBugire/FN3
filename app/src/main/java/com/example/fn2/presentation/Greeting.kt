package com.example.fn2.presentation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Text(
        text = "Hey Jude",
        style = TextStyle(fontSize = 22.sp)
    )
}