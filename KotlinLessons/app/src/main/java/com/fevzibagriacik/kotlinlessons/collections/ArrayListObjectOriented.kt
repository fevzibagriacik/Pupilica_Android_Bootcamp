package com.fevzibagriacik.kotlinlessons.collections

fun main() {
    val m1 = Movie(1, "Barbie", 50)
    val m2 = Movie(2, "Spiderman", 30)
    val m3 = Movie(3, "Django", 80)

    val movieList = ArrayList<Movie>()
    movieList.add(m1)
    movieList.add(m2)
    movieList.add(m3)

    for(m in movieList){
        println("${m.id}: ${m.name} ${m.price} TL")
    }

    //Sorting
    println("--------Increasing by Price--------")
    //Ascend - ASC
    val s1 = movieList.sortedWith(compareBy{it.price})
    for(m in s1){
        println("${m.id}: ${m.name} ${m.price} TL")
    }

    println("--------Decreasing by Price--------")
    //Descend - DESC
    val s2 = movieList.sortedWith(compareByDescending{it.price})
    for(m in s2){
        println("${m.id}: ${m.name} ${m.price} TL")
    }

    //Filter
    println("--------Filter--------")
    val f1 = movieList.filter { it.price > 40 && it.price < 60 }
    for(m in f1){
        println("${m.id}: ${m.name} ${m.price} TL")
    }

    //Filter-2
    println("--------Filter-2--------")
    val f2 = movieList.filter { it.name.contains("go") }
    for(m in f2){
        println("${m.id}: ${m.name} ${m.price} TL")
    }
}