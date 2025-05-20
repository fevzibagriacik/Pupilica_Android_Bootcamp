package com.fevzibagriacik.foodapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.fevzibagriacik.foodapp.R
import com.fevzibagriacik.foodapp.data.entity.Food
import com.fevzibagriacik.foodapp.databinding.FragmentMainPageBinding
import com.fevzibagriacik.foodapp.ui.adapter.FoodAdapter
import com.fevzibagriacik.foodapp.ui.viewmodel.DetailViewModel
import com.fevzibagriacik.foodapp.ui.viewmodel.MainPageViewModel

class MainPageFragment : Fragment() {
    private lateinit var binding: FragmentMainPageBinding
    private lateinit var viewModel : MainPageViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainPageBinding.inflate(inflater, container, false)

        val foodList = ArrayList<Food>()

        val f1 = Food(1, "Adana Kebab", "350 ₺", "kebab")
        val f2 = Food(2, "Burger", "200 ₺", "burger")

        foodList.add(f1)
        foodList.add(f2)

        val foodAdapter = FoodAdapter(requireContext(), foodList)
        binding.rvMainPage.adapter = foodAdapter

        binding.rvMainPage.layoutManager = StaggeredGridLayoutManager(
            1, StaggeredGridLayoutManager.VERTICAL)

        binding.svSearch.setOnQueryTextListener(
            object : android.widget.SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(query: String): Boolean {
                    search(query)
                    return true
                }

                override fun onQueryTextChange(newText: String): Boolean {
                    search(newText)
                    return true
                }

            })

        binding.fabAdd.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.toRecord)
        }

        return binding.root
    }

    fun search(word:String){
        
    }
}