package com.example.tmdb.ui.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmdb.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding.apply {
            rv_movies_list.layoutManager=LinearLayoutManager(this@HomeFragment.context)
            val homeViewModel = ViewModelProvider(this@HomeFragment)[HomeViewModel::class.java]
            homeViewModel.movieLiveData.observe(viewLifecycleOwner) {
                rv_movies_list.adapter = HomeAdapter(it.movieList)
            }
            homeViewModel.fetchMovie()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}