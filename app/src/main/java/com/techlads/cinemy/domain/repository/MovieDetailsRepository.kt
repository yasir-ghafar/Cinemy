package com.techlads.cinemy.domain.repository

import com.techlads.cinemy.data.Resource
import com.techlads.cinemy.domain.model.Movie

interface MovieDetailsRepository {
    suspend fun getMovieById(movieId: Int): Resource<Movie>

    suspend fun getMovieCasts(movieId: Int)
}