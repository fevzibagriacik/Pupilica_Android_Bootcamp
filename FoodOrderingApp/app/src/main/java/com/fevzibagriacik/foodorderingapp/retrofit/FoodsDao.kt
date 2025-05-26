package com.fevzibagriacik.foodorderingapp.retrofit

import com.fevzibagriacik.foodorderingapp.data.entity.YemeklerCevap
import retrofit2.http.GET

interface FoodsDao {
    @GET("yemekler/tumYemekleriGetir.php")
    suspend fun uploadFoods() : YemeklerCevap
}