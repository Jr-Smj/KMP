package com.example.kmpmovieapp.viewmodel

import com.example.kmpmovieapp.model.Movie
import com.example.kmpmovieapp.service.MovieService
import kotlinx.coroutines.*

class MovieViewModel {
    private val movieService = MovieService()
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    var movies: List<Movie> = emptyList()
        private set

    fun search(query: String, onComplete: () -> Unit) {
        coroutineScope.launch {
            movies = movieService.searchMovies(query)
            onComplete()
        }
    }
}
