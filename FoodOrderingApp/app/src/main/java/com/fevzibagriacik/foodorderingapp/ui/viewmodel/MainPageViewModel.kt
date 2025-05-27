package com.fevzibagriacik.foodorderingapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fevzibagriacik.foodorderingapp.data.entity.CRUDCevap
import com.fevzibagriacik.foodorderingapp.data.entity.Yemekler
import com.fevzibagriacik.foodorderingapp.data.repo.FoodRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainPageViewModel(var foodRepo:FoodRepo) : ViewModel(){
    val foodList = MutableLiveData<List<Yemekler>>()

    init {
        uploadFoods()
    }

    fun uploadFoods(){
        viewModelScope.launch {
            val foods = foodRepo.uploadFoods()
            Log.e("ViewModel", foods.size.toString())
            foodList.value = foods
        }
    }
}

