package com.example.mathgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var additionBtnVar: Button
    lateinit var subtractionBtnVar: Button
    lateinit var multiplicationBtnVar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        additionBtnVar = findViewById(R.id.additionBtnId)

        additionBtnVar.setOnClickListener{
            val intentVar = Intent(this@MainActivity, GameActivity::class.java)
            startActivity(intentVar)
        }
    }
}