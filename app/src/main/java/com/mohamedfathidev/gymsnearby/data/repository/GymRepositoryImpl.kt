package com.mohamedfathidev.gymsnearby.data.repository

import com.mohamedfathidev.gymsnearby.data.local.GymDao
import com.mohamedfathidev.gymsnearby.data.mapper.LocalFavoriteMapper
import com.mohamedfathidev.gymsnearby.data.mapper.LocalMapper
import com.mohamedfathidev.gymsnearby.data.mapper.NetworkMapper
import com.mohamedfathidev.gymsnearby.data.remote.ApiService
import com.mohamedfathidev.gymsnearby.domain.entity.Gym
import com.mohamedfathidev.gymsnearby.domain.entity.GymFavoriteState
import com.mohamedfathidev.gymsnearby.domain.repository.GymRepository

class GymRepositoryImpl(
    private val apiService: ApiService,
    private val gymDao: GymDao,
    private val networkMapper: NetworkMapper,
    private val localMapper: LocalMapper,
    private val localFavoriteMapper: LocalFavoriteMapper
) : GymRepository {
    override suspend fun getGymsFromRemote(): List<Gym> {
        return networkMapper.mapFromEntityList(apiService.getGymsNearby())
    }

    override suspend fun getGymsFromLocal(): List<Gym> {
        return localMapper.mapFromEntityList(gymDao.getGyms())
    }

    override suspend fun addGymsToLocal(gyms: List<Gym>) {
        gymDao.insertGyms(localMapper.mapToEntityList(gyms))
    }

    override suspend fun getGymById(id: Int): Gym {
        return networkMapper.mapFromEntity(apiService.getGym(id)[id.toString()]!!)
    }

    override suspend fun updateGym(gymFavoriteState: GymFavoriteState) {
        gymDao.updateGym(localFavoriteMapper.mapToEntity(gymFavoriteState))
    }

    override suspend fun getFavoriteGyms(): List<Gym> {
        return localMapper.mapFromEntityList(gymDao.getFavoriteGyms())
    }

    override suspend fun updateAll(gyms: List<GymFavoriteState>) {
        gymDao.updateAll(localFavoriteMapper.mapToEntityList(gyms))
    }

}