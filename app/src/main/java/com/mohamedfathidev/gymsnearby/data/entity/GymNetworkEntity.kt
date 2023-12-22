package com.mohamedfathidev.gymsnearby.data.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GymNetworkEntity(
    @SerializedName("id")
    @Expose
    val id: Int,
    @SerializedName("gym_name")
    @Expose
    val gymName: String,
    @SerializedName("gym_location")
    @Expose
    val gymLocation: String,
    @SerializedName("is_open")
    @Expose
    val isOpen: Boolean = true,
)