package com.example.tmdb.repository

import com.example.tmdb.api.MovieApi
import com.example.tmdb.model.Movie
import com.example.tmdb.model.MovieResponse
import com.example.tmdb.network.RetrofitInstance.PAGE

class DataRepository(private val moviesApi: MovieApi)
{
    suspend fun getMovies(): MovieResponse {
        return moviesApi.getMovies(PAGE)
    }
}