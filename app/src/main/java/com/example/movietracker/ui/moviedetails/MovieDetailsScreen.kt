package com.example.movietracker.ui.moviedetails

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.movietracker.ui.theme.MovieTrackerTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieDetailsScreen(
    viewModel: MovieDetailsViewModel = hiltViewModel(),
    onNavigateUp: () -> Unit
) {
    val movie = viewModel.movie.collectAsState().value

    MovieTrackerTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = movie?.title ?: "") },
                    navigationIcon = {
                        IconButton(onClick = onNavigateUp) {
                            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                        }
                    }
                )
            }
        ) { paddingValues ->
            if (movie != null) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .padding(16.dp)
                ) {
                    AsyncImage(
                        model = "https://image.tmdb.org/t/p/w500/${movie.posterPath}",
                        contentDescription = movie.title,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "Rating",
                            tint = Color.Yellow
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(text = "${movie.voteAverage}/10")
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = movie.overview)
                }
            } else {
                // Show a loading indicator
                CircularProgressIndicator()
            }
        }
    }
}
