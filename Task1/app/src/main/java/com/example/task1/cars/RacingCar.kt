package com.example.task1.cars

class RacingCar(
    name: String,
    model: String,
    yearOfRelease: Int,
    color: String,
    owner: String,
    var maxSpeed: Int = 90,
) :
    Car(
        name,
        model,
        yearOfRelease,
        color,
        owner
    ) {
}