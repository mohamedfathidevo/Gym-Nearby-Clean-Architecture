package com.mohamedfathidev.gymsnearby.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Gyms")
data class GymLocalEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "gym_name")
    val gymName: String,
    @ColumnInfo(name = "gym_location")
    val gymLocation: String,
    @ColumnInfo(name = "is_open")
    val isOpen: Boolean = true,
    @ColumnInfo(name = "is_favorite")
    val isFavorite: Boolean = false
)