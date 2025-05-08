package com.fevzibagriacik.moviesapp

import java.io.Serializable

data class Filmler(var id:Int,
                   var name:String,
                   var image:String,
                   var price:Int) : Serializable{
}