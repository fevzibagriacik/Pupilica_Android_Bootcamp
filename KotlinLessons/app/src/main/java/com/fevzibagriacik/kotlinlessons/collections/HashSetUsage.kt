package com.fevzibagriacik.kotlinlessons.collections

fun main() {
    //HashSet
    //Describe
    val fruits = HashSet<String>()
    //Any - contains all types, object class in java

    fruits.add("Apple")
    fruits.add("Banana")
    fruits.add("Cherry")
    println(fruits)

    //It can not same value
    fruits.add("Apple")
    println(fruits)

    println("Size: ${fruits.size}")

    val f = fruits.elementAt(2)
    println(f)

    for(f in fruits){
        println("Result: $f")
    }

    for((i,f) in fruits.withIndex()){
        println("$i -> $f")
    }

    fruits.remove("Apple")
    println(fruits)

    fruits.clear()
    println(fruits)

}