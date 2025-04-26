package com.fevzibagriacik.kotlinlessons.object_oriented_programming

class Homework2 {
    fun question1(celsius:Double) : Double{
        val f = celsius * 1.8 + 32
        return f
    }

    fun question2(edge1:Int, edge2:Int){
        val e = (edge1 * 2) + (edge2 * 2)
        println("Environment of rectangle: $e")
    }

    fun question3(number:Int) : Int{
        if(number == 0){
            return 1
        }
        return number * question3(number-1)
    }

    fun question4(word:String){
        var index = 0
        var counter = 0

        while(index < word.length){
            if(word[index] == 'a' || word[index] == 'A'){
                counter++
            }

            index++
        }

        println("How many are there 'a' or 'A': $counter")
    }

    fun question5(edgeNumber:Int) : Int{
        if(edgeNumber < 3){
            return 0
        }

        val sum = (edgeNumber - 2) * 180
        return sum
    }

    fun question6(dayNumber:Int) : Int{
        val normalHourPrice = 10
        val shiftHourPrice = 20
        var salary = 0

        val totalHour = dayNumber * 8

        if(totalHour > 160){
            salary = ((totalHour - 160) * shiftHourPrice) + (160 * normalHourPrice)
        }
        else{
            salary = totalHour * normalHourPrice
        }

        return salary
    }

    fun question7(quotaAmount:Int) : Int{
        var cost = 0
        if(quotaAmount > 50){
            cost = ((quotaAmount - 50)) * 4 + 100
        }
        else{
            cost = quotaAmount * 2
        }

        return cost
    }
}