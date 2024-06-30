package com.example.task1

import com.example.task1.cars.*

class AutoBuilder(name: String) {
    private var car:Car = Car(name = name)
    fun setModel(model:String): AutoBuilder {
        car.model = model
        return this
    }
    fun setYearOfRelease(yearOfRelease: Int): AutoBuilder {
        car.yearOfRelease = yearOfRelease
        return this
    }
    fun setColor(color: String): AutoBuilder {
        car.color = color
        return this
    }
    fun setOwner(owner: String): AutoBuilder {
        car.owner = owner
        return this
    }
    fun setWheelsRadius(wheelsRadius: Int): AutoBuilder {
        val jeep: Jeep = Jeep(model = car.model, name = car.name, yearOfRelease = car.yearOfRelease, color = car.color, owner = car.owner, wheelsRadius = wheelsRadius)
        car = jeep
        return this
    }
    fun setCargoWeight(cargoWeight: Int): AutoBuilder {
        val truckCar: TruckCar = TruckCar(model = car.model, name = car.name, yearOfRelease = car.yearOfRelease, color = car.color, owner = car.owner, cargoWeight = cargoWeight)
        car = truckCar
        return this
    }
    fun setMaxSpeed(maxSpeed: Int) : AutoBuilder {
        val racingCar: RacingCar = RacingCar(model = car.model, name = car.name, yearOfRelease = car.yearOfRelease, color = car.color, owner = car.owner, maxSpeed = maxSpeed)
        car = racingCar
        return this
    }
    fun setCapacity(capacity: Int) : AutoBuilder {
        val passengerCar: PassengerCar = PassengerCar(model = car.model, name = car.name, yearOfRelease = car.yearOfRelease, color = car.color, owner = car.owner, capacity = capacity)
        car = passengerCar
        return this
    }
    fun build() = car
}