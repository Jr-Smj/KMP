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