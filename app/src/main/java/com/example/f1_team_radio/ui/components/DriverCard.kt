package com.example.f1_team_radio.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.example.f12023.R
import com.example.f1_team_radio.model.DriverBean

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DriverCard(driver:DriverBean,modifier:Modifier= Modifier,onClick:()->Unit){
    ElevatedCard(modifier= modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp, vertical = 10.dp)
        .clickable {
            onClick()
        }
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            GlideImage(
                model = driver.headshotUrl,
                contentDescription = driver.fullName,
                failure = placeholder(R.mipmap.ic_launcher),
                modifier = Modifier.width(40.dp).height(40.dp)
            )
            Text(
                "${driver.driverNumber}: ${driver.fullName}",
                fontSize = 23.sp,
                modifier = Modifier.padding(10.dp),
                fontWeight = FontWeight.Bold
            )
        }
    }
}