package com.fevzibagriacik.foodorderingapp.data.entity

import java.io.Serializable


data class Sepet_Yemekler(var sepet_yemek_id:Int, var yemek_adi:String,
    var yemek_resim_adi:String, var yemek_fiyat:String, var yemek_siparis_adet:Int,
    var kullanici_adi:String) : Serializable{
    
}