package com.fevzibagriacik.kotlinlessons.object_oriented_programming

fun main() {
    //nullable, null safety, optional(swift) - it is used in android programming languages.
    //null, NoN, nil
    //1- Describe
    var message:String? = null
    //message = "Hello"

    //Method-1
    //If there is not a problem, it runs; if there is a problem, it does not crush
    println("Case 1: ${message?.uppercase()}")

    //Method-2
    //If there is a problem, program errors
    //If you are sure this code, you can use it
    //println("Case 2: ${message!!.uppercase()}")

    //Method-3
    //null control
    if(message != null){
        println("There is not problem.")
    }
    else{
        println("There is a null expression.")
    }

    //null control
    //It represents the if control below but there is not else here
    message?.let{

    }
}