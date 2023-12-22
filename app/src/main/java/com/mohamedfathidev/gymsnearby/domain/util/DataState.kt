package com.mohamedfathidev.gymsnearby.domain.util

import com.mohamedfathidev.gymsnearby.domain.entity.Gym

sealed interface DataState {
    data class Success(val data: List<Gym>) : DataState
    data class Error(val exception: Throwable? = null) : DataState
    object Loading : DataState
}