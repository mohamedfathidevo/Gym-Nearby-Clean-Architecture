package com.mohamedfathidev.gymsnearby.domain.entity

data class Gym(
    val id: Int = 0,
    val gymName: String,
    val gymLocation: String,
    val isOpen: Boolean = true,
    val isFavorite: Boolean = false
)
