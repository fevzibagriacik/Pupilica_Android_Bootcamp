package com.fevzibagriacik.kotlinlessons.object_oriented_programming

class Functions {
    //void - just it does process
    fun hello1(){
        val result = "Hello Ahmet"
        println(result)
    }

    //return - it does data transfer and process
    fun hello2() : String{
        val result = "Hello Ahmet"
        return result
    }

    //parameter
    fun hello3(name:String){
        val result = "Hello $name"
        println(result)
    }

    //overloading - Using function has same name in a class
    fun sum(number1:Int, number2:Int){
        println("Sum: ${number1 + number2}")
    }

    fun sum(number1:Double, number2:Double, name:String){
        println("Sum: ${number1 + number2} - Person: $name")
    }
}