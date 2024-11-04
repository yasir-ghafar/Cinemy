package com.techlads.cinemy.di

import com.techlads.cinemy.domain.repository.GenresRepository
import com.techlads.cinemy.domain.repository.MoviesRepository
import com.techlads.cinemy.domain.usecases.GetMoviesGenresUseCase
import com.techlads.cinemy.domain.usecases.GetNowPlayingMoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {


    @Singleton
    @Provides
    fun provideMoviesUseCase(repository: MoviesRepository): GetNowPlayingMoviesUseCase =
        GetNowPlayingMoviesUseCase(repository)

    @Singleton
    @Provides
    fun provideGenresUseCase(repository: GenresRepository): GetMoviesGenresUseCase =
        GetMoviesGenresUseCase(repository)
}