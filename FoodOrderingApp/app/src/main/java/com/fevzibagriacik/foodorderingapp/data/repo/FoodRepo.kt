package com.fevzibagriacik.foodorderingapp.data.repo

import android.util.Log
import com.fevzibagriacik.foodorderingapp.data.datasource.FoodDataSource
import com.fevzibagriacik.foodorderingapp.data.entity.CRUDCevap
import com.fevzibagriacik.foodorderingapp.data.entity.Yemekler
import com.fevzibagriacik.foodorderingapp.retrofit.ApiUtils

class FoodRepo(var foodDataSource:FoodDataSource) {
    suspend fun uploadFoods() : List<Yemekler>{
        val result = foodDataSource.uploadFoods()
        Log.e("Repo", result.size.toString())
        return result
    }


    suspend fun addFoodToBasket(foodName:String, foodImageName:String,
                                foodPrice:String, foodAmount:Int, userName:String) : CRUDCevap{
        val response = foodDataSource.addFoodToBasket(foodName, foodImageName, foodPrice,
            foodAmount, userName)

        return response
    }
}