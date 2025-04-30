package com.fevzibagriacik.kotlinlessons.object_oriented_programming.inheritance

fun main() {
    val animal = Animal()
    val mammal = Mammal()
    val cat = Cat()
    val dog = Dog()

    animal.makeNoise() // There is not inheritance here, animas has this function
    mammal.makeNoise() // There is an inheritance here from mammal
    cat.makeNoise() // There is an inheritance here, it manipulates the function for yourself
    dog.makeNoise() // There is an inheritance here, it manipulates the function for yourself
}