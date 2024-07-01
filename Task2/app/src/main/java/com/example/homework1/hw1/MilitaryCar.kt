package com.example.homework1.hw1

class MilitaryCar(
    brand: String,
    model: String,
    year: Int,
    enginePower: Int,
    country: String,
    countOfGuns: Int,
    armor: Boolean
): Car(
    brand = brand,
    model = model,
    year = year,
    enginePower = enginePower,
    country = country) { }