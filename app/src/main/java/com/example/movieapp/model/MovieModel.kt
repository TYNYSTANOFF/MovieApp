package com.example.movieapp.model

import com.google.gson.annotations.SerializedName

data class MovieModel(
@SerializedName("Title")
    val title: String,

@SerializedName("Year")
    val year: String,

@SerializedName("Released")
    val released: String,

@SerializedName("Runtime")
    val runtime: String,

@SerializedName("Genre")
    val genre: String,

@SerializedName("Director")
    val director: String,

@SerializedName("Writer")
    val writer: String,

@SerializedName("Actors")
    val actors: String,

@SerializedName("Plot")
    val plot: String,

@SerializedName("Awards")
    val awards: String,

@SerializedName("Poster")
    val poster: String,

@SerializedName("imdbRating")
    val rating: String

)