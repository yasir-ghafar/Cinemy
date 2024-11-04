package com.techlads.cinemy.presentation.screens.movie_details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.techlads.cinemy.data.Resource
import com.techlads.cinemy.domain.model.Genre
import com.techlads.cinemy.domain.model.Movie
import com.techlads.cinemy.domain.usecases.GetMovieDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val useCase: GetMovieDetailsUseCase
) : ViewModel() {
    private val _detailsScreenState = mutableStateOf(DetailScreenState())
    val detailsScreenState: State<DetailScreenState> = _detailsScreenState

    init {
        getMovieDetailsById(1039690)
    }

    fun getMovieDetailsById(movieId: Int) {
        _detailsScreenState.value = DetailScreenState(data = null, isLoading = true)
        viewModelScope.launch {
            when (val result = useCase.invoke(movieId)) {
                is Resource.Success -> {
                    _detailsScreenState.value =
                        DetailScreenState(data = result.data, isLoading = false)
                }

                is Resource.Error -> {
                    _detailsScreenState.value = DetailScreenState(
                        data = null,
                        isLoading = false,
                        errorMessage = result.message
                    )
                }

                is Resource.Loading -> {}
            }
        }
    }
}


data class DetailScreenState(
    val data: Movie? = null,
    val isLoading: Boolean = false,
    val hasError: Boolean = false,
    val errorMessage: String? = null
)