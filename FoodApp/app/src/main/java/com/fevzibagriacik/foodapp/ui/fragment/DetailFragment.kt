package com.fevzibagriacik.foodapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.fevzibagriacik.foodapp.databinding.FragmentDetailBinding
import com.fevzibagriacik.foodapp.ui.viewmodel.DetailViewModel

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private lateinit var viewModel : DetailViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)

        val bundle : DetailFragmentArgs by navArgs()
        val food = bundle.food

        binding.etName.setText(food.name)
        binding.etPrice.setText(food.price)

        binding.btnUpdate.setOnClickListener {
            val foodName = binding.etName.text.toString()
            val foodPrice = binding.etPrice.text.toString()
            update(food.id, foodName, foodPrice)
        }

        return binding.root
    }

    fun update(id:Int, name:String, price:String){
        Log.e("Update", "$id - $name - $price")
    }
}