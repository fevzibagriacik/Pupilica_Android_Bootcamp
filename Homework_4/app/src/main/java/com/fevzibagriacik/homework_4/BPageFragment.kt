package com.fevzibagriacik.homework_4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.fevzibagriacik.homework_4.databinding.FragmentBPageBinding

class BPageFragment : Fragment() {
    private lateinit var binding: FragmentBPageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBPageBinding.inflate(inflater, container, false)

        binding.buttonYFromB.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.toYFromB)
        }

        return binding.root
    }
}