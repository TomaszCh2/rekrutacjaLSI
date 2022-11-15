package com.example.rekrutacjalsi.repositories.dailymotion

import com.google.gson.annotations.SerializedName

data class DailyMotionUsers(
    var page: String,
    var limit: String,
    var explicit: Boolean,
    var total: Int,
    @SerializedName("has_more")
    var hasMore: Boolean,
    @SerializedName("list")
    var users: List<DailyMotionUser>
)