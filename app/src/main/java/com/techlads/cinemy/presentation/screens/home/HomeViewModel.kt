package com.techlads.cinemy.presentation.screens.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.techlads.cinemy.data.Resource
import com.techlads.cinemy.domain.model.HomeScreenState
import com.techlads.cinemy.domain.usecases.GetMoviesGenresUseCase
import com.techlads.cinemy.domain.usecases.GetNowPlayingMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCase: GetNowPlayingMoviesUseCase,
    private val genreUseCase: GetMoviesGenresUseCase,
) :
    ViewModel() {

    private val _moviesResponseState = mutableStateOf(HomeScreenState())
    val moviesResponseState: State<HomeScreenState> = _moviesResponseState


    fun getNowPlayingMovies() {
        _moviesResponseState.value = HomeScreenState(data = null, isLoading = true)
        viewModelScope.launch {
            _moviesResponseState.value = HomeScreenState(
                data = useCase.invoke().cachedIn(viewModelScope)
            )
        }
    }

    fun getMovieGenres() {
        viewModelScope.launch {
            when (val result = genreUseCase.invoke()) {
                is Resource.Success -> {
                    result.data?.genres!!.also {
                        _moviesResponseState.value = HomeScreenState(
                            movieGenres = it
                        )
                    }
                }

                is Resource.Error -> {}
                else -> {}
            }
        }
    }


    /*fun getMovieGenre(genreId: Int): String {
        if (moviesResponseState.value.movieGenres?.isNotEmpty() == true) {
            val genre = moviesResponseState.value.movieGenres!!.find { g -> g.id == genreId }
            return genre?.name ?: ""

        }
        return ""
    }*/
}