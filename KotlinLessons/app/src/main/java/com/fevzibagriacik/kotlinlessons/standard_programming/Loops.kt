package com.fevzibagriacik.kotlinlessons.standard_programming

fun main() {
    for(i in 1..3){ //Firstly enter min number and enter ".." and finally enter max number
        println("Loop 1: $i")
    }

    for(x in 10..20 step 5){ //Step is amount of increasing
        println("Loop 2: $x")
    }

    for(x in 20 downTo 10 step 5){ //Step is amount of decreasing for downTo use
        println("Loop3: $x")
    }


    var counter = 1
    while(counter < 4){
        println("Loop 4: $counter")
        counter++
    }


    for(i in 1..5){
        if(i == 3){
            continue //Pass when i=3
        }
        println("Loop 6: $i")
    }

    for(i in 1..5){
        if(i == 3){
            break //Finish when i=3
        }
        println("Loop 7: $i")
    }
}