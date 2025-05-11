package com.fevzibagriacik.homework_6.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.fevzibagriacik.homework_6.R
import com.fevzibagriacik.homework_6.databinding.FragmentDetailBinding
import com.fevzibagriacik.homework_6.ui.viewmodel.DetailViewModel

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private lateinit var viewModel:DetailViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)

        val bundle:DetailFragmentArgs by navArgs()
        val food = bundle.food

        binding.ivDetailFood.setImageResource(
                resources.getIdentifier(food.picture, "drawable", requireContext().packageName)
        )
        binding.tvDetailFoodName.text = food.foodName
        binding.tvDetailRestaurantName.text = food.restaurantName
        binding.tvDetailDeliveryTime.text = "${food.deliveryTime} min"
        binding.tvDetailPrice.text = "${food.price} ₺"
        binding.tvDetailRate.text = food.rate

        return binding.root


    }
}