package com.fevzibagriacik.homework_6.data.entity

import java.io.Serializable

data class Food(var food_id:Int, var foodName:String, var restaurantName:String,
    var picture:String, var deliveryTime:String, var price:String, var rate:String)
    : Serializable{
}