package com.fevzibagriacik.kotlinlessons.object_oriented_programming

fun main() {
    val f = Functions()

    //void
    f.hello1()

    //return
    val result= f.hello2()
    println("Result: $result")

    //parameter
    f.hello3("Zeynep")

    //overloading
    f.sum(10.0, 20.0, "Beyza")
    f.sum(10, 20)
}