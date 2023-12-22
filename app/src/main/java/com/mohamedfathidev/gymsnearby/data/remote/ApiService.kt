package com.mohamedfathidev.gymsnearby.data.remote

import com.mohamedfathidev.gymsnearby.data.entity.GymNetworkEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("gyms.json")
    suspend fun getGymsNearby(): List<GymNetworkEntity>

    @GET("gyms.json?orderBy=\"id\"")
    suspend fun getGym(
        @Query("equalTo") id: Int
    ): Map<String, GymNetworkEntity>
}