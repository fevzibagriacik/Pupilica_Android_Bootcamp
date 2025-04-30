package com.fevzibagriacik.kotlinlessons.collections

fun main() {
    //HashMap likes JSON data model (key-value)
    //Map, Dictionary(Swift)
    //It likes Shared Preferences, DataStore, UserDefault(Swift)

    var cities = HashMap<Int, String>()

    cities.put(16, "Bursa")
    cities[34] = "Istabul"
    cities[6] = "Ankara"
    println(cities)

    cities[16] = "New Bursa"
    println(cities)

    val c1 = cities[6]
    println(c1)

    println("Size: ${cities.size}")

    for((key, value) in cities){
        println("$key -> $value")
    }

    cities.remove(34)
    println(cities)

    cities.clear()
    println(cities)
}