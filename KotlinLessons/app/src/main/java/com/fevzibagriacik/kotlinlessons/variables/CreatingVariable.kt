package com.fevzibagriacik.kotlinlessons.variables

fun main() {
    var id = 1
    var name = "jacket"
    var image = "jacket.png"
    var point = 4.7
    var price = 4500
    var hasStock = true

    println("Id: $id")
    println("Name: $name")
    println("Image: $image")
    println("Point: $point")
    println("Price: $price")
    println("HasStock: $hasStock")

    //Constant
    var number = 30 //It can be changeable
    number = 100
    println(number)

    val constant = 50 //It can not be changeable, increases the performance
    println(constant)

    //Type Casting
    //1-Number to number
    val d = 89.56
    val i = 34

    val result1 = d.toInt()
    val result2 = i.toDouble()

    println(result1)
    println(result2)

    //2-Number to string
    var x = 85
    val result3 = x.toString()
    println(result3)

    //3-String to number
    val text = "48"
    val text2 = "48T"

    val result4 = text.toInt()
    val result5 = text2.toIntOrNull()

    println(result4)

    if(result5 != null){
        println(result5)
    }
    else{
        println("Result5 is null")
    }
}