package com.fevzibagriacik.foodorderingapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fevzibagriacik.foodorderingapp.data.entity.Sepet_Yemekler
import com.fevzibagriacik.foodorderingapp.data.repo.FoodRepo
import kotlinx.coroutines.launch

class BasketViewModel(var foodRepo:FoodRepo) :ViewModel(){
    val basketFoodList = MutableLiveData<List<Sepet_Yemekler>>()

    init{
        uploadBasketFoods("Fevzi")
    }

    fun uploadBasketFoods(userName:String){
        viewModelScope.launch{
            val basketFoods = foodRepo.uploadBasketFoods(userName)
            basketFoodList.value = basketFoods
        }
    }
}