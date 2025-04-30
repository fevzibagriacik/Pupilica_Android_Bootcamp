package com.fevzibagriacik.kotlinlessons.object_oriented_programming.inheritance

class Cat : Mammal() {
    override fun makeNoise() {
        // super.makeNoise() - represents super class (mammal)
        println("Miyav miyav")
    }
}