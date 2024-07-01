package com.example.homework1.hw1

open class Car (
    val brand: String,
    val model: String,
    val year: Int,
    val enginePower: Int,
    val country: String,
    private var carInfo: String = ""
) {
    init {
        carInfo = "$brand; $model: $year; $enginePower; $country"
    }
    open fun printInfo(){
        println(carInfo)
    }
}