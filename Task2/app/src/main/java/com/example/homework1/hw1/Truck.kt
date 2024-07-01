package com.example.homework1.hw1

class Truck(
    brand: String,
    model: String,
    year: Int,
    enginePower: Int,
    country: String,
    loadCapacity: Int,
    length: Int
): Car(
    brand = brand,
    model = model,
    year = year,
    enginePower = enginePower,
    country = country) { }