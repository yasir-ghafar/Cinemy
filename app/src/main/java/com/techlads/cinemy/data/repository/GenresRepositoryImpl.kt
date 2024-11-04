package com.techlads.cinemy.data.repository

import com.techlads.cinemy.data.Resource
import com.techlads.cinemy.domain.datasource.MoviesApi
import com.techlads.cinemy.domain.model.GenresResponse
import com.techlads.cinemy.domain.repository.GenresRepository
import java.lang.Exception

class GenresRepositoryImpl(private val api: MoviesApi): GenresRepository {
    override suspend fun getMovieGenres(): Resource<GenresResponse> {
        val response = try {
            api.getMovieGenres()
        } catch (e: Exception) {
            return Resource.Error("Unknown error occurred.")
        }
        return Resource.Success(response)
    }

}