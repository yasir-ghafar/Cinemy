package com.techlads.cinemy.domain.repository

import com.techlads.cinemy.domain.model.MoviesResponse
import retrofit2.Response
import java.util.concurrent.Flow

interface MoviesRepository {
    suspend fun getNowPlayingMovies(page: Int): MoviesResponse
}