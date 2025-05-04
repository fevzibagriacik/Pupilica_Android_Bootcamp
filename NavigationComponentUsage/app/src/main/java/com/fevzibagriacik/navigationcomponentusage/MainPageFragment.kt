package com.fevzibagriacik.navigationcomponentusage

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.fevzibagriacik.navigationcomponentusage.databinding.FragmentMainPageBinding

class MainPageFragment : Fragment() {
    private lateinit var binding: FragmentMainPageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainPageBinding.inflate(inflater, container, false)

        binding.buttonDetail.setOnClickListener{
            val transition = MainPageFragmentDirections.toDetail(message = "How are you?", number = 99)
            Navigation.findNavController(it).navigate(transition) //itself
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //When we run the app, just it runs one time
        Log.e("Lifecycle", "onCreate")
    }

    override fun onResume() {
        super.onResume()
        //When page every appears, it runs
        //When return the this page, it runs
        Log.e("Lifecycle", "onResume")
    }

    override fun onPause() {
        super.onPause()
        //When page every disappears, it runs
        Log.e("Lifecycle", "onPause")
    }
}