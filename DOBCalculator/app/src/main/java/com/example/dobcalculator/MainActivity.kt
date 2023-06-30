package com.example.dobcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbarVar: Toolbar = findViewById(R.id.toolbarId)
        setSupportActionBar(toolbarVar)
        getSupportActionBar()?.setTitle("AGE CALCULATOR")
    }
}