package com.fevzibagriacik.homework_5

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private var number1 = 0
    private var currentNumber = ""
    private var sum = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button0 = findViewById<Button>(R.id.button0)
        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        val button4 = findViewById<Button>(R.id.button4)
        val button5 = findViewById<Button>(R.id.button5)
        val button6 = findViewById<Button>(R.id.button6)
        val button7 = findViewById<Button>(R.id.button7)
        val button8 = findViewById<Button>(R.id.button8)
        val button9 = findViewById<Button>(R.id.button9)
        val buttonSum = findViewById<Button>(R.id.buttonSum)
        val buttonEqual = findViewById<Button>(R.id.buttonEqual)
        val buttonClear = findViewById<Button>(R.id.buttonClear)
        val textViewCalculation = findViewById<TextView>(R.id.textViewCalculation)
        val textViewResult = findViewById<TextView>(R.id.textViewResult)

        button0.setOnClickListener{
            val button0Text = button0.text.toString()
            currentNumber = textViewCalculation.text.toString()
            textViewCalculation.text = currentNumber + button0Text
        }

        button1.setOnClickListener{
            val button1Text = button1.text.toString()
            currentNumber = textViewCalculation.text.toString()
            textViewCalculation.text = currentNumber + button1Text
        }

        button2.setOnClickListener{
            val button2Text = button2.text.toString()
            currentNumber = textViewCalculation.text.toString()
            textViewCalculation.text = currentNumber + button2Text
        }

        button3.setOnClickListener{
            val button3Text = button3.text.toString()
            currentNumber = textViewCalculation.text.toString()
            textViewCalculation.text = currentNumber + button3Text
        }

        button4.setOnClickListener{
            val button4Text = button4.text.toString()
            currentNumber = textViewCalculation.text.toString()
            textViewCalculation.text = currentNumber + button4Text
        }

        button5.setOnClickListener{
            val button5Text = button5.text.toString()
            currentNumber = textViewCalculation.text.toString()
            textViewCalculation.text = currentNumber + button5Text
        }

        button6.setOnClickListener{
            val button6Text = button6.text.toString()
            currentNumber = textViewCalculation.text.toString()
            textViewCalculation.text = currentNumber + button6Text
        }

        button7.setOnClickListener{
            val button7Text = button7.text.toString()
            currentNumber = textViewCalculation.text.toString()
            textViewCalculation.text = currentNumber + button7Text
        }

        button8.setOnClickListener{
            val button8Text = button8.text.toString()
            currentNumber = textViewCalculation.text.toString()
            textViewCalculation.text = currentNumber + button8Text
        }

        button9.setOnClickListener{
            val button9Text = button9.text.toString()
            currentNumber = textViewCalculation.text.toString()
            textViewCalculation.text = currentNumber + button9Text
        }

        buttonSum.setOnClickListener{
            val buttonSumText = buttonSum.text.toString()
            currentNumber = textViewCalculation.text.toString()
            if(currentNumber.last() != '+'){
                textViewCalculation.text = currentNumber + buttonSumText
            }
        }

        buttonClear.setOnClickListener{
            currentNumber = ""
            textViewResult.text = "0"
            textViewCalculation.text = currentNumber
        }

        buttonEqual.setOnClickListener{
            if(currentNumber.last() != '+'){
                sum = 0
                currentNumber = textViewCalculation.text.toString()
                val numbers = split(currentNumber)

                for(i in numbers){
                    sum += i
                }

                textViewResult.text = sum.toString()
                textViewCalculation.text = textViewResult.text
            }
        }
    }

    fun sum(number1:Int, number2:Int) : Int{
        val sum = number1 + number2
        return sum
    }

    fun split(text:String) : List<Int>{
        val stringList = text.split("+")
        val numberList = mutableListOf<Int>()
        var current = 0

        for(i in stringList){
            current = i.toInt()
            numberList.add(current)
        }

        return numberList
    }
}