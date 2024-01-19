package com.example.f1_team_radio.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.f1_team_radio.model.MainViewModel
import com.example.f1_team_radio.ui.components.BackButton
import com.example.f1_team_radio.ui.components.RadioCard

@Composable
fun RadioScreen(
    viewModel: MainViewModel,
    driverNumber: Int,
    sessionKey: Int,
    navController: NavHostController
) {
    var position = 1
    viewModel.loadRadios(sessionKey = sessionKey, driverNumber = driverNumber)
    Column {
        if (viewModel.radios.isEmpty()) {
            Text("There is no radios", fontWeight = FontWeight.Bold, fontSize = 25.sp)
        } else {
            Column {
                Text(
                    "There are ${viewModel.radios.count()} radios availables",
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp,
                    modifier = Modifier.padding(10.dp)
                )
                viewModel.radios.map {
                    RadioCard(radio = it, position = position++)
                }
            }
        }
        BackButton(navController = navController)
    }

}