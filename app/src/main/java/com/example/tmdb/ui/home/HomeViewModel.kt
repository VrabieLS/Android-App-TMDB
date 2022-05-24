package com.example.tmdb.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import com.example.tmdb.model.MovieDetails
import com.example.tmdb.model.MovieResponse
import com.example.tmdb.network.RetrofitInstance
//import com.example.tmdb.ui.DefaultPaginator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class HomeViewModel : ViewModel() {

    val movieLiveData = MutableLiveData<MovieResponse>()


    fun fetchMovie() {
        viewModelScope.launch {
            val movie = withContext(Dispatchers.IO) {
            }

        }
    }
    fun getData(): Flow<PagingData<MovieDetails>> {
        return HomeRepository.getData()
    }
}