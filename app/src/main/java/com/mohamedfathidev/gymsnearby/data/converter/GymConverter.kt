package com.mohamedfathidev.gymsnearby.data.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.mohamedfathidev.gymsnearby.domain.entity.Gym

class GymConverter {

    @TypeConverter
    fun fromGymToGson(
        gym: Gym
    ): String = Gson().toJson(gym)

    @TypeConverter
    fun fromGsonToGym(
        gymGson: String
    ): Gym = Gson().fromJson(
        gymGson, Gym::class.java
    )

}