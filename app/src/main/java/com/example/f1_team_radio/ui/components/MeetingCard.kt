package com.example.f1_team_radio.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.f1_team_radio.Routes
import com.example.f1_team_radio.model.DEFAULT_MEETING_KEY
import com.example.f1_team_radio.model.MeetingBean

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MeetingCard(modifier: Modifier=Modifier,navController: NavController,meeting: MeetingBean){
    ElevatedCard(modifier=modifier, onClick = {
        // The default meeting is the one of the las grand prix of the 2023 season
        navController.navigate(Routes.SessionScreen.addParam(meeting.meetingKey?: DEFAULT_MEETING_KEY))
    }) {
        Column(modifier.padding(vertical = 5.dp)) {
            Text(meeting.meetingOfficialName?:"", fontSize = 25.sp, fontWeight = FontWeight.SemiBold)
            Text("Track: ${meeting.location}")
            Text("Season: ${meeting.year}")
        }
    }
}