package com.fevzibagriacik.homework_6.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.fevzibagriacik.homework_6.R
import com.fevzibagriacik.homework_6.data.entity.Food
import com.fevzibagriacik.homework_6.databinding.FragmentMainPageBinding
import com.fevzibagriacik.homework_6.ui.adapter.FoodAdapter
import com.fevzibagriacik.homework_6.ui.viewmodel.MainPageViewModel

class MainPageFragment : Fragment() {
    private lateinit var binding: FragmentMainPageBinding
    private lateinit var viewModel:MainPageViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainPageBinding.inflate(inflater, container, false)

        val foodList = ArrayList<Food>()
        val f1 = Food(1, "Kebab", "Resit Usta",
            "kebab", "50", "300", "5.0")
        val f2 = Food(2, "Burger", "Jock Jock Necmi",
            "burger", "30", "200", "4.2")
        val f3 = Food(3, "Dondurma", "Emin Dondurma",
            "dondurma", "10", "80", "4.5")
        val f4 = Food(4, "Doner", "Esref Usta",
            "doner", "15", "70", "3.9")
        val f5 = Food(5, "Iskender", "Mehmut Usta",
            "iskender", "25", "180", "3.5")
        val f6 = Food(6, "Kunefe", "Arif Usta",
            "kunefe", "26", "100", "4.0")
        val f7 = Food(7, "Lahmacun", "Cabbar Usta",
            "lahmacun", "30", "150", "3.2")
        val f8 = Food(8, "Manti", "Memo Usta",
            "manti", "25", "90", "3.1")
        val f9 = Food(9, "Pide", "Ulas Usta",
            "pide", "2", "3", "1.0")

        foodList.add(f1)
        foodList.add(f2)
        foodList.add(f3)
        foodList.add(f4)
        foodList.add(f5)
        foodList.add(f6)
        foodList.add(f7)
        foodList.add(f8)
        foodList.add(f9)

        val foodAdapter = FoodAdapter(requireContext(), foodList)
        binding.rvMainPage.adapter = foodAdapter
        binding.rvMainPage.layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)

        binding.svSearch.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String): Boolean {
                search(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                search(query)
                return true
            }
        })

        return binding.root
    }

    fun search(word:String){
        Log.e("Search Food", word)
    }
}