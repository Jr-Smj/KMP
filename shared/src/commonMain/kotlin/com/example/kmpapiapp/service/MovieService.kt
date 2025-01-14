package com.example.kmpapiapp.service

import com.example.kmpmovieapp.model.Movie
import com.example.kmpapiapp.model.MovieResponse
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

    private val apiKey = "a1f45a02" // Zamień na swój klucz API

    suspend fun searchMovies(query: String): List<Movie> {
        // Zmieniamy z HttpResponse na odpowiedni typ
        val response: MovieResponse = client.get("https://www.omdbapi.com/") {
            parameter("apikey", apiKey)
            parameter("s", query)
        }.body()  // Używamy body(), aby przekonwertować HttpResponse na MovieResponse

        return if (response.Response == "True") response.Search else emptyList()
    }
}
