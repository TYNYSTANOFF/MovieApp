package com.example.movieapp.presenter

import com.example.movieapp.model.MovieApi
import com.example.movieapp.model.MovieModel
import com.example.movieapp.view.MovieView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MoviePresenter @Inject constructor(private val api: MovieApi) {
lateinit var view: MovieView

    fun attachView(view: MovieView){
   this.view = view
    }

 fun getMovie(name:String = "Thor"){
     api.getFilm(name).enqueue(object :Callback<MovieModel>{
         override fun onResponse(call: Call<MovieModel>, response: Response<MovieModel>) {
             if (response.isSuccessful){
                 response.body()?.let {
                     view.showMovie(it)
                 }
             }
         }

         override fun onFailure(call: Call<MovieModel>, t: Throwable) {
             view.showError(t.message.toString())
         }

     })
 }
}