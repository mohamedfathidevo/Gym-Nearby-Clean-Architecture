package com.mohamedfathidev.gymsnearby.presentation.DetailsScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mohamedfathidev.gymsnearby.domain.entity.Gym
import com.mohamedfathidev.gymsnearby.domain.usecase.GetGymUseCase
import com.mohamedfathidev.gymsnearby.domain.usecase.GetGymsFromRemoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GymDetailsViewModel
@Inject constructor(
    private val getGymUseCase: GetGymUseCase,
    private val savedStateHandle: SavedStateHandle
): ViewModel() {
    var state by mutableStateOf(Gym(gymName = "", gymLocation = ""))

    init {
        val gymId = savedStateHandle.get<Int>("gym_id") ?: 0
        executeGym(gymId)
    }

    private fun executeGym(id: Int) {
        viewModelScope.launch {
            state = getGymUseCase(id)
        }
    }
}