package com.mohamedfathidev.gymsnearby.domain.usecase

import com.mohamedfathidev.gymsnearby.domain.entity.Gym
import com.mohamedfathidev.gymsnearby.domain.repository.GymRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetGymUseCase(
    private val gymRepository: GymRepository
) {
    suspend operator fun invoke(id: Int): Gym {
        return gymRepository.getGymById(id)
    }
}