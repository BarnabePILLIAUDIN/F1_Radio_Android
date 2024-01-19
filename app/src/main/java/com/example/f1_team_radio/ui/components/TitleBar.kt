package com.example.f1_team_radio.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Title bar have no modifier in it's parameters as it should be the same in all screens it's called
@Composable
fun TitleBar(){
    Row(modifier = Modifier.fillMaxWidth().padding(vertical = 5.dp), horizontalArrangement = Arrangement.Absolute.Center) {
        Text("Welcome to F1 radio", fontSize = 35.sp, fontWeight = FontWeight.Bold)
    }
}