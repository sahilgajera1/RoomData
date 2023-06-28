package com.example.roomdataproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var database: StudentDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        database = Room.databaseBuilder(
            applicationContext,
            StudentDatabase::class.java,
            "studentDB")
            .build()


        GlobalScope.launch {
            database.studentDao().insertStudent(Student(0,"sahil",19, Date(),1))

        }

        database.studentDao().getAllStudents().observe(this) {
            android.util.Log.d("ROOM", "onCreate: $it")
        }

    }


}