package com.example.tmdb.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tmdb.model.MovieResponse
import com.example.tmdb.network.RetrofitInstance
import com.example.tmdb.repository.DataRepository
//import com.example.applicationinternship.ui.DefaultPaginator
import com.example.tmdb.ui.ScreenState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel : ViewModel() {

    private val dataRepository= DataRepository(RetrofitInstance.getClient())
    val movieLiveData = MutableLiveData<MovieResponse>()


    fun fetchMovie() {
        viewModelScope.launch {
            val movie = withContext(Dispatchers.IO) {
                dataRepository.getMovies()
            }
            movieLiveData.value = movie
        }
    }
}