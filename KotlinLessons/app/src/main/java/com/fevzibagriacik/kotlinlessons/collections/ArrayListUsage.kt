package com.fevzibagriacik.kotlinlessons.collections

fun main() {
    //Describing
    val fruits = ArrayList<String>()

    //Adding data : it adds end of the arraylist
    fruits.add("Apple") //0. index
    fruits.add("Banana") //1. index
    fruits.add("Cherry") //2. index
    println(fruits)

    //Update
    fruits[1] = "New Banana"
    println(fruits)

    //Insert : it adds index we want, shifts other values
    fruits.add(1, "Orange")
    println(fruits)

    //Read
    val f = fruits.get(3)
    println(f)
    println(fruits[3])

    println("Size: ${fruits.size}")

    fruits.reverse()
    println(fruits)

    for(f in fruits){
        println("Result: $f")
    }

    for((i,f) in fruits.withIndex()){
        println("$i -> $f")
    }

    //Remove
    fruits.removeAt(1)
    println(fruits)

    fruits.clear() //remove all of them
    println(fruits)
}