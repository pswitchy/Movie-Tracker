package com.example.movietracker.ui.moviedetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movietracker.data.models.Movie
import com.example.movietracker.data.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val movieRepository: MovieRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _movie = MutableStateFlow<Movie?>(null)
    val movie: StateFlow<Movie?> = _movie

    init {
        val movieId = savedStateHandle.get<String>("movieId")?.toIntOrNull()
        if (movieId != null) {
            getMovieDetails(movieId)
        }
    }

    private fun getMovieDetails(movieId: Int) {
        viewModelScope.launch {
            _movie.value = movieRepository.getMovieDetails(movieId)
        }
    }
}