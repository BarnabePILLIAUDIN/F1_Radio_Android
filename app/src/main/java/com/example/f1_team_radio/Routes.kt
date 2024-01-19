package com.example.f1_team_radio

sealed class Routes(val route:String){
    object MeetingScreen : Routes("searchScreen") {
    }

    object SessionScreen: Routes("sessionScreen/{meetingKey}"){
        fun addParam(meetingKey: Int) = "sessionScreen/$meetingKey"
    }

    object DriverScreen: Routes("driverScreen/{sessionKey}"){
        fun addParam(sessionKey: Int) = "sessionScreen/$sessionKey"
    }

    object RadioScreen: Routes("radioScreen/{sessionKey}/{driverNumber}"){
        fun addParams(sessionKey: Int, driverNumber:Int) = "radioScreen/${sessionKey}/${driverNumber}"
    }
}