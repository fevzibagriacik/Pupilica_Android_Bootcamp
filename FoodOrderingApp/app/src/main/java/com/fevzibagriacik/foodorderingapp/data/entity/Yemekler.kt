package com.fevzibagriacik.foodorderingapp.data.entity

import java.io.Serializable

data class Yemekler(var yemek_id:Int, var yemek_adi:String, var yemek_resim_adi:String,
                    var fiyat:String, var puan:Int, var amount:Int = 1) : Serializable{
}