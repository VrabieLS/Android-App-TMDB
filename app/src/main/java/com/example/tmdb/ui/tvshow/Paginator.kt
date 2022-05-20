package com.example.tmdb.ui.tvshow

interface Paginator<Key,Item> {
    suspend fun loadNextItems()
    fun reset()
}