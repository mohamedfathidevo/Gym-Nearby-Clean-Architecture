package com.mohamedfathidev.gymsnearby.domain.usecase

import com.mohamedfathidev.gymsnearby.domain.entity.Gym
import com.mohamedfathidev.gymsnearby.domain.repository.GymRepository

class GetGymsFromLocalUseCase(
    private val gymRepository: GymRepository
) {
    suspend operator fun invoke(): List<Gym> {
        return gymRepository.getGymsFromLocal()
    }
}