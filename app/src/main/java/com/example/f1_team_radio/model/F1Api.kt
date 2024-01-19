package com.example.f1_team_radio.model

import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request

object F1Api{
    val client = OkHttpClient()
    val gson  = Gson()


    private fun getRequest(url:String):String{
        val request = Request.Builder().url("$API_URL$url").build()
        return client.newCall(request).execute().use { //it:Response
            if (!it.isSuccessful) {
                throw Exception("Réponse du serveur incorrect :${it.code}")
            }
            it.body.string()
        }
    }

    fun getMeetings():List<MeetingBean>{
        val response = getRequest("meetings")
        // Had to simulate an object as a response to match gson's expectations
        val parsedMeetings = gson.fromJson("{meetings:$response}", MeetingsResponseBean::class.java)
        return parsedMeetings.meetings
    }

    fun getSessions(meetingKey:Int):List<SessionBean> {
        val response = getRequest("sessions?meeting_key=${meetingKey}")
        // Had to simulate an object as a response to match gson's expectations
        val parsedSessions = gson.fromJson("{sessions:$response}", SessionsResponseBean::class.java)
        return parsedSessions.sessions
    }

    fun getDrivers(sessionKey:Int):List<DriverBean>{
        val response = getRequest("drivers?session_key=$sessionKey")
        // Had to simulate an object as a response to match gson's expectations
        val parsedDrivers = gson.fromJson("{drivers:$response}", DriversResponseBeans::class.java)
        return parsedDrivers.drivers
    }

    fun getRadios(sessionKey: Int, driverNumber:Int):List<TeamRadioBean>{
        val response = getRequest("team_radio?session_key=$sessionKey&driver_number=$driverNumber")
        // Had to simulate an object as a response to match gson's expectations
        val parsedRadios = gson.fromJson("{teamRadios:$response}", TeamRadiosResponseBean::class.java)
        return parsedRadios.teamRadios
    }
}


