package com.example.task1.cars

open class Car(
    var name: String = "unknown name",
    var model: String = "unknown model",
    var yearOfRelease: Int = -1,
    var color: String = "unknown color",
    var owner: String = "unknown owner"
) {
    fun carInfo() = "$color $name $model $yearOfRelease, $owner"
}