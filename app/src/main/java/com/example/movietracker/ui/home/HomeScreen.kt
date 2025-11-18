package com.example.movietracker.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.movietracker.data.models.Movie

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    onMovieClick: (Movie) -> Unit
) {
    val popularMovies by viewModel.popularMovies.observeAsState(initial = emptyList())
    val topRatedMovies by viewModel.topRatedMovies.observeAsState(initial = emptyList())
    val upcomingMovies by viewModel.upcomingMovies.observeAsState(initial = emptyList())
    val isLoading by viewModel.isLoading.observeAsState(initial = true)

    if (isLoading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .verticalScroll(rememberScrollState())
        ) {
            MovieListSection(title = "Popular Movies", movies = popularMovies, onMovieClick = onMovieClick)
            MovieListSection(title = "Top Rated", movies = topRatedMovies, onMovieClick = onMovieClick)
            MovieListSection(title = "Upcoming", movies = upcomingMovies, onMovieClick = onMovieClick)
        }
    }
}

@Composable
fun MovieListSection(title: String, movies: List<Movie>, onMovieClick: (Movie) -> Unit) {
    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Spacer(modifier = Modifier.height(12.dp))
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(movies) { movie ->
                MovieCard(movie = movie, onMovieClick = onMovieClick)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieCard(movie: Movie, onMovieClick: (Movie) -> Unit) {
    Card(
        shape = RoundedCornerShape(12.dp),
        onClick = { onMovieClick(movie) }
    ) {
        Box(
            modifier = Modifier
                .width(150.dp)
                .height(225.dp)
        ) {
            AsyncImage(
                model = "https://image.tmdb.org/t/p/w500${movie.posterPath}",
                contentDescription = movie.title,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}