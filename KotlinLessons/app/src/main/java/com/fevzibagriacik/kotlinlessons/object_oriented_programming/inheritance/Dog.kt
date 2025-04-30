package com.fevzibagriacik.kotlinlessons.object_oriented_programming.inheritance

class Dog : Mammal() {
    override fun makeNoise() {
        println("Hav hav")
    }
}