package com.fevzibagriacik.kotlinlessons.object_oriented_programming

class ClassB : MyInterface{
    override var variable: Int = 100

    override fun method1() {
        println("Method-1 runs")
    }

    override fun method2(): String {
        return "Method-2 runs"
    }

}