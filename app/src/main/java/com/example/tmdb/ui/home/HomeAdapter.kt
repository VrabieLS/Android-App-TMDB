package com.example.tmdb.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmdb.R
import com.example.tmdb.databinding.FragmentHomeBinding
import com.example.tmdb.model.Movie
import com.example.tmdb.network.RetrofitInstance.POSTER_BASE_URL
import kotlinx.android.synthetic.main.card_view.view.*

class HomeAdapter(private val movies: List<Movie>):
    RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    class HomeViewHolder(view : View) : RecyclerView.ViewHolder(view){
        fun bindMovie(movie : Movie){
            val title=movie.title +"-"+movie.releaseDate.substringBefore("-")
            itemView.movie_title.text = title
            itemView.movie_description.text=movie.overview
            System.out.println("aaaa "+movie.poster)
            Glide.with(itemView).load(POSTER_BASE_URL + movie.poster).into(itemView.movie_image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_view, parent, false))
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bindMovie(movies[position])
    }

    override fun getItemCount(): Int = movies.size
}