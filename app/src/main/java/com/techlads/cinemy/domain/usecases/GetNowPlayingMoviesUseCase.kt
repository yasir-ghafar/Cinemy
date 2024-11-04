package com.techlads.cinemy.domain.usecases

import androidx.paging.*
import com.techlads.cinemy.domain.model.Movie
import com.techlads.cinemy.domain.model.MoviesResponse
import com.techlads.cinemy.domain.paging.NowPlayingMovieSource
import com.techlads.cinemy.domain.repository.MoviesRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetNowPlayingMoviesUseCase @Inject constructor(
    private val repository: MoviesRepository
) {
    fun invoke(): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(enablePlaceholders = false, pageSize = 24),
            pagingSourceFactory = {
                NowPlayingMovieSource(repository)
            }
        ).flow
    }
}
