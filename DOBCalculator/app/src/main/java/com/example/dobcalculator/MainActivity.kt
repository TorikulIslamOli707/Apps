package com.example.dobcalculator

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import kotlin.math.round

class MainActivity : AppCompatActivity() {
    lateinit var selectDateVar: Button
    lateinit var selectedDateVar: TextView
    lateinit var ageShowVar: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbarVar: Toolbar = findViewById(R.id.toolbarId)
        setSupportActionBar(toolbarVar)
        supportActionBar?.title = "AGE CALCULATOR"

        selectDateVar = findViewById(R.id.selectDateId)
        selectedDateVar = findViewById(R.id.selectedDateId)
        ageShowVar = findViewById(R.id.ageShowId)

        selectDateVar.setOnClickListener{
            callCalendarFun()
        }
    }

    private fun callCalendarFun(){
        val calendarObj = Calendar.getInstance()
        val year = calendarObj.get(Calendar.YEAR)
        val month = calendarObj.get(Calendar.MONTH)
        val day = calendarObj.get(Calendar.DAY_OF_MONTH)

        val dpv =      DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener{view, selectedYear, selectedMonth, selectedDay ->
                //Toast.makeText(this,
                // "Date Picker worked", Toast.LENGTH_SHORT).show()
                val selectDate = "$selectedDay-$selectedMonth-$selectedYear"
                selectedDateVar.text = selectDate

                val day = round(day - selectedDay.toDouble())
                val month = round(month - selectedMonth.toDouble())
                val year = round(year - selectedYear.toDouble())

                ageShowVar.text = "${year.toInt()} Years/ ${month.toInt()} Months/ ${day.toInt()} Days"

            },
            year,
            month,
            day)

        dpv.datePicker.maxDate = System.currentTimeMillis()
        dpv.show()
    }
}