package com.fevzibagriacik.foodorderingapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fevzibagriacik.foodorderingapp.data.entity.CRUDCevap
import com.fevzibagriacik.foodorderingapp.data.repo.FoodRepo
import kotlinx.coroutines.launch

class DetailViewModel(var foodRepo:FoodRepo) : ViewModel(){
    val newFood = MutableLiveData<CRUDCevap>()

    fun addFoodToBasket(foodName:String, foodImageName:String,
                        foodPrice:String, foodAmount:Int, userName:String){
        viewModelScope.launch {
            val response = foodRepo.addFoodToBasket(foodName, foodImageName,
                foodPrice, foodAmount, userName)

            newFood.value = response
        }
    }
}