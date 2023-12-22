package com.mohamedfathidev.gymsnearby.di

import com.mohamedfathidev.gymsnearby.data.local.GymDao
import com.mohamedfathidev.gymsnearby.data.mapper.LocalFavoriteMapper
import com.mohamedfathidev.gymsnearby.data.mapper.LocalMapper
import com.mohamedfathidev.gymsnearby.data.mapper.NetworkMapper
import com.mohamedfathidev.gymsnearby.data.remote.ApiService
import com.mohamedfathidev.gymsnearby.data.repository.GymRepositoryImpl
import com.mohamedfathidev.gymsnearby.domain.repository.GymRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideRepository(
        apiService: ApiService,
        gymDao: GymDao,
        networkMapper: NetworkMapper,
        localMapper: LocalMapper,
        localFavoriteMapper: LocalFavoriteMapper
    ): GymRepository {
        return GymRepositoryImpl(
            apiService,
            gymDao,
            networkMapper,
            localMapper,
            localFavoriteMapper
        )
    }

}