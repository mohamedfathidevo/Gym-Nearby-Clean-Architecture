package com.mohamedfathidev.gymsnearby.presentation.DetailsScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mohamedfathidev.gymsnearby.presentation.GymsScreen.DefaultIcon
import com.mohamedfathidev.gymsnearby.presentation.GymsScreen.GymDetails

@Composable
fun GymDetailsScreen(
) {
    val gymDetailsViewModel: GymDetailsViewModel = hiltViewModel()
    val item = gymDetailsViewModel.state
    item.let {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            DefaultIcon(
                vector = Icons.Filled.Place,
                modifier = Modifier.padding(top = 32.dp, bottom = 32.dp),
                contentDescription = "Location Icon"
            )
            GymDetails(
                gymName = it.gymName,
                gymAddress = it.gymLocation,
                modifier = Modifier.padding(32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            )
            Text(
                text = if (it.isOpen) "Gym is open" else "Gym is closed",
                color = if (it.isOpen) Color.Green else Color.Red
            )
        }
    }
}