package com.ft_ss.prawiedzialajacaapikacja

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var rb1 = findViewById<RadioButton>(R.id.rb1);
        var rb2 = findViewById<RadioButton>(R.id.rb2);
        var Zatwierdz = findViewById<Button>(R.id.Zatwierdz);


    }
}