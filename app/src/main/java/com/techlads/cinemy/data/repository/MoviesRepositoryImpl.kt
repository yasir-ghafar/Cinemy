package com.techlads.cinemy.data.repository

import com.techlads.cinemy.domain.datasource.MoviesApi
import com.techlads.cinemy.domain.model.MoviesResponse
import com.techlads.cinemy.domain.repository.MoviesRepository
import retrofit2.Response

class MoviesRepositoryImpl(val api: MoviesApi): MoviesRepository {
    override suspend fun getNowPlayingMovies(page: Int): MoviesResponse =
        api.getNowPlayingMovies(page)
}