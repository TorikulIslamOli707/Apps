package com.example.tiktactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var btn1: Button
    lateinit var btn2: Button
    lateinit var btn3: Button
    lateinit var btn4: Button
    lateinit var btn5: Button
    lateinit var btn6: Button
    lateinit var btn7: Button
    lateinit var btn8: Button
    lateinit var btn9: Button
    var track = 0
    var count = 0

    lateinit var str1: String
    lateinit var str2: String
    lateinit var str3: String
    lateinit var str4: String
    lateinit var str5: String
    lateinit var str6: String
    lateinit var str7: String
    lateinit var str8: String
    lateinit var str9: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    fun init(){
        btn1 = findViewById(R.id.btn1Id)
        btn2 = findViewById(R.id.btn2Id)
        btn3 = findViewById(R.id.btn3Id)
        btn4 = findViewById(R.id.btn4Id)
        btn5 = findViewById(R.id.btn5Id)
        btn6 = findViewById(R.id.btn6Id)
        btn7 = findViewById(R.id.btn7Id)
        btn8 = findViewById(R.id.btn8Id)
        btn9 = findViewById(R.id.btn9Id)

    }
    fun clickFun(v: View){
        var btnView = v as Button

        if (btnView.getText().toString().equals("") ) {
            count++

            if (track == 0) {
                btnView.text = "X"
                track = 1
            } else {
                btnView.text = "0"
                track = 0
            }

            if (count > 4) {
                str1 = btn1.text.toString()
                str2 = btn2.text.toString()
                str3 = btn3.text.toString()
                str4 = btn4.text.toString()
                str5 = btn5.text.toString()
                str6 = btn6.text.toString()
                str7 = btn7.text.toString()
                str8 = btn8.text.toString()
                str9 = btn9.text.toString()

                if (str1 == str2 && str2.equals(str3) && !str1.equals("")) {
                    //1
                    Toast.makeText(this, "Winner is $str1", Toast.LENGTH_SHORT).show()

                } else if (str4.equals(str5) && str5.equals(str6) && !str4.equals("")) {
                    //2
                    Toast.makeText(this, "Winner is $str4", Toast.LENGTH_SHORT).show()
                } else if (str7.equals(str8) && str7.equals(str9) && !str7.equals("")) {
                    //3
                    Toast.makeText(this, "Winner is $str7", Toast.LENGTH_SHORT).show()
                } else if (str1.equals(str4) && str4.equals(str7) && !str1.equals("")) {
                    //4
                    Toast.makeText(this, "Winner is $str1", Toast.LENGTH_SHORT).show()
                } else if (str2.equals(str5) && str5.equals(str8) && !str2.equals("")) {
                    //5
                    Toast.makeText(this, "Winner is $str2", Toast.LENGTH_SHORT).show()
                } else if (str3.equals(str6) && str6.equals(str9) && !str3.equals("")) {
                    //6
                    Toast.makeText(this, "Winner is $str3", Toast.LENGTH_SHORT).show()
                } else if (str1.equals(str5) && str5.equals(str9) && !str1.equals("")) {
                    //7
                    Toast.makeText(this, "Winner is $str1", Toast.LENGTH_SHORT).show()
                } else if (str3.equals(str5) && str5.equals(str7) && !str3.equals("")) {
                    //8
                    Toast.makeText(this, "Winner is $str3", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}