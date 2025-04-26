package com.fevzibagriacik.kotlinlessons.standard_programming

fun main() {
    val age = 19

    if(age >= 20){
        println("You are adult.")
    }
    else{
        println("You are not adult.")
    }


    val userName = "admin"
    val n = 123456
    val n2 = 10

    if(userName == "admin" && n == 123456){ //Both of them must be true
        println("Welcome!")
    }
    else{
        println("Failed!")
    }

    if(n2 == 9 || n2 == 10){ //One of them must be true
        println("9 or 10")
    }
    else{
        println("not 9 or 10")
    }


    //Meaning of When is Switch in other languages.
    val number = 1

    when(number){
        1 -> {
            println("Number is 1")
        }
        2 -> println("Number is 2")
        else -> println("Not defined!")
    }
}