package com.example.tmdb.network

import com.example.tmdb.model.Movie
import com.example.tmdb.api.MovieApi
import com.example.tmdb.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiService: MovieApi {
    @GET("/3/movie/top_rated")
    override suspend fun getMovies(@Query("page")page:Int):MovieResponse
    @GET("/3/movie/760868?api_key=43d99e9835a01d2ab7a821edc63c0ec1")
    override suspend fun getMovieDetails(): Movie
}