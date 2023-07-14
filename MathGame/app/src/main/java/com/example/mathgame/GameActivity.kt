package com.example.mathgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.Toolbar
import java.util.Locale
import kotlin.random.Random

class GameActivity : AppCompatActivity() {
    lateinit var toolbarVar: Toolbar

    lateinit var scoreTxtVar: TextView
    lateinit var lifeTxtVar: TextView
    lateinit var timeTxtVar: TextView
    lateinit var questionTxtVar: TextView

    lateinit var answerEdTxtVar: EditText

    lateinit var okBtnVar: AppCompatButton
    lateinit var nextBtnVar: AppCompatButton

    var correctAnswer = 0
    var userScore = 0
    var userLife = 3

    lateinit var timer: CountDownTimer
    private val startTimerInMillis: Long = 60000
    var timeLeft: Long = startTimerInMillis

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        toolbarVar = findViewById(R.id.additionToolBarId)
        setSupportActionBar(toolbarVar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        scoreTxtVar = findViewById(R.id.scoreTxtId)
        lifeTxtVar = findViewById(R.id.lifeTxtId)
        timeTxtVar = findViewById(R.id.timeTxtId)
        questionTxtVar = findViewById(R.id.questionTxtId)
        answerEdTxtVar = findViewById(R.id.answerEdTxtId)
        okBtnVar = findViewById(R.id.okBtnId)
        nextBtnVar = findViewById(R.id.nextBtnId)

        gameContinue()

        answerEdTxtVar.setOnFocusChangeListener{view, hasFocus->
            if (hasFocus)
                answerEdTxtVar.hint = ""
        }

        okBtnVar.setOnClickListener{
            val userInput = answerEdTxtVar.text.toString()

            if (userInput == ""){
                Toast.makeText(
                    applicationContext,
                    "Please enter your answer!!",
                    Toast.LENGTH_SHORT).show()
            }else{
                pauseTimer()

                val checkAnswer = userInput.toInt() == correctAnswer

                if (checkAnswer){
                    questionTxtVar.text = "Congratulation, your answer is correct"
                    userScore += 10
                    scoreTxtVar.text = "$userScore"
                }else{
                    questionTxtVar.text = "Sorry, your answer is wrong."
                    userLife--
                    lifeTxtVar.text = "$userLife"
                }
            }
        }

        nextBtnVar.setOnClickListener{
            pauseTimer()
            resetTimer()

            answerEdTxtVar.setText("")

            if (userLife == 0) {
                val intent = Intent(this@GameActivity, ResultActivity::class.java)
                intent.putExtra("score", userScore)
                startActivity(intent)
                finish()
            }else{
                gameContinue()
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean{
        if (item.itemId == android.R.id.home){
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    fun gameContinue(){
        val firstNumber = Random.nextInt(0, 100)
        val secondNumber = Random.nextInt(0, 100)

        questionTxtVar.text = "$firstNumber + $secondNumber"
        correctAnswer = firstNumber + secondNumber

        startTimer()
    }

    fun startTimer(){
        timer = object: CountDownTimer(timeLeft, 1000){
            override fun onTick(p0: Long) {
                timeLeft = p0
                updateText()
            }

            override fun onFinish() {
                pauseTimer()
                resetTimer()
                updateText()

                userLife--
                lifeTxtVar.text = userLife.toString()
                questionTxtVar.text = "Sorry, the time is up."
            }

        }.start()
    }

    fun updateText(){
        val remainTime: Int = (timeLeft / 1000).toInt()
        timeTxtVar.text = String.format(Locale.getDefault(), "%02d", remainTime)
    }

    fun pauseTimer(){
        timer.cancel()
    }

    fun resetTimer(){
        timeLeft = startTimerInMillis
        updateText()
    }
}