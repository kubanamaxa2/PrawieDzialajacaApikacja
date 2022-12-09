package com.ft_ss.prawiedzialajacaapikacja

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Data
import android.view.View
import android.widget.RadioButton
import android.widget.Button
import android.widget.CalendarView
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
        var licz = 0;
        var Date = mutableListOf<Int>(0,0,0);
        val rb1 = findViewById<RadioButton>(R.id.rb1);
        val rb2 = findViewById<RadioButton>(R.id.rb2);
        val zatwierdz = findViewById<Button>(R.id.Zatwierdz);
        val calendar = findViewById<CalendarView>(R.id.calendarView);
        val text = findViewById<TextView>(R.id.textView)
        var DataWy = mutableListOf<Int>(0,0,0);
        var DataPrzy = mutableListOf<Int>(1000000,100000,100000);
        val f1 = SimpleDateFormat("yyyy")
        val f2 = SimpleDateFormat("MM")
        val f3 = SimpleDateFormat("dd")
        Date[0] = f1.format(Date()).toInt()
        Date[1] = f2.format(Date()).toInt() -1
        Date[2] = f3.format(Date()).toInt()
        val DateDis = mutableListOf<Int>(Date[0], Date[1], Date[2])
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
            var roznicalat2 = (DataWy[0] - DateDis[0]) * 365
            var roznicamies2 = (DataWy[1] - DateDis[1]) * 31
            var roznicadni2 = DataWy[2] - DateDis[2]
            var roznicawsumiedni2 = roznicalat2 + roznicamies2 + roznicadni2
            if(DataWy[1]<=0 && (DataPrzy[1]>12 || DataPrzy[1]<0)) {
                text.text = "Wybierz daty!!"
            }
            else
            {
                if(roznicawsumiedni2 < 0){
                    text.text = "Wycieczka nie moźe rozpoczynać się w przeszłości"
                }
                else if(DataPrzy[0] == 1000000) {
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
                    text.text = "Różnica dni to: " + roznicawsumiedni.toString()
                }
            }

        }
        zatwierdz.setOnClickListener {
            if(rb1.isChecked){
                licz += 1
                    for (i in 0..2) {
                        DataWy[i] = 0;
                    }
                    for (i in 0..2){
                        DataWy[i] = Date[i];
                    }
                    findViewById<TextView>(R.id.textView2).text = ""
                    for (i in 0..2){
                        findViewById<TextView>(R.id.textView2).text = findViewById<TextView>(R.id.textView2).text.toString() + DataWy[i].toString()
                    }
                liczbadni()
            }
            else if(rb2.isChecked){
                licz += 1;
                    for (i in 0..2) {
                        DataPrzy[i] = 100000000;
                    }
                    for(i in 0..2){
                        DataPrzy[i] = Date[i]
                    }
                    findViewById<TextView>(R.id.textView3).text = ""
                    for (i in 0..2){
                        findViewById<TextView>(R.id.textView3).text = findViewById<TextView>(R.id.textView3).text.toString() + DataPrzy[i].toString()
                    }
                liczbadni()

            }
        }
    }
}