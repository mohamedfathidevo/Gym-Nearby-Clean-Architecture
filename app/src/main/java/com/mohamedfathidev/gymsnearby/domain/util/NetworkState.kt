package com.mohamedfathidev.gymsnearby.domain.util

sealed class NetworkState {
    data object Available : NetworkState()
    data object Unavailable : NetworkState()
}