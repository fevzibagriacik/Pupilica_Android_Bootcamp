package com.fevzibagriacik.foodorderingapp.ui.fragment

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.fevzibagriacik.foodorderingapp.R
import com.fevzibagriacik.foodorderingapp.data.datasource.FoodDataSource
import com.fevzibagriacik.foodorderingapp.data.repo.FoodRepo
import com.fevzibagriacik.foodorderingapp.databinding.FragmentBasketBinding
import com.fevzibagriacik.foodorderingapp.ui.adapter.BasketFoodAdapter
import com.fevzibagriacik.foodorderingapp.ui.adapter.FoodAdapter
import com.fevzibagriacik.foodorderingapp.ui.viewmodel.BasketViewModel
import com.fevzibagriacik.foodorderingapp.ui.viewmodel.MainPageViewModel

class BasketFragment : Fragment() {
    private lateinit var binding: FragmentBasketBinding
    private lateinit var viewModel:BasketViewModel
    private lateinit var adapter:BasketFoodAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBasketBinding.inflate(inflater, container, false)

        val dataSource = FoodDataSource()
        val repo = FoodRepo(dataSource)
        viewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return BasketViewModel(repo) as T
            }
        }).get(BasketViewModel::class.java)

        adapter = BasketFoodAdapter(requireContext(), viewModel)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)

        viewModel.basketFoodList.observe(viewLifecycleOwner) { foods ->
            adapter.foodList = foods ?: emptyList()
            adapter.notifyDataSetChanged()

            val totalPrice = foods?.sumOf{it.yemek_fiyat.toInt() * it.yemek_siparis_adet} ?: 0
            binding.tvBasketTotalPrice.text = "₺ $totalPrice"

            if (foods.isNullOrEmpty()) {
                binding.recyclerView.visibility = View.GONE
            } else {
                binding.recyclerView.visibility = View.VISIBLE
                adapter.foodList = foods
            }
        }

        viewModel.uploadBasketFoods("Fevzi")

        return binding.root
    }

}