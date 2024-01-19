package com.example.f1_team_radio.ui.components

import android.media.AudioManager
import android.media.MediaPlayer
import android.widget.Toast
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.f1_team_radio.model.TeamRadioBean

@Composable
fun RadioCard(radio: TeamRadioBean, position: Int) {
    val ctx = LocalContext.current
    val mediaPlayer = MediaPlayer()
    if (!radio.recordingUrl.isNullOrBlank()) {
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text("${position}", fontWeight = FontWeight.Bold)
                Spacer(Modifier.width(25.dp))
                Button(
                    onClick = {
                        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC)
                        try {
                            mediaPlayer.setDataSource(radio.recordingUrl)
                            mediaPlayer.prepare()
                            mediaPlayer.start()

                        } catch (e: Exception) {

                        }
                        // on below line we are displaying a toast message as audio player.
                        Toast.makeText(ctx, "Audio started playing..", Toast.LENGTH_SHORT).show()

                    }) {
                    // on below line we are specifying
                    // text for button.
                    Icon(
                        Icons.Filled.PlayArrow,
                        contentDescription = "Localized description",
                        modifier = Modifier.size(ButtonDefaults.IconSize)
                    )
                    Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                    Text("Play")
                }
                Spacer(Modifier.width(25.dp))
                Button(
                    onClick = { mediaPlayer.stop() },
                    contentPadding = ButtonDefaults.ButtonWithIconContentPadding,
                ) {
                    Icon(
                        Icons.Filled.Clear,
                        contentDescription = "Localized description",
                        modifier = Modifier.size(ButtonDefaults.IconSize)
                    )
                    Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                    Text("Stop")
                }
            }

        }


    } else {
        Text("A problem ocured with this radio")
    }
}


