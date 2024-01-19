package com.example.f1_team_radio.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.example.f1_team_radio.model.MainViewModel
import com.example.f1_team_radio.ui.components.BackButton
import com.example.f1_team_radio.ui.components.SessionCard

@Composable
fun SessionScreen(viewModel: MainViewModel,meetingKey:Int,navController: NavHostController){
    viewModel.loadSessions(meetingKey)
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Text("Select the session you want to ear the radios from",fontWeight = FontWeight.Bold, fontSize = 20.sp, modifier = Modifier.padding(horizontal = 15.dp, vertical = 10.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            Column() {
                viewModel.sessions.map {
                    SessionCard(session = it, onClick = {navController.navigate("driverScreen/${it.sessionKey}")} )
                }
            BackButton(navController)
            }
        }
    }
}