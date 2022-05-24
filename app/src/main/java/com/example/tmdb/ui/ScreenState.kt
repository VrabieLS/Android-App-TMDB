package com.example.tmdb.ui

import com.example.tmdb.model.Movie

class ScreenState(
    val isLoading:Boolean =false,
    val items: List<Movie> = emptyList(),
    val error: String? =null,
    val endReached: Boolean=false,
    val page: Int =1
) {
}