package com.techlads.cinemy.presentation.screens.home


import SegmentedControl
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.google.accompanist.insets.statusBarsPadding
import com.techlads.cinemy.presentation.components.CinemyTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    navigateToDetails: () -> Unit
) {

    val items = listOf("Now Playing", "Coming Soon")
    LaunchedEffect(key1 = true) {
        viewModel.getNowPlayingMovies()
        //viewModel.getMovieGenres()
    }

    val nowPlayingMovies = viewModel.moviesResponseState.value.data?.collectAsLazyPagingItems()

    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {
            CinemyTopAppBar(
                title = "Star Movies",
                showBackButton = true,
            )
        },
        bottomBar = {
        }
    ) { innerPadding ->
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(innerPadding)) {

            Row(modifier = Modifier
                .wrapContentSize()
                .padding(horizontal = 8.dp)) {
                SegmentedControl(items = items, onItemSelection = {}, )
            }

            LazyVerticalStaggeredGrid(
                modifier = Modifier
                    .statusBarsPadding()
                    .padding(8.dp),
                verticalItemSpacing = 8.dp,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                columns = StaggeredGridCells.Adaptive(150.dp)) {
                if (nowPlayingMovies != null) {
                    items(nowPlayingMovies.itemCount) { index ->
                        nowPlayingMovies[index]?.let {
                            MovieListItem(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(220.dp),
                                movie = it,
                                movieGenre = it.genreIds[0].toString(),
                                onItemClick = {
                                    navigateToDetails()
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}