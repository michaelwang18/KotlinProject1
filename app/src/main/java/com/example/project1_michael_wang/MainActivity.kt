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
import kotlin.math.max

class MainActivity : AppCompatActivity(), View.OnClickListener  {
    private lateinit var startButton: Button
    private lateinit var num1: TextView
    private lateinit var num2: TextView
    private lateinit var scoredis: TextView
    private lateinit var strikedis: TextView
    private lateinit var flavor: TextView
    private lateinit var hardmode: TextView
    private lateinit var backing: androidx.appcompat.widget.LinearLayoutCompat
    private var score = 0;
    private var strike = 0;
    private var value1 = 0;
    private var value2 = 0;
    private var maxVal = 100;
    private var started = false;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startButton = findViewById(R.id.startB)
        num1 = findViewById(R.id.number1)
        num2 = findViewById(R.id.number2)
        scoredis = findViewById(R.id.score)
        strikedis = findViewById(R.id.strike)
        flavor = findViewById(R.id.flavorText)
        backing = findViewById(R.id.main)
        hardmode = findViewById(R.id.hardmode)

        startAndRestart();
        choosingNumber();
        hardmodeToggle()




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

            checkForEnd()
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
            checkForEnd()
        }



    }

    fun checkForEnd(){

       scoredis.text = "Score: $score"
        strikedis.text = "Strike: $strike"

        if (score >= 10){
            backing.setBackgroundColor(Color.parseColor("#e7ab7f"))
            started = !started
            startButton.text = if (started) "START" else "RESTART"
            //do toast thimg
        }
        if (strike >= 3){
            backing.setBackgroundColor(Color.parseColor("#7fa6c3"))
            started = !started
            startButton.text = if (started) "START" else "RESTART"
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
                flavor.text = "Press Start to Begin (Again)"

            } else {
                setValues()
                flavor.text = if (maxVal != 1000) "Turn on Hardmode for more fun" else "Have Fun"
            }
        }

    }

    fun setValues(){
        value1 =  ((Math.random() * maxVal) + 1).toInt()
        value2 =  ((Math.random() * maxVal) + 1).toInt()
        while (value2 == value1){ value2 =  ((Math.random() * 100) + 1).toInt()}
        num1.text = (value1).toString()
        num2.text = (value2).toString()

    }

    fun hardmodeToggle(){
        hardmode.setOnClickListener{
            maxVal = if (maxVal == 100) 1000 else 100

            if (maxVal == 1000 && started){
                flavor.text = "Have fun"
                hardmode.text = "Hardmode (On)"
            } else if (started)
            {
                flavor.text = "Turn on Hardmode for more fun"
                hardmode.text = "Hardmode (Off)"
            }

        }


    }





    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }





}