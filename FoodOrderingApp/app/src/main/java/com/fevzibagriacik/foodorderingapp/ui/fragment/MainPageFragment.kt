package com.fevzibagriacik.foodorderingapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bumptech.glide.Glide
import com.fevzibagriacik.foodorderingapp.R
import com.fevzibagriacik.foodorderingapp.data.datasource.FoodDataSource
import com.fevzibagriacik.foodorderingapp.data.repo.FoodRepo
import com.fevzibagriacik.foodorderingapp.databinding.FragmentMainPageBinding
import com.fevzibagriacik.foodorderingapp.ui.adapter.FoodAdapter
import com.fevzibagriacik.foodorderingapp.ui.viewmodel.MainPageViewModel

class MainPageFragment : Fragment() {
    private lateinit var binding: FragmentMainPageBinding
    private lateinit var viewModel:MainPageViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainPageBinding.inflate(inflater, container, false)

        val dataSource = FoodDataSource()
        val repo = FoodRepo(dataSource)
        viewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return MainPageViewModel(repo) as T
            }
        }).get(MainPageViewModel::class.java)

        val adapter = FoodAdapter(requireContext(), listOf(), viewModel)
        binding.rvFoods.adapter = adapter
        binding.rvFoods.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        viewModel.foodList.observe(viewLifecycleOwner) { foods ->
            adapter.foodList = foods
            adapter.notifyDataSetChanged()
        }

        viewModel.uploadFoods()

        /*binding.svSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.search(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.search(query)
                return true
            }
        })*/

        binding.fabShop.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.toBasketFromMain)
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()

        viewModel.uploadFoods()
    }
}