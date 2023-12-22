package com.mohamedfathidev.gymsnearby.data.entity

import androidx.room.ColumnInfo

data class GymLocalFavoriteEntity(
    @ColumnInfo(name = "id")
    val id: Int,
    @ColumnInfo(name = "is_favorite")
    val isFavorite: Boolean = false
)