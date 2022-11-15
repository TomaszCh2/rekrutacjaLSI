package com.example.rekrutacjalsi.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey val id: String,
    val name: String,
    val url: String,
    val thumbnailUrl: String
)