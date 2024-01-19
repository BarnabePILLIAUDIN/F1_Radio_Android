package com.example.f1_team_radio.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.f1_team_radio.model.SessionBean

@Composable
fun SessionCard(session:SessionBean,modifier: Modifier=Modifier,onClick:()->Unit){
        ElevatedCard(modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 15.dp, horizontal = 15.dp)
            .clickable {
                onClick()
            }
            ) {
            Text("${session.sessionName}", fontSize = 35.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 20.dp, vertical = 5.dp))
            Text("Session type: ${session.sessionType}",modifier = Modifier.padding(horizontal = 20.dp, vertical=5.dp),fontWeight = FontWeight.SemiBold)
    }
}