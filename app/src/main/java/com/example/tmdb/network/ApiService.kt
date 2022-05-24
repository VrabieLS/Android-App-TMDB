package com.example.tmdb.network

import com.example.tmdb.BuildConfig
import com.example.tmdb.model.Movie
import com.example.tmdb.api.MovieApi
import com.example.tmdb.model.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService: MovieApi {
    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("api_key") api: String = BuildConfig.API_KEY,
        @Query("page") page: Int = 1,
    ): Response<MovieResponse>
}