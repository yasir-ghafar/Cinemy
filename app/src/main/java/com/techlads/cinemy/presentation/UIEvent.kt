package com.techlads.cinemy.presentation

sealed class UIEvent {

    data class FetchNowPlayingMovies(val genreId: Int): UIEvent()
    data class FetchMovieDetails(val movieId: Int): UIEvent()
}