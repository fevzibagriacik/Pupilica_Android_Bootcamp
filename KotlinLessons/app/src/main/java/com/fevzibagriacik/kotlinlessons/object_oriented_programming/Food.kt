package com.fevzibagriacik.kotlinlessons.object_oriented_programming

data class Food(var id:Int, var name:String, var price:Int) { //data provides some method automatically
    //Constructor - init function
    init{ //When object creates from the class, it works
        println("***Object is created.***")
    }

    fun getInfo(){
        println("------------------------")

        println("Id   : ${id}")
        println("Name : ${name}")
        println("Price: ${price}")
    }
    //this represents the class in which
    //super represents the upper class with inheritance
}