package com.techlads.cinemy.domain.repository

import com.techlads.cinemy.data.Resource
import com.techlads.cinemy.domain.model.GenresResponse

interface GenresRepository {
    suspend fun getMovieGenres(): Resource<GenresResponse>
}