package com.example.rekrutacjalsi

import androidx.room.PrimaryKey

data class UserItem(
    val id: String,
    val name: String,
    val url: String,
    val thumbnailUrl: String
)