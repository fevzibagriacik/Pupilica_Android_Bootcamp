package com.fevzibagriacik.kotlinlessons.object_oriented_programming

fun main() {
    //Creating object
    val f1 = Food(100, "meatball", 249)
    val f2 = Food(200, "baklava", 300)

    f1.price = 350
    f2.id = 150

    println("------------------------")

    println("Id   : ${f1.id}")
    println("Name : ${f1.name}")
    println("Price: ${f1.price}")

    println("------------------------")

    println("Id   : ${f2.id}")
    println("Name : ${f2.name}")
    println("Price: ${f2.price}")

    f1.getInfo()
    f2.getInfo()
}