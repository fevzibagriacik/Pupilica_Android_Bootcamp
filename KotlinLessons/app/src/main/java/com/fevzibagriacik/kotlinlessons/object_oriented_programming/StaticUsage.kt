package com.fevzibagriacik.kotlinlessons.object_oriented_programming

fun main() {
    val a = ClassA()

    //Standard object oriented access
    //println(a.x)
    //a.method()

    //Virtual object - nameless object
    //println(ClassA().x) //First object
    //ClassA().method() //Second object

    //Static
    println(ClassA.x)
    println(ClassA.method())
}