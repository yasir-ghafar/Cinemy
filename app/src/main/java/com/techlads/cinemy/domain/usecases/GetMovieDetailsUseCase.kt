package com.techlads.cinemy.domain.usecases

import com.techlads.cinemy.data.Resource
import com.techlads.cinemy.domain.model.Movie
import com.techlads.cinemy.domain.repository.MovieDetailsRepository
import javax.inject.Inject

class GetMovieDetailsUseCase @Inject constructor(
    private val repository: MovieDetailsRepository
) {
    suspend fun invoke(movieId: Int): Resource<Movie> = repository.getMovieById(movieId)
}