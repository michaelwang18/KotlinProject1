package com.example.project1_michael_wang

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener  {
    private lateinit var startButton: Button;
    private lateinit var num1: TextView;
    private lateinit var num2: TextView;
    private var score = 0;
    private var strike = 0;
    private var started = false;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val startButton: Button = findViewById(R.id.startB)
        val num1: TextView = findViewById(R.id.number1)
        val num2: TextView = findViewById(R.id.number2)
        startAndRestart();
        choosingNumber();




    }

    private fun choosingNumber() {
        num1.setOnClickListener{
            if ( (num1.text) num2)

        }
        num2.setOnClickListener{


        }


    }


    fun startAndRestart(){

        startButton.setOnClickListener{

            started = !started
            startButton.text = if (started) "START" else "RESTART"

        }

    }

    fun setValues(){
        num1.text = 10.toString()
        num2.text = 40.toString()

    }





    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }





}