package com.ft_ss.prawiedzialajacaapikacja

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Data
import android.widget.RadioButton
import android.widget.Button
import android.widget.CalendarView
import android.widget.TextView
import java.util.Date

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var licz = 0;
        var Date = mutableListOf<Int>(0,0,0);
        var rb1 = findViewById<RadioButton>(R.id.rb1);
        var rb2 = findViewById<RadioButton>(R.id.rb2);
        var zatwierdz = findViewById<Button>(R.id.Zatwierdz);
        var calendar = findViewById<CalendarView>(R.id.calendarView);
        var text = findViewById<TextView>(R.id.textView)
        var DataWy = mutableListOf<Int>(0,0,0);
        var DataPrzy = mutableListOf<Int>(100000000,10000000,10000000);
        calendar.setOnDateChangeListener(
            CalendarView.OnDateChangeListener { view, year, month, dayOfMonth ->
                    Date[0] = year
                    Date[1] = month
                    Date[2] = dayOfMonth
            })
        fun liczbadni(){
            text.text = "Funkcja działa"
            if(DataWy[0]>DataPrzy[0] || DataWy[1]>DataPrzy[1] || DataWy[2]>DataPrzy[2]){
                text.text = "Data Wyjazdu nie może być po dacie przujazdu"
            }
            else {
                var roznicalat = (DataPrzy[0] - DataWy[0]) * 365
                var roznicamies = (DataPrzy[1] - DataWy[1]) * 31
                var roznicadni = DataPrzy[2] - DataWy[2]
                var roznicawsumiedni = roznicalat.toInt() + roznicamies.toInt() + roznicadni.toInt()
                text.text = "Różnica dni to:" + roznicawsumiedni.toString()
            }
        }
        zatwierdz.setOnClickListener{
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