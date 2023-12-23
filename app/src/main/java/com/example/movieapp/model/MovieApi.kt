package com.example.movieapp.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi  {
//http://www.omdbapi.com/?apikey=b633a0e9&t=thor
    @GET("http://www.omdbapi.com/")
    fun getFilm(
    @Query ("t") name :String,
    @Query ("apikey") key :String ="b633a0e9"

    ): Call<MovieModel>
}