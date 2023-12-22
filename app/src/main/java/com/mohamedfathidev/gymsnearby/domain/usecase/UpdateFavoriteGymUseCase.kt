package com.mohamedfathidev.gymsnearby.domain.usecase

import com.mohamedfathidev.gymsnearby.domain.entity.GymFavoriteState
import com.mohamedfathidev.gymsnearby.domain.repository.GymRepository

class UpdateFavoriteGymUseCase(
    private val gymRepository: GymRepository
) {
    suspend operator fun invoke(gymFavoriteState: GymFavoriteState) {
        gymRepository.updateGym(gymFavoriteState)
    }
}