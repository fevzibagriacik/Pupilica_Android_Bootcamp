package com.fevzibagriacik.kotlinlessons.object_oriented_programming

fun main() {
    calculateCost(CannedSize.MEDIUM, 10)
}

fun calculateCost(size:CannedSize, number:Int){
    when(size){
        CannedSize.SMALL -> println("Cost: ${number * 184} TL")
        CannedSize.MEDIUM -> println("Cost: ${number * 287} TL")
        CannedSize.LARGE -> println("Cost: ${number * 389} TL")
    }
}