package com.fevzibagriacik.homework_4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.fevzibagriacik.homework_4.databinding.FragmentMainPageBinding

class MainPageFragment : Fragment() {
    private lateinit var binding: FragmentMainPageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainPageBinding.inflate(inflater, container, false)

        binding.buttonA.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.toA)
        }

        binding.buttonX.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.toX)
        }

        return binding.root
    }
}