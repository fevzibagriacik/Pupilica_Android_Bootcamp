package com.fevzibagriacik.kotlinlessons.object_oriented_programming

fun main() {
    val h = Homework2()

    //Question-1
    val q1 = h.question1(10.0)
    println("Fahrenheit: $q1")

    //Question-2
    h.question2(10,20)

    //Question-3
    val q3 = h.question3(10)
    println("Factorial: $q3")

    //Question-4
    h.question4("Araba")

    //Question-5
    val q5 = h.question5(100)
    println("Sum of Interior Angles: $q5 degrees")

    //Question-6
    val q6 = h.question6(30)
    println("Salary: $q6 TL")

    //Question-7
    val q7 = h.question7(80)
    println("Cost: $q7 TL")
}