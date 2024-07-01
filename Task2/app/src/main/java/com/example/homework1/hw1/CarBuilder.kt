package com.example.homework1.hw1

class CarBuilder(val brand: String) {
    private var model: String = ""
    private var year: Int = 0
    private var enginePower: Int = 0
    private var country: String = ""

    fun setModel(model: String): CarBuilder {
        this.model = model
        return this
    }

    fun setYear(year: Int): CarBuilder {
        this.year = year
        return this
    }
    fun setEnginePower(enginePower: Int): CarBuilder {
        this.enginePower = enginePower
        return this
    }
    fun setCountry(country: String): CarBuilder {
        this.country = country
        return this
    }

    fun build(): Car {
        return Car(brand, model, year, enginePower, country)
    }
}