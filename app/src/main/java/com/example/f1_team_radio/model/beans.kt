package com.example.f1_team_radio.model

import com.google.gson.annotations.SerializedName

data class MeetingBean(
    @SerializedName("meeting_name")
    val meetingName: String? = null,
    @SerializedName("meeting_official_name")
    val meetingOfficialName: String? = null,
    @SerializedName("location")
    val location: String? = null,
    @SerializedName("country_key")
    val countryKey: Int? = null,
    @SerializedName("country_code")
    val countryCode: String? = null,
    @SerializedName("country_name")
    val countryName: String? = null,
    @SerializedName("circuit_key")
    val circuitKey: Int? = null,
    @SerializedName("circuit_short_name")
    val circuitShortName: String? = null,
    @SerializedName("date_start")
    val dateStart: String? = null,
    @SerializedName("gmt_offset")
    val gmtOffset: String? = null,
    @SerializedName("meeting_key")
    val meetingKey: Int? = null,
    @SerializedName("year")
    val year: Int? = null
)

data class MeetingsResponseBean(
    val meetings:List<MeetingBean>
)

data class SessionBean(
    @SerializedName("location")
    val location: String? = null,
    @SerializedName("country_key")
    val countryKey: Int? = null,
    @SerializedName("country_code")
    val countryCode: String? = null,
    @SerializedName("country_name")
    val countryName: String? = null,
    @SerializedName("circuit_key")
    val circuitKey: Int? = null,
    @SerializedName("circuit_short_name")
    val circuitShortName: String? = null,
    @SerializedName("session_type")
    val sessionType: String? = null,
    @SerializedName("session_name")
    val sessionName: String? = null,
    @SerializedName("date_start")
    val dateStart: String? = null,
    @SerializedName("date_end")
    val dateEnd: String? = null,
    @SerializedName("gmt_offset")
    val gmtOffset: String? = null,
    @SerializedName("session_key")
    val sessionKey: Int? = null,
    @SerializedName("meeting_key")
    val meetingKey: Int? = null,
    @SerializedName("year")
    val year: Int? = null
)

data class SessionsResponseBean(
    val sessions: List<SessionBean>
)

data class DriverBean(
    @SerializedName("driver_number")
    val driverNumber: Int? = null,
    @SerializedName("broadcast_name")
    val broadcastName : String? = null,
    @SerializedName("full_name")
    val fullName: String? = null,
    @SerializedName("name_acronym")
    val nameAcronym: String? = null,
    @SerializedName("team_name")
    val teamName: String? = null,
    @SerializedName("team_colour")
    val teamColour: String? = null,
    @SerializedName("first_name")
    val firstName: String? = null,
    @SerializedName("last_name")
    val lastName: String? = null,
    @SerializedName("headshot_url")
    val headshotUrl: String? = null,
    @SerializedName("country_code")
    val countryCode: String? = null,
    @SerializedName("session_key" )
    val sessionKey: Int? = null,
    @SerializedName("meeting_key" )
    val meetingKey: Int? = null
)

data class DriversResponseBeans(
    val drivers: List<DriverBean>
)


data class TeamRadioBean(
    @SerializedName("date")
    var date: String? = null,
    @SerializedName("driver_number")
    var driverNumber: Int? = null,
    @SerializedName("session_key")
    var sessionKey: Int? = null,
    @SerializedName("meeting_key")
    var meetingKey: Int? = null,
    @SerializedName("recording_url")
    var recordingUrl: String? = null
)

data class TeamRadiosResponseBean(
    val teamRadios:List<TeamRadioBean>
)