package com.example.tmdb.ui.movies.viewpager

import android.content.res.Resources
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tmdb.MainActivity
import com.example.tmdb.ui.movies.MoviesFragment
import com.example.tmdb.ui.tvshow.TVShowFragment

class PagerAdapter(fragmentActivity: MoviesFragment):FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> { NowPlayingFragment() }
            1 -> { PopularFragment() }
            2 -> { UpcomingFragment() }
            else -> {throw  Resources.NotFoundException("Position Not Found")}
        }
    }
}