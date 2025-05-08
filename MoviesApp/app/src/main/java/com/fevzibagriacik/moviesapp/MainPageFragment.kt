package com.fevzibagriacik.moviesapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fevzibagriacik.moviesapp.databinding.FragmentMainPageBinding

class MainPageFragment : Fragment() {
    private lateinit var binding: FragmentMainPageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainPageBinding.inflate(inflater, container, false)



        return binding.root
    }
}