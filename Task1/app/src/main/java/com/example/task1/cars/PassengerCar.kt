package com.example.task1.cars

class PassengerCar(
    name: String,
    model: String,
    yearOfRelease: Int,
    color: String,
    owner: String,
    var capacity: Int = 4
) :
    Car(
        name,
        model,
        yearOfRelease,
        color,
        owner
    ) {
}