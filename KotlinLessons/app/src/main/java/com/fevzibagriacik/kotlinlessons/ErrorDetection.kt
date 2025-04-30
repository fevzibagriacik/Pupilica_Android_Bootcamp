package com.fevzibagriacik.kotlinlessons

fun main() {
    //1-Compile error : While coding, it appears
    val number = 100
    //number = 50

    //2-Runtime error(exceptions) : While running, it appears
    val x = 10
    val y = 0

    //First row of error is description of error
    //Blue expression of error is row of error in code

    try{
        println("Result: ${x/y}")
        println("Process is completed.")
    }
    catch(e:Exception){
        println("Second number can not be zero!")
    }
}