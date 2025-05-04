package com.fevzibagriacik.navigationcomponentusage

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.navArgs
import com.fevzibagriacik.navigationcomponentusage.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)

        val bundle: DetailFragmentArgs by navArgs()
        val comingMessage = bundle.message
        val comingNumber = bundle.number

        binding.textViewResult.text = "$comingMessage - $comingNumber"

        val btnReturn = object : OnBackPressedCallback(true){ //back is not active
            override fun handleOnBackPressed() {
                Log.e("Detail Page", "Return is runs")
                isEnabled = false 
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, btnReturn)

        return binding.root
    }
}

