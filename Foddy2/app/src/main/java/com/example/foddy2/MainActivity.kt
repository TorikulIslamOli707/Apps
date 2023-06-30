package com.example.foddy2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolBarVar: Toolbar = findViewById(R.id.toolBarId)
        setSupportActionBar(toolBarVar)
        supportActionBar?.title = "Kotlin Basic"
    }
}