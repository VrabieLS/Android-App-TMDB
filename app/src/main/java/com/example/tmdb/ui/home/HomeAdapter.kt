package com.example.tmdb.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.tmdb.R
import com.example.tmdb.model.Movie
import com.example.tmdb.model.MovieDetails
import androidx.recyclerview.widget.DiffUtil
import com.example.tmdb.databinding.CardViewBinding


class HomeAdapter():
   PagingDataAdapter<MovieDetails,HomeAdapter.HomeViewHolder>(differCallback) {

    var onItemClick: ((MovieDetails) -> Unit)? = null
    inner class HomeViewHolder(private var binding: CardViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieDetails?) {
            binding.item = movie
            binding.executePendingBindings()
        }

    }

    companion object {
        private val differCallback = object : DiffUtil.ItemCallback<MovieDetails>() {
            override fun areItemsTheSame(oldItem: MovieDetails, newItem: MovieDetails): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: MovieDetails, newItem: MovieDetails): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(
            CardViewBinding.inflate(LayoutInflater.from(parent.context))
        )

    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.itemView.setOnClickListener { onItemClick?.invoke(getItem(position)!!) }
    }
}

