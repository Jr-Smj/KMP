package com.example.kmpapiapp.model

import com.example.kmpmovieapp.model.Movie
import kotlinx.serialization.Serializable

@Serializable
data class MovieResponse(
    val Search: List<Movie>,  // Lista filmów
    val Response: String      // Status odpowiedzi (np. "True" jeśli OK)
)
