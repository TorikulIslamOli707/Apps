package com.example.todolist

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.Dialog
import android.content.DialogInterface
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    lateinit var editTxtVar: EditText
    lateinit var addBtnVar: Button
    lateinit var listViewVar: ListView
    lateinit var selectDateVar: Button

    var listAr = ArrayList<String>()
    var helperClassObj = HelperClass()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolBar: Toolbar = findViewById(R.id.toolbarId)
        setSupportActionBar(toolBar)
        supportActionBar?.title = "TO DO LIST"

        editTxtVar = findViewById(R.id.editTxtId)
        addBtnVar = findViewById(R.id.addBtnId)
        listViewVar = findViewById(R.id.itemListId)
        selectDateVar = findViewById(R.id.selectDateBtn)

        listAr = helperClassObj.readData(this)

        var arrayAdp = ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, listAr)
        listViewVar.adapter = arrayAdp

        addBtnVar.setOnClickListener{
            var newItem = editTxtVar.text.toString()
            listAr.add(newItem)
            editTxtVar.setText("")

            helperClassObj.writeData(listAr, applicationContext)
            arrayAdp.notifyDataSetChanged()
        }

        listViewVar.setOnItemClickListener { adapterView, view, position, l ->
            var alert = AlertDialog.Builder(this)
            alert.setTitle("Delete")
            alert.setMessage("Do you want to delete this item")
            alert.setCancelable(false)
            alert.setNegativeButton("No") { dialogInterface, _ ->
                dialogInterface.cancel()

            }
            alert.setPositiveButton("Yes") { _, _ ->
                listAr.removeAt(position)
                arrayAdp.notifyDataSetChanged()
                helperClassObj.writeData(listAr, applicationContext)
            }

            alert.create().show()

        }

        selectDateVar.setOnClickListener{
            val calendarObj = Calendar.getInstance()
            val year = calendarObj.get(Calendar.YEAR)
            val month = calendarObj.get(Calendar.MONTH)
            val day = calendarObj.get(Calendar.DAY_OF_MONTH)

            DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener{view, year, month, dayOfMonth ->
                    Toast.makeText(this, "Date Selected", Toast.LENGTH_SHORT).show()
                },
                year,
                month,
                day
            ).show()


        }
    }
}