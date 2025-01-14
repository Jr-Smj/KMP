package com.example.kmpmovieapp.model

import kotlinx.serialization.Serializable

@Serializable
data class Movie(
    val Title: String,
    val Year: String,
    val imdbID: String,
    val Type: String,
    val Poster: String
)

@Serializable
data class MovieResponse(
    val Search: List<Movie> = emptyList(),
    val totalResults: String? = null,
    val Response: String
)
