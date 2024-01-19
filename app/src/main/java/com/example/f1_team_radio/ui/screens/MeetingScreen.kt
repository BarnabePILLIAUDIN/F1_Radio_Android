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
import com.example.f1_team_radio.model.MainViewModel
import com.example.f1_team_radio.ui.components.MeetingCard
import com.example.f1_team_radio.ui.components.TitleBar

@Composable
fun MeetingScreen(navController:NavHostController,viewModel: MainViewModel) {
    viewModel.loadMeetings()
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        TitleBar()
        Text("You have teams radios from ${viewModel.meetings.count()} meetings", modifier =Modifier.padding(vertical = 17.dp, horizontal = 10.dp), fontWeight = FontWeight.SemiBold, fontSize = 20.sp )
        viewModel.meetings.map { 
            MeetingCard(meeting = it, navController = navController,modifier = Modifier.padding(vertical = 10.dp, horizontal = 15.dp))
        }
    }
}