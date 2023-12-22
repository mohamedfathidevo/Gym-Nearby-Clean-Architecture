package com.mohamedfathidev.gymsnearby.domain.util

import com.mohamedfathidev.gymsnearby.domain.entity.Gym

sealed interface UiState {
    object Loading : UiState

    data class Success(
        val data: List<Gym>
    ) : UiState

    data class Error(
        val throwable: Throwable? = null
    ) : UiState
}