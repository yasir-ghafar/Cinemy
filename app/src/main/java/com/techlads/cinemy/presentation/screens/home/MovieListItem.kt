package com.techlads.cinemy.presentation.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.techlads.cinemy.Constants
import com.techlads.cinemy.domain.model.Movie
import com.techlads.cinemy.presentation.components.CinemyImage
import com.techlads.cinemy.ui.theme.Shapes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieListItem(
    modifier: Modifier,
    movie: Movie,
    movieGenre: String,
    onItemClick: (Movie) -> Unit,
) {
    Card(
        modifier = modifier
            .wrapContentHeight()
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background,
        ),
        shape = Shapes.extraSmall,
        onClick = { onItemClick(movie) }
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {

            Box(
                modifier = Modifier.weight(1f)
            ) {
                CinemyImage(
                    modifier = Modifier.height(250.dp),
                    contentScale = ContentScale.Crop,
                    url = "${Constants.IMAGE_BASE_UR}/${movie.posterPath}",
                    contentDescription = movie.title
                )
            }

            Column {
                Text(
                    text = movie.title,
                    style = MaterialTheme.typography.titleSmall,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Start,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier
                )
            }
        }
    }
}