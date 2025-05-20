package com.fevzibagriacik.foodapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.fevzibagriacik.foodapp.data.entity.Food
import com.fevzibagriacik.foodapp.data.repo.FoodRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RecordViewModel(var foodRepo: FoodRepo) : ViewModel(){
    fun save(foodName:String, foodPrice:String){
        CoroutineScope(Dispatchers.Main).launch {
            foodRepo.save(foodName, foodPrice)
        }
    }
}