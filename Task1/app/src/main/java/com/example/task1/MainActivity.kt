package com.example.task1
import com.example.task1.cars.*
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.doOnTextChanged

class MainActivity : AppCompatActivity() {
    private var startButton: Button? = null
    private var inputField: EditText? = null
    private var outputField: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        initViews()
        var intValue: Int = 0
        inputField?.doOnTextChanged { text, start, before, count ->
            intValue = text.toString().toInt()
            startButton?.setEnabled(true)
        }
        startButton?.setOnClickListener {
            race(intValue)
        }
    }
    fun initViews(){
        startButton = findViewById(R.id.start_button)
        inputField = findViewById(R.id.input_string)
        outputField = findViewById(R.id.output)
    }




    fun raceResult(c1: Car, c2: Car) = c1.yearOfRelease - c2.yearOfRelease
    fun createCars(numberOfCars: Int): MutableList<Car>{
        val cars:MutableList<Car> = ArrayList()
        for(i in 1..numberOfCars){
            cars.add(AutoBuilder("VAZ").setYearOfRelease((1900..2024).random()).setModel(i.toString()).build())
        }
        return cars
    }
    fun oneСircle(cars: MutableList<Car>): MutableList<Car>{
        val cars1: MutableList<Car>  = ArrayList()
        println("Новый круг начался")
        outputField?.append("Новый круг начался \n")
        while(cars.size > 1){
            val n1: Int = (0..<cars.size).random()
            val n2: Int = (0..<cars.size).random()
            if (n1 != n2){
                println("Гонка между машиной ${cars[n1].model} и машиной ${cars[n2].model}")
                outputField?.append("Гонка между машиной ${cars[n1].model} и машиной ${cars[n2].model}\n")
                if (raceResult(cars[n1], cars[n2]) > 0){
                    println("Машина ${cars[n1].model} победила")
                    outputField?.append("Машина ${cars[n1].model} победила\n")
                    cars1.add(cars[n1])
                    cars.removeAt(n2)
                    if (n1 > n2){
                        cars.removeAt(n1 - 1)
                    }
                    else{
                        cars.removeAt(n1)
                    }
                } else{
                    println("Машина ${cars[n2].model} победила")
                    outputField?.append("Машина ${cars[n2].model} победила\n")
                    cars1.add(cars[n2])
                    cars.removeAt(n1)
                    if (n2 > n1){
                        cars.removeAt(n2 - 1)
                    }
                    else{
                        cars.removeAt(n2)
                    }
                }
            }
        }
        if (cars.size == 1){
            println("Для ${cars[0]} не нашлось пары")
            outputField?.append("Для ${cars[0].model} не нашлось пары\n")
            cars1.add(cars[0])
        }
        println("круг окончен")
        outputField?.append("круг окончен\n")
        return cars1
    }
    fun race(numberOfCars: Int){
        if(numberOfCars>0) {
            var cars: MutableList<Car> = createCars(numberOfCars)
            while (cars.size > 1) {
                cars = oneСircle(cars)
            }
            println("${cars[0].model} машина выиграла")
            outputField?.append("${cars[0].model} машина выиграла\n")
        }else{
            println("гонка невозможна")
            outputField?.append("гонка невозможна\n")
        }
    }
}