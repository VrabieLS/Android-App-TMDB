package com.example.tmdb.api

import com.example.tmdb.model.Movie
import com.example.tmdb.model.MovieResponse

interface MovieApi {
    suspend fun getMovies(page:Int):MovieResponse
    suspend fun getMovieDetails():Movie
}