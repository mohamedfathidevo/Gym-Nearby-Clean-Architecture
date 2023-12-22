package com.mohamedfathidev.gymsnearby.presentation.GymsScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.wear.compose.material.ContentAlpha
import androidx.wear.compose.material.LocalContentAlpha
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import com.mohamedfathidev.gymsnearby.domain.entity.Gym
import com.mohamedfathidev.gymsnearby.domain.util.DataState
import com.mohamedfathidev.gymsnearby.ui.theme.Purple40

@Composable
fun GymsScreen(
    dataState: DataState,
    onFavoriteIconClick: (gymId: Int, currentFavoriteState: Boolean) -> Unit,
    onItemClick: (Int) -> Unit
) {
    when (dataState) {
        is DataState.Loading -> {
            CircularProgressIndicator()
        }

        is DataState.Success -> {
            LazyColumn() {
                items(items = dataState.data) { gym ->
                    GymItem(
                        gym = gym,
                        onFavoriteIconClick = { id, favState ->
                            onFavoriteIconClick(id, favState)
                        },
                        onItemClick = { id -> onItemClick(id) }
                    )
                }
            }
        }

        is DataState.Error -> {
            Text(text = dataState.exception?.message.toString())
        }
    }
}

@Composable
fun ShowGymScreen() {

}

@Composable
fun GymItem(
    gym: Gym,
    onFavoriteIconClick: (gymId: Int, currentFavoriteState: Boolean) -> Unit,
    onItemClick: (Int) -> Unit
) {
    val iconFav = if (gym.isFavorite) {
        Icons.Filled.Favorite
    } else {
        Icons.Filled.FavoriteBorder
    }
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        modifier = Modifier
            .padding(8.dp)
            .clickable { onItemClick(gym.id) },
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            DefaultIcon(Icons.Filled.Place, Modifier.weight(0.15f), "Gym Icon")
            GymDetails(gym.gymName, gym.gymLocation, Modifier.weight(0.70f))
            DefaultIcon(iconFav, Modifier.weight(0.15f), "Favorite Icon") {
                onFavoriteIconClick(gym.id, gym.isFavorite)
            }
        }
    }
}

@Composable
fun DefaultIcon(
    vector: ImageVector,
    modifier: Modifier,
    contentDescription: String,
    onClick: () -> Unit = {}
) {
    Image(
        imageVector = vector,
        contentDescription = contentDescription,
        modifier = modifier
            .padding(8.dp)
            .clickable {
                onClick()
            },
        colorFilter = ColorFilter.tint(
            Color.DarkGray
        )
    )
}

@Composable
fun GymDetails(
    gymName: String,
    gymAddress: String,
    modifier: Modifier,
    horizontalAlignment: Alignment.Horizontal = Alignment.Start
) {
    Column(modifier = modifier, horizontalAlignment = horizontalAlignment) {
        Text(
            text = gymName,
            style = MaterialTheme.typography.title2,
            color = Purple40
        )
        CompositionLocalProvider(
            LocalContentAlpha provides ContentAlpha.medium
        ) {
            Text(
                text = gymAddress,
                style = MaterialTheme.typography.body2,
                color = Color.DarkGray
            )
        }
    }
}