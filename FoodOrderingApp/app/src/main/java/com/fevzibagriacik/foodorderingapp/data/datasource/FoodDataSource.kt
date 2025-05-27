package com.fevzibagriacik.foodorderingapp.data.datasource

import android.util.Log
import com.fevzibagriacik.foodorderingapp.data.entity.CRUDCevap
import com.fevzibagriacik.foodorderingapp.data.entity.Sepet_Yemekler
import com.fevzibagriacik.foodorderingapp.data.entity.Yemekler
import com.fevzibagriacik.foodorderingapp.retrofit.ApiUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FoodDataSource() {
    suspend fun uploadFoods(): List<Yemekler> = withContext(Dispatchers.IO) {
        val fdao = ApiUtils.getFoodsDao()
        val foodsList = fdao.uploadFoods()
        val apiFoods = foodsList.yemekler

        val foodsWithPrice = apiFoods.map { food ->

            val price = when (food.yemek_adi) {
                "Ayran" -> "15"
                "Baklava" -> "70"
                "Fanta" -> "30"
                "Izgara Somon" -> "160"
                "Izgara Tavuk" -> "150"
                "Kadayıf" -> "80"
                "Kahve" -> "35"
                "Köfte" -> "110"
                "Lazanya" -> "200"
                "Makarna" -> "75"
                "Pizza" -> "170"
                "Su" -> "10"
                "Sütlaç" -> "60"
                "Tiramisu" -> "90"
                else -> "0"
            }
            food.fiyat = price

            val point = when(food.yemek_adi){
                "Ayran" -> 4
                "Baklava" -> 5
                "Fanta" -> 2
                "Izgara Somon" -> 3
                "Izgara Tavuk" -> 5
                "Kadayıf" -> 5
                "Kahve" -> 3
                "Köfte" ->1
                "Lazanya" -> 2
                "Makarna" -> 3
                "Pizza" -> 4
                "Su" -> 5
                "Sütlaç" -> 4
                "Tiramisu" -> 5
                else -> 0
            }
            food.puan = point

            food
        }


        return@withContext foodsWithPrice
    }

    suspend fun addFoodToBasket(foodName:String, foodImageName:String,
                                foodPrice:String, foodAmount:Int, userName:String) : CRUDCevap{
        val fdao = ApiUtils.getFoodsDao()
        val response = fdao.addFoodToBasket(foodName, foodImageName, foodPrice,
            foodAmount, userName)

        return response
    }

    suspend fun uploadBasketFoods(userName:String): List<Sepet_Yemekler> = withContext(Dispatchers.IO){
        val fdao = ApiUtils.getFoodsDao()
        val basketFoodList = fdao.uploadBasketFoods(userName)
        val apiFoods = basketFoodList.sepet_yemekler

        return@withContext apiFoods
    }
}