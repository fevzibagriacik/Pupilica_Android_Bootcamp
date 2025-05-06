package com.fevzibagriacik.homework_4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fevzibagriacik.homework_4.databinding.FragmentYPageBinding

class YPageFragment : Fragment() {
    private lateinit var binding: FragmentYPageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentYPageBinding.inflate(inflater, container, false)
        return binding.root
    }
}