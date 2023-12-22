package com.mohamedfathidev.gymsnearby.domain.repository

import com.mohamedfathidev.gymsnearby.domain.entity.Gym
import com.mohamedfathidev.gymsnearby.domain.entity.GymFavoriteState

interface GymRepository {
    suspend fun getGymsFromRemote(): List<Gym>
    suspend fun getGymsFromLocal(): List<Gym>
    suspend fun addGymsToLocal(gyms: List<Gym>)
    suspend fun getGymById(id: Int): Gym
    suspend fun updateGym(gymFavoriteState: GymFavoriteState)
    suspend fun getFavoriteGyms(): List<Gym>
    suspend fun updateAll(gyms: List<GymFavoriteState>)
}