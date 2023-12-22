package com.mohamedfathidev.gymsnearby.di

import com.mohamedfathidev.gymsnearby.domain.repository.GymRepository
import com.mohamedfathidev.gymsnearby.domain.usecase.AddGymsToLocalUseCase
import com.mohamedfathidev.gymsnearby.domain.usecase.GetFavoriteGymsUseCase
import com.mohamedfathidev.gymsnearby.domain.usecase.GetGymUseCase
import com.mohamedfathidev.gymsnearby.domain.usecase.GetGymsFromLocalUseCase
import com.mohamedfathidev.gymsnearby.domain.usecase.GetGymsFromRemoteUseCase
import com.mohamedfathidev.gymsnearby.domain.usecase.UpdateAllGymsUseCase
import com.mohamedfathidev.gymsnearby.domain.usecase.UpdateFavoriteGymUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideGetGymsFromRemoteUseCase(gymRepository: GymRepository): GetGymsFromRemoteUseCase {
        return GetGymsFromRemoteUseCase(gymRepository)
    }

    @Provides
    fun provideGymUseCase(gymRepository: GymRepository): GetGymUseCase {
        return GetGymUseCase(gymRepository)
    }

    @Provides
    fun provideUpdateFavoriteGymUseCase(gymRepository: GymRepository): UpdateFavoriteGymUseCase {
        return UpdateFavoriteGymUseCase(gymRepository)
    }

    @Provides
    fun provideGetGymsFromLocalUseCase(gymRepository: GymRepository): GetGymsFromLocalUseCase {
        return GetGymsFromLocalUseCase(gymRepository)
    }

    @Provides
    fun provideAddGymsToRemoteUseCase(gymRepository: GymRepository): AddGymsToLocalUseCase {
        return AddGymsToLocalUseCase(gymRepository)
    }

    @Provides
    fun provideUpdateAllGymsUseCase(gymRepository: GymRepository): UpdateAllGymsUseCase {
        return UpdateAllGymsUseCase(gymRepository)
    }

    @Provides
    fun provideGetFavoriteGymsUseCase(gymRepository: GymRepository): GetFavoriteGymsUseCase {
        return GetFavoriteGymsUseCase(gymRepository)
    }
}