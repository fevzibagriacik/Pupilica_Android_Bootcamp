package com.fevzibagriacik.homework_4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.fevzibagriacik.homework_4.databinding.FragmentXPageBinding

class XPageFragment : Fragment() {
    private lateinit var binding: FragmentXPageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentXPageBinding.inflate(inflater, container, false)

        binding.buttonYFromX.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.toYFromX)
        }

        return binding.root
    }
}