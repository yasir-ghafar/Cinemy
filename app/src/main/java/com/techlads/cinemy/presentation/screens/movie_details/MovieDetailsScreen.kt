package com.techlads.cinemy.presentation.screens.movie_details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.techlads.cinemy.domain.model.Movie
import com.techlads.cinemy.presentation.components.CinemyImage

@Composable
fun MovieDetailsScreen(
    viewModel: MovieDetailsViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = true) {
        viewModel.getMovieDetailsById(1039690)
    }

    val movie = viewModel.detailsScreenState.value.data
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        CinemyImage(
            url = movie,
            contentDescription = ""
        )
    }
}

