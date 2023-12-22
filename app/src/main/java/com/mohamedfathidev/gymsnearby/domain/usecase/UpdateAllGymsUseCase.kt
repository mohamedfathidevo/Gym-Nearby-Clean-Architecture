package com.mohamedfathidev.gymsnearby.domain.usecase

import com.mohamedfathidev.gymsnearby.domain.entity.GymFavoriteState
import com.mohamedfathidev.gymsnearby.domain.repository.GymRepository

class UpdateAllGymsUseCase(
    private val gymRepository: GymRepository
) {
    suspend operator fun invoke(gyms: List<GymFavoriteState>) {
        gymRepository.updateAll(gyms)
    }
}