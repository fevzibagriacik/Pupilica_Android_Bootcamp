package com.fevzibagriacik.foodorderingapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fevzibagriacik.foodorderingapp.data.entity.CRUDCevap
import com.fevzibagriacik.foodorderingapp.data.entity.Sepet_Yemekler
import com.fevzibagriacik.foodorderingapp.data.repo.FoodRepo
import com.fevzibagriacik.foodorderingapp.databinding.CardDesignBasketBinding
import kotlinx.coroutines.launch

class BasketViewModel(var foodRepo:FoodRepo) :ViewModel(){
    val basketFoodList = MutableLiveData<List<Sepet_Yemekler>>(emptyList())
    val basketFood = MutableLiveData<CRUDCevap>()

    init{
        uploadBasketFoods("Fevzi")
    }

    fun uploadBasketFoods(userName: String) {
        viewModelScope.launch {
            try {
                val basketFoods = foodRepo.uploadBasketFoods(userName)
                basketFoodList.value = basketFoods ?: emptyList()
            } catch (e: Exception) {
                basketFoodList.value = emptyList()
            }
        }
    }

    fun deleteBasketFood(basketFoodId:Int, userName:String){
        viewModelScope.launch {
            try {
                val deletedFood = foodRepo.deleteBasketFood(basketFoodId, userName)
                basketFood.value = deletedFood

                val updatedList = foodRepo.uploadBasketFoods(userName)
                basketFoodList.value = updatedList ?: emptyList()
            } catch (e: Exception) {
                basketFoodList.value = emptyList()
            }
        }
    }

    fun increaseAmount(food: Sepet_Yemekler) {
        val newAmount = food.yemek_siparis_adet + 1
        viewModelScope.launch {
            foodRepo.deleteBasketFood(food.sepet_yemek_id, "Fevzi")

            foodRepo.addFoodToBasket(
                foodName = food.yemek_adi,
                foodImageName = food.yemek_resim_adi,
                foodPrice = food.yemek_fiyat,
                foodAmount = newAmount,
                userName = "Fevzi"
            )

            uploadBasketFoods("Fevzi")
        }
    }


    fun decreaseAmount(food: Sepet_Yemekler) {
        if (food.yemek_siparis_adet > 1) {
            val newAmount = food.yemek_siparis_adet - 1
            viewModelScope.launch {
                foodRepo.deleteBasketFood(food.sepet_yemek_id.toInt(), "Fevzi")

                foodRepo.addFoodToBasket(
                    foodName = food.yemek_adi,
                    foodImageName = food.yemek_resim_adi,
                    foodPrice = food.yemek_fiyat,
                    foodAmount = newAmount,
                    userName = "Fevzi"
                )

                uploadBasketFoods("Fevzi")
            }
        }
    }
}