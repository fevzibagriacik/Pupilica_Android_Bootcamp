package com.fevzibagriacik.foodapp.data.entity

import java.io.Serializable

data class Food(var id:Int, var name:String,
                var price:String, var image:String) : Serializable{
}