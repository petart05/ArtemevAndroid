package com.example.task1.cars

class Jeep(
    name: String,
    model: String,
    yearOfRelease: Int,
    color: String,
    owner: String,
    var wheelsRadius: Int = 25,
) :
    Car(
        name,
        model,
        yearOfRelease,
        color,
        owner
    ) {

}