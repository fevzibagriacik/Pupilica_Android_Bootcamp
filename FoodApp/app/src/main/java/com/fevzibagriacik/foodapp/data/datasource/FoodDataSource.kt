package com.fevzibagriacik.foodapp.data.datasource

import android.util.Log
import com.fevzibagriacik.foodapp.data.entity.Food

class FoodDataSource {
    suspend fun save(foodName:String, foodPrice:String){
        val newFood = Food(0, foodName, foodPrice, "kebab")
        Log.e("Save", "$foodName - $foodPrice")
    }
}