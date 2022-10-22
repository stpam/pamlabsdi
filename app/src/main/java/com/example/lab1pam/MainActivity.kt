package com.example.lab1pam

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var selectDate:TextView
    private lateinit var calcBtn:Button
    private lateinit var showAge:TextView
    private lateinit var dima:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        selectDate = findViewById(R.id.selectDate)
        calcBtn = findViewById(R.id.calsi)
        showAge = findViewById(R.id.showAge)


    }

    fun selectDate(view: View) {
        var c = Calendar.getInstance()
        var cDay = c.get(Calendar.DAY_OF_MONTH)
        var cMonth = c.get(Calendar.MONTH)
        var cYear = c.get(Calendar.YEAR)

        val calendarDialog = DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener {
                    view, year, month, dayOfMonth ->
                cDay = dayOfMonth
                cMonth = month
                cYear = year
                calcBtn.visibility = View.VISIBLE
                textMassge("Selectati data nasterii : $cDay/${cMonth}/$cYear")
                calcBtn.setOnClickListener {
                    val currentYear = Calendar.getInstance()
                        .get(Calendar.YEAR)
                    if (cYear>currentYear){
                        textMassge("Deocamdata nu v-ati născut")
                    }
                    else{
                        val age = currentYear - cYear
                        showAge.visibility = View.VISIBLE
                        showAge.text = " $age ani"

                        textMassge("Varsta calculată: $age ani")
                    }
                }
                selectDate.text = "Data : $cDay/${cMonth}/$cYear"
            },cYear,cMonth,cDay)
        calendarDialog.show()

    }

    private fun textMassge(s: String) {
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show()
    }



}