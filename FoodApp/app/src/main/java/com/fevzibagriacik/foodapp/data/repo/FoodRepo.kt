package com.fevzibagriacik.foodapp.data.repo

import android.util.Log
import com.fevzibagriacik.foodapp.data.datasource.FoodDataSource
import com.fevzibagriacik.foodapp.data.entity.Food

class FoodRepo(var foodDataSource:FoodDataSource) {
    suspend fun save(foodName:String, foodPrice:String) =
        foodDataSource.save(foodName, foodPrice)
}