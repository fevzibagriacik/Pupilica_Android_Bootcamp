package com.fevzibagriacik.personsapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.fevzibagriacik.personsapp.R
import com.fevzibagriacik.personsapp.data.entity.Kisiler
import com.fevzibagriacik.personsapp.databinding.FragmentMainPageBinding

class MainPageFragment : Fragment() {
    private lateinit var binding: FragmentMainPageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainPageBinding.inflate(inflater, container, false)

        binding.fab.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.toPersonRecord)
        }

        binding.buttonDetail.setOnClickListener{
            val person = Kisiler(1, "Ahmet", "1111")
            val transition = MainPageFragmentDirections.toPersonDetail(person = person)
            Navigation.findNavController(it).navigate(transition)
        }

        return binding.root
    }
}