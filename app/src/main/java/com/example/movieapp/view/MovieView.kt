package com.example.movieapp.view

import com.example.movieapp.model.MovieModel

interface MovieView {
    fun showMovie(movieModel: MovieModel)
    fun showError(error: String)
}