package com.example.kmpmovieapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kmpmovieapp.viewmodel.MovieViewModel

class MainActivity : AppCompatActivity() {

    private val movieViewModel = MovieViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val searchField: EditText = findViewById(R.id.searchField)
        val searchButton: Button = findViewById(R.id.searchButton)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)

        searchButton.setOnClickListener {
            val query = searchField.text.toString()
            if (query.isNotEmpty()) {
                movieViewModel.search(query) {
                    recyclerView.adapter = MovieAdapter(movieViewModel.movies)
                }
            }
        }
    }
}
