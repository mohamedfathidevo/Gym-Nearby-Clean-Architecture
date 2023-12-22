package com.mohamedfathidev.gymsnearby.presentation.GymsScreen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.mohamedfathidev.gymsnearby.domain.util.DataState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mohamedfathidev.gymsnearby.domain.entity.Gym
import com.mohamedfathidev.gymsnearby.domain.entity.GymFavoriteState
import com.mohamedfathidev.gymsnearby.domain.usecase.AddGymsToLocalUseCase
import com.mohamedfathidev.gymsnearby.domain.usecase.GetFavoriteGymsUseCase
import com.mohamedfathidev.gymsnearby.domain.usecase.GetGymsFromLocalUseCase
import com.mohamedfathidev.gymsnearby.domain.usecase.GetGymsFromRemoteUseCase
import com.mohamedfathidev.gymsnearby.domain.usecase.UpdateAllGymsUseCase
import com.mohamedfathidev.gymsnearby.domain.usecase.UpdateFavoriteGymUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class GymViewModel
@Inject constructor(
    private val getGymsFromRemoteUseCase: GetGymsFromRemoteUseCase,
    private val getGymsFromLocalUseCase: GetGymsFromLocalUseCase,
    private val updateFavoriteGymUseCase: UpdateFavoriteGymUseCase,
    private val updateAllGymsUseCase: UpdateAllGymsUseCase,
    private val getFavoriteGymsUseCase: GetFavoriteGymsUseCase,
    private val addGymsToLocalUseCase: AddGymsToLocalUseCase,
) : ViewModel() {

    private val _state = mutableStateOf<DataState>(DataState.Loading)
    val state: State<DataState>
        get() = _state

    init {
        getAllGyms()
    }

    private fun getAllGyms() {
        viewModelScope.launch {
            val data = updateLocalData()
            if (data.isNotEmpty())
                _state.value = DataState.Success(data)
            else
                _state.value =
                    DataState.Error(Exception("something went wrong. No date was found, try connecting ti internet"))
        }
    }

    private suspend fun updateLocalData(): List<Gym> {
        val res = getGymsFromRemoteUseCase()
        val favoriteGyms = getFavoriteGymsUseCase()
        addGymsToLocalUseCase(res)
        updateAllGymsUseCase(
            favoriteGyms.map { GymFavoriteState(id = it.id, true) }
        )
        return getGymsFromLocalUseCase()
    }

    fun updateFavoriteItems(gymId: Int, currentFavoriteState: Boolean) {
        viewModelScope.launch {
            val updatedList = toggleFavoriteGym(gymId, !currentFavoriteState)
            withContext(Dispatchers.Main) {
                _state.value = DataState.Success(updatedList)
            }
        }
    }

    private suspend fun toggleFavoriteGym(gymId: Int, currentFavoriteState: Boolean) =
        withContext(Dispatchers.IO) {
            updateFavoriteGymUseCase(GymFavoriteState(gymId, currentFavoriteState))
            return@withContext getGymsFromLocalUseCase()
        }

    private val errorHandle = CoroutineExceptionHandler { _, throwable ->
        throwable.printStackTrace()
    }

}