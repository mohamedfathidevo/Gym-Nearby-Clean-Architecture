package com.mohamedfathidev.gymsnearby.domain.usecase

import com.mohamedfathidev.gymsnearby.domain.entity.Gym
import com.mohamedfathidev.gymsnearby.domain.repository.GymRepository

class AddGymsToLocalUseCase(
    private val gymRepository: GymRepository
) {
    suspend operator fun invoke(gyms: List<Gym>) {
        gymRepository.addGymsToLocal(gyms)
    }
}