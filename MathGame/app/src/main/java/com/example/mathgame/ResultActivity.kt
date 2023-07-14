package com.example.mathgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton

class ResultActivity : AppCompatActivity() {
    lateinit var scoreTxtVar: TextView
    lateinit var playAgainBtnVar: AppCompatButton
    lateinit var exitBtnVar: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        scoreTxtVar = findViewById(R.id.finalScoreTxtId)
        playAgainBtnVar = findViewById(R.id.playAgainBtnId)
        exitBtnVar = findViewById(R.id.exitBtnId)

        val finalScore = intent.getIntExtra("score", 0)
        scoreTxtVar.text = "YOUR FINAL SCORE IS $finalScore"

        playAgainBtnVar.setOnClickListener{
            val intent = Intent(this@ResultActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        exitBtnVar.setOnClickListener{
            val intent = Intent(Intent.ACTION_MAIN)
            intent.addCategory(Intent.CATEGORY_HOME)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
    }
}