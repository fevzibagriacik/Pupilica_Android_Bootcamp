package com.fevzibagriacik.foodorderingapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.fevzibagriacik.foodorderingapp.data.repo.FoodRepo

class BasketViewModel(var foodRepo:FoodRepo) :ViewModel(){
}