package com.example.tmdb.ui


interface Paginator<Key,Item> {
    suspend fun loadNextItems()
    fun reset()
}