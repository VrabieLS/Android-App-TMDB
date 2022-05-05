package com.example.tmdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.navigation.findNavController
import com.example.tmdb.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    val TAG = "MainActivity"
    //test

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //binding.bottomNavigationView
        val navController=findNavController(R.id.fragmentContainerView)
        binding.bottomNavigationView.setOnItemSelectedListener(NavigationBarView.OnItemSelectedListener { item ->
            return@OnItemSelectedListener when(item.itemId){
                R.id.home -> {
                    navController.navigate(R.id.homeFragment)
                    true
                }
                R.id.movies -> {
                    navController.navigate(R.id.movieFragment)
                    true
                }
                R.id.tv_series -> {
                    navController.navigate(R.id.TVSeriesFragment)
                    true
                }
                else -> false
            }
            })
        Log.d(TAG , " aaaaaaasdasdsadasd")
    }
}