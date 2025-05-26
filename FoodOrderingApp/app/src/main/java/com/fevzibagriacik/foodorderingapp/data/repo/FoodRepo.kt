package com.fevzibagriacik.foodorderingapp.data.repo

import android.util.Log
import com.fevzibagriacik.foodorderingapp.data.datasource.FoodDataSource
import com.fevzibagriacik.foodorderingapp.data.entity.Yemekler

class FoodRepo(var foodDataSource:FoodDataSource) {
    suspend fun uploadFoods() : List<Yemekler>{
        val result = foodDataSource.uploadFoods()
        Log.e("Repo", result.size.toString())
        return result
    }
}