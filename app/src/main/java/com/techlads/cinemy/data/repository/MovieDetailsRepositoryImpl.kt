package com.techlads.cinemy.data.repository

import com.techlads.cinemy.data.Resource
import com.techlads.cinemy.domain.datasource.MoviesApi
import com.techlads.cinemy.domain.model.Movie
import com.techlads.cinemy.domain.repository.MovieDetailsRepository

class MovieDetailsRepositoryImpl(private val api: MoviesApi): MovieDetailsRepository {
    override suspend fun getMovieById(movieId: Int): Resource<Movie> {
        val response = try {
            api.getMovieById(movieId)

        } catch (e: Exception) {
            return Resource.Error("Unknown error occurred.")
        }
        return Resource.Success(response)
    }

    override suspend fun getMovieCasts(movieId: Int) { }
}