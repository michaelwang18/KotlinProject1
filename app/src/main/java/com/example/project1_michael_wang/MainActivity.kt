package com.example.project1_michael_wang

import android.annotation.SuppressLint
import android.graphics.Color
import android.icu.text.TimeZoneFormat.ParseOption
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener  {
    private lateinit var startButton: Button
    private lateinit var num1: TextView
    private lateinit var num2: TextView
    private lateinit var backing: androidx.appcompat.widget.LinearLayoutCompat
    private var score = 0;
    private var strike = 0;
    private var value1 = 0;
    private var value2 = 0;
    private var started = false;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startButton = findViewById(R.id.startB)
        num1 = findViewById(R.id.number1)
        num2 = findViewById(R.id.number2)
        backing = findViewById(R.id.main)
        startAndRestart();
        choosingNumber();




    }

    private fun choosingNumber() {


        num1.setOnClickListener {
            if (started) {
                if (value1 > value2) {
                    score++
                    backing.setBackgroundColor(Color.parseColor("#73d43c"))

                } else {
                    strike++
                    backing.setBackgroundColor(Color.parseColor("#b64044"))
                }
                setValues()
            }
        }
        num2.setOnClickListener{
            if (started) {
                if (value1 < value2) {
                    score++;
                    backing.setBackgroundColor(Color.parseColor("#73d43c"))
                } else {
                    strike++
                    backing.setBackgroundColor(Color.parseColor("#b64044"))
                }
                setValues()
            }
        }


    }

    fun checkForEnd(){
        if (score >= 10){
            backing.setBackgroundColor(Color.parseColor("#e7ab7f"))
            //do toast thimg
        }
        if (strike >= 3){
            backing.setBackgroundColor(Color.parseColor("#7fa6c3"))

        }

    }


    fun startAndRestart(){

        startButton.setOnClickListener{

            started = !started
            startButton.text = if (started) "START" else "RESTART"

            if (!started){
                score = 0
                strike = 0
                backing.setBackgroundColor(Color.parseColor("#f0e67d"))

            } else {
                setValues()
            }
        }

    }

    fun setValues(){
        value1 =  ((Math.random() * 100) + 1).toInt()
        value2 =  ((Math.random() * 100) + 1).toInt()
        while (value2 == value1){ value2 =  ((Math.random() * 100) + 1).toInt()}
        num1.text = (value1).toString()
        num2.text = (value2).toString()

    }





    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }





}