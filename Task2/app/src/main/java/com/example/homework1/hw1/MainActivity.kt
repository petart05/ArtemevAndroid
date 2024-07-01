package com.example.homework1.hw1

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.doOnTextChanged
import com.example.homework1.R
import com.example.homework1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var header: TextView? = null
    private var sendTextButton: Button? = null
    private var viewBinding: ActivityMainBinding? = null
    val numberRegex = Regex("-?\\d+")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding?.root)
        initViews2()
    }


    private fun initViews2() {
        viewBinding?.apply {
            carsEt.doOnTextChanged { text, start, before, count ->
                text?.let {
                    button.isEnabled = numberRegex.matches(text)
                }
            }
            button.setOnClickListener {
                val countCars = Integer.parseInt(carsEt.text.toString())
                val winner = startRacing(countCars)
                Toast.makeText(this@MainActivity, "Winner: ${winner.brand}", Toast.LENGTH_SHORT)
                    .show()

            }
        }
    }

    fun startRacing(numCars: Int): Car {
        val cars = mutableListOf<Car>()
        repeat(numCars) {
            val car = CarBuilder("$it")
                .setModel("Model$it")
                .setEnginePower(100 + it)
                .build()
            cars.add(car)
        }
        return raceCars(cars)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    fun raceCars(cars: List<Car>): Car {
        var roundCars = cars.toMutableList()
        var numOfRound = 0
        while (roundCars.size > 1) {
            println("Круг $numOfRound")
            var size = roundCars.size
            val winners = mutableListOf<Car>()
            var i = 0;
            while (i < size) {
                if (i + 1 < roundCars.size) {
                    val randomCar = (i + 1..<roundCars.size).random()
                    val winner = race(roundCars[i], roundCars[randomCar])
                    winners.add(winner)
                    println("${roundCars[i].brand} против ${roundCars[randomCar].brand} - Победитель: ${winner.brand}")
                    roundCars.remove(roundCars[i])
                    roundCars.remove(roundCars[randomCar - 1])
                    size -= 2
                } else {
                    winners.add(roundCars[i])
                    println("${roundCars[i].brand} - Нет пары, в следующий круг")
                    roundCars.remove(roundCars[i])
                    size--
                }

            }
            roundCars = winners
            numOfRound++
        }

        return roundCars.first()
    }

    fun race(car1: Car, car2: Car): Car {
        return if (car1.enginePower > car2.enginePower) car1 else car2
    }
}