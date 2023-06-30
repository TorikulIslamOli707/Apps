package com.example.todolist
import android.content.Context
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

class HelperClass {
    val fileName = "listView.dat"

    fun writeData(item: ArrayList<String>, con: Context)
    {
        var fos: FileOutputStream = con.openFileOutput(fileName, Context.MODE_PRIVATE)

        var oas = ObjectOutputStream(fos)
        oas.writeObject(item)
        oas.close()
    }

    fun readData(con: Context): ArrayList<String>
    {
        var itemList: ArrayList<String>

        try{
            var frs: FileInputStream = con.openFileInput(fileName)
            var ors = ObjectInputStream(frs)
            itemList = ors.readObject() as ArrayList<String>
        }catch(e: FileNotFoundException){
            itemList = ArrayList()
        }


        return itemList
    }
}