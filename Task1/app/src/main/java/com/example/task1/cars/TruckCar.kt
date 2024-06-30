package com.example.task1.cars

class TruckCar(
    name: String,
    model: String,
    yearOfRelease: Int,
    color: String,
    owner: String,
    var cargoWeight: Int = 0
) :
    Car(
        name,
        model,
        yearOfRelease,
        color,
        owner
    ) {
}