package com.fevzibagriacik.homework_4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.fevzibagriacik.homework_4.databinding.FragmentAPageBinding

class APageFragment : Fragment() {
    private lateinit var binding: FragmentAPageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAPageBinding.inflate(inflater, container, false)

        binding.buttonB.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.toB)
        }

        return binding.root
    }
}