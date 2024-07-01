package com.example.homework1.hw1

class Crossover(
    brand: String,
    model: String,
    year: Int,
    enginePower: Int,
    country: String,
    drive: String,
    transmission: String
): Car(
    brand = brand,
    model = model,
    year = year,
    enginePower = enginePower,
    country = country) { }