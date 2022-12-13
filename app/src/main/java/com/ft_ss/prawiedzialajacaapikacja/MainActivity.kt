package com.ft_ss.prawiedzialajacaapikacja

import androidx.appcompat.app.AppCompatActivity
import android.app.DatePickerDialog
import android.os.Bundle
import android.provider.ContactsContract.Data
import android.view.View
import android.widget.RadioButton
import android.widget.Button
import android.widget.CalendarView
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.get
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Date

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var licz = 0
        var rb1click = 0
        var rb2click = 0
        var zatwclick = 0
        var Date = mutableListOf<Int>(0,0,0);
        val rb1 = findViewById<RadioButton>(R.id.rb1);
        val rb2 = findViewById<RadioButton>(R.id.rb2);
        val zatwierdz = findViewById<Button>(R.id.Zatwierdz);
        val calendar = findViewById<CalendarView>(R.id.calendarView)
        val text = findViewById<TextView>(R.id.textView)
        var DataWy = mutableListOf<Int>(0,0,0);
        var DataPrzy = mutableListOf<Int>(1000000,100000,100000);
        val f1 = SimpleDateFormat("yyyy")
        val f2 = SimpleDateFormat("MM")
        val f3 = SimpleDateFormat("dd")
        val mCalendar = Calendar.getInstance()
        Date[0] = f1.format(Date()).toInt()
        Date[1] = f2.format(Date()).toInt() -1
        Date[2] = f3.format(Date()).toInt()
        calendar.setMinDate(Date().time)
        calendar.setMaxDate(Date().time + 63115200000)
        calendar.setMinDate((Date().getTime()))
            calendar.setOnDateChangeListener(
            CalendarView.OnDateChangeListener { view, year, month, dayOfMonth ->
                Date[0] = year
                Date[1] = month
                Date[2] = dayOfMonth
            })
        fun liczbadni(){
                var roznicalat = (DataPrzy[0] - DataWy[0]) * 365
                var roznicamies = (DataPrzy[1] - DataWy[1]) * 31
                var roznicadni = DataPrzy[2] - DataWy[2]
                var roznicawsumiedni = roznicalat + roznicamies + roznicadni
                if(DataWy[1]<=0 && (DataPrzy[1]>12 || DataPrzy[1]<0)) {
                text.text = "Wybierz daty!!"
            }
            else
            {
                if(DataPrzy[0] == 1000000) {
                    text.text = "Ustaw date przyjazdu"
                }
                else if(roznicawsumiedni <0){
                    text.text = "Data Wyjazdu nie może być po dacie przujazdu"
                }
                else if(roznicawsumiedni > 730)
                {
                    text.text = "Wycieczka nie może być dłuższa niż dwa lata!!11!"
                }
                else{
                    text.text = "Wyjazd będzie trwał: " + roznicawsumiedni.toString()
                }
            }
// rb1 -> zatwierdz -> rb2 -> zatwierdz
        }
        rb1.setOnClickListener {
            if (rb1click == 0) {
                findViewById<ImageView>(R.id.imageView2).visibility = View.INVISIBLE
                findViewById<TextView>(R.id.textView2).visibility = View.INVISIBLE
                findViewById<ImageView>(R.id.imageView4).visibility = View.VISIBLE
                findViewById<TextView>(R.id.textView4).visibility = View.VISIBLE
                rb1click = 1
            }
        }
        rb2.setOnClickListener {
            if (rb2click == 0) {
                findViewById<ImageView>(R.id.imageView3).visibility = View.INVISIBLE
                findViewById<TextView>(R.id.textView3).visibility = View.INVISIBLE
                findViewById<ImageView>(R.id.imageView4).visibility = View.VISIBLE
                findViewById<TextView>(R.id.textView4).visibility = View.VISIBLE
                rb2click = 1
            }
        }
        zatwierdz.setOnClickListener {
            if(zatwclick == 0 && rb1click == 1) {
                findViewById<ImageView>(R.id.imageView4).visibility = View.INVISIBLE
                findViewById<TextView>(R.id.textView4).visibility = View.INVISIBLE
                findViewById<ImageView>(R.id.imageView3).visibility = View.VISIBLE
                findViewById<TextView>(R.id.textView3).visibility = View.VISIBLE
                zatwclick= 1
            }
            else if(rb2click == 1){
                findViewById<TextView>(R.id.textView4).text = "Żeby zatwierdzić \n datę  przyjazdu\n  kliknij tu"
                findViewById<ImageView>(R.id.imageView4).visibility = View.INVISIBLE
                findViewById<TextView>(R.id.textView4).visibility = View.INVISIBLE
                findViewById<ImageView>(R.id.imageView3).visibility = View.INVISIBLE
                findViewById<TextView>(R.id.textView3).visibility = View.INVISIBLE
                findViewById<Button>(R.id.tutorial).visibility = View.VISIBLE
            }
            if (rb1.isChecked) {
                licz += 1
                for (i in 0..2) {
                    DataWy[i] = 0;
                }
                for (i in 0..2) {
                    DataWy[i] = Date[i];
                }
                rb1.text =
                    "Data Wyjazdu: " + DataWy[2].toString() + "/" + DataWy[1].toString() + "/" + DataWy[0].toString()
                liczbadni()
            } else if (rb2.isChecked) {
                licz += 1;
                for (i in 0..2) {
                    DataPrzy[i] = 100000000;
                }
                for (i in 0..2) {
                    DataPrzy[i] = Date[i]
                }
                rb2.text =
                    "Data Przyjazdu: " + DataPrzy[2].toString() + "/" + DataPrzy[1].toString() + "/" + DataPrzy[0].toString()
                liczbadni()
            }

            findViewById<Button>(R.id.tutorial).setOnClickListener{
                rb1click=0
                rb2click=0
                zatwclick=0
                findViewById<ImageView>(R.id.imageView2).visibility = View.VISIBLE
                findViewById<TextView>(R.id.textView2).visibility = View.VISIBLE
                findViewById<Button>(R.id.tutorial).visibility = View.INVISIBLE
            }
        }
    }
}