package com.mohamedfathidev.gymsnearby.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.mohamedfathidev.gymsnearby.presentation.DetailsScreen.GymDetailsScreen
import com.mohamedfathidev.gymsnearby.presentation.GymsScreen.GymViewModel
import com.mohamedfathidev.gymsnearby.presentation.GymsScreen.GymsScreen
import com.mohamedfathidev.gymsnearby.ui.theme.GymsNearbyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GymsNearbyTheme {
                GymsNearbyApp()
            }
        }
    }
}

@Composable
fun GymsNearbyApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "gyms") {
        composable(route = "gyms") {
            val gymsViewModel: GymViewModel = hiltViewModel()
            GymsScreen(
                dataState = gymsViewModel.state.value,
                onFavoriteIconClick = { id, currentState ->
                    gymsViewModel.updateFavoriteItems(
                        id,
                        currentState
                    )
                },
                onItemClick = { navController.navigate("gyms/$it") }
            )
        }
        composable(route = "gyms/{gym_id}",
            arguments = listOf(
                navArgument("gym_id") {
                    type = NavType.IntType
                }
            )
        ) {
            GymDetailsScreen()
        }
    }
}