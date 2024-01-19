package com.example.f1_team_radio.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    var meetings by mutableStateOf<List<MeetingBean>>(listOf<MeetingBean>())
    var sessions by mutableStateOf<List<SessionBean>>(listOf<SessionBean>())
    var drivers by mutableStateOf<List<DriverBean>>(listOf<DriverBean>())
    var radios by mutableStateOf<List<TeamRadioBean>>(listOf<TeamRadioBean>())


    fun loadMeetings() {
        viewModelScope.launch(Dispatchers.Default) {
            val result = F1Api.getMeetings()
            meetings = result
        }
    }

    fun loadSessions(meetingKey: Int) {
        viewModelScope.launch(Dispatchers.Default) {
            val result = F1Api.getSessions(meetingKey)
            sessions = result
        }
    }

    fun loadDrivers(sessionKey: Int) {
        viewModelScope.launch(Dispatchers.Default) {
            val result = F1Api.getDrivers(sessionKey = sessionKey)
            drivers = result
        }
    }

    fun loadRadios(sessionKey: Int, driverNumber: Int) {
        viewModelScope.launch(Dispatchers.Default) {
            val result = F1Api.getRadios(sessionKey = sessionKey, driverNumber = driverNumber)
            radios = result
        }
    }
}