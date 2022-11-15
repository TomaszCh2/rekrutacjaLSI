package com.example.rekrutacjalsi.repositories.dailymotion

import com.google.gson.annotations.SerializedName

data class DailyMotionUser(
    var id: String,
    @SerializedName("screenname")
    var screenName: String
)