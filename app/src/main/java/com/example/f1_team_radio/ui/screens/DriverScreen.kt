package com.example.f1_team_radio.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.f1_team_radio.Routes
import com.example.f1_team_radio.model.DEFAULT_DRIVER_NUMBER
import com.example.f1_team_radio.model.MainViewModel
import com.example.f1_team_radio.ui.components.BackButton
import com.example.f1_team_radio.ui.components.DriverCard

@Composable
fun DriverScreen(sessionKey:Int,navController: NavHostController,viewModel: MainViewModel){
    viewModel.loadDrivers(sessionKey)
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Text("Select the driver you want to ear the radio", modifier = Modifier.padding(horizontal = 10.dp), fontWeight = FontWeight.SemiBold, fontSize = 22.sp)
        viewModel.drivers.map{
            DriverCard(driver=it, onClick = {navController.navigate(Routes.RadioScreen.addParams(sessionKey=sessionKey, driverNumber = it.driverNumber?: DEFAULT_DRIVER_NUMBER))})
        }
        BackButton(navController = navController)
    }
}