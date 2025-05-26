package com.fevzibagriacik.foodorderingapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fevzibagriacik.foodorderingapp.R
import com.fevzibagriacik.foodorderingapp.databinding.FragmentBasketBinding
import com.fevzibagriacik.foodorderingapp.ui.viewmodel.BasketViewModel

class BasketFragment : Fragment() {
    private lateinit var binding: FragmentBasketBinding
    private lateinit var viewModel:BasketViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBasketBinding.inflate(inflater, container, false)



        return binding.root
    }
}