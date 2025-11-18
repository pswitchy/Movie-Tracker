package com.example.movietracker.data.repository

import com.example.movietracker.data.network.ApiService
import javax.inject.Inject

class MovieRepository @Inject constructor(private val apiService: ApiService) {
    private val apiKey = com.example.movietracker.BuildConfig.TMDB_API_KEY

    suspend fun getPopularMovies() = apiService.getPopularMovies(apiKey)
    suspend fun getTopRatedMovies() = apiService.getTopRatedMovies(apiKey)
    suspend fun getUpcomingMovies() = apiService.getUpcomingMovies(apiKey)
    suspend fun getMovieDetails(movieId: Int) = apiService.getMovieDetails(movieId, apiKey)
}