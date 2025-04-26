package com.fevzibagriacik.kotlinlessons.object_oriented_programming

fun main() {
    val result = 5.multiple(2)
    val result2 = 5 sum 2
    println(result)
    println(result2)
}

fun Int.multiple(number:Int) : Int{
    return this * number
}

infix fun Int.sum(number:Int) : Int{
    return this + number
}