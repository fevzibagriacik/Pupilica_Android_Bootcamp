package com.fevzibagriacik.moviesapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.fevzibagriacik.moviesapp.databinding.FragmentMainPageBinding

class MainPageFragment : Fragment() {
    private lateinit var binding: FragmentMainPageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainPageBinding.inflate(inflater, container, false)

        val moviesList = ArrayList<Filmler>()
        val m1 = Filmler(1,"Django","django",24)
        val m2 = Filmler(2,"Interstellar","interstellar",32)
        val m3 = Filmler(3,"Inception","inception",16)
        val m4 = Filmler(4,"The Hateful Eight","thehatefuleight",28)
        val m5 = Filmler(5,"The Pianist","thepianist",18)
        val m6 = Filmler(6,"Anadoluda","anadoluda",10)
        moviesList.add(m1)
        moviesList.add(m2)
        moviesList.add(m3)
        moviesList.add(m4)
        moviesList.add(m5)
        moviesList.add(m6)

        val moviesAdapter = MoviesAdapter(requireContext(), moviesList)
        binding.moviesRv.adapter = moviesAdapter

        binding.moviesRv.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        return binding.root
    }
}