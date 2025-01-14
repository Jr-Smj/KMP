package com.example.kmpmovieapp.service

import com.example.kmpmovieapp.model.Movie
import com.example.kmpmovieapp.model.MovieResponse
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class MovieService {
    private val client = HttpClient {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }
    }

    private val apiKey = "a1f45a02"

    suspend fun searchMovies(query: String): List<Movie> {
        val response: MovieResponse = client.get("https://www.omdbapi.com/") {
            parameter("apikey", apiKey)
            parameter("s", query)
        }
        return if (response.Response == "True") response.Search else emptyList()
    }
}
