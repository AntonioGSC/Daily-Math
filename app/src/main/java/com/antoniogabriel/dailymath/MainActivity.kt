package com.antoniogabriel.dailymath

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnParImpar.setOnClickListener {
            startActivity(Intent(this@MainActivity, ParImpar::class.java))
            finish()
        }

        btnBissexto.setOnClickListener {
            startActivity(Intent(this@MainActivity, AnoBissexto::class.java))
            finish()
        }

        btnTemperatura.setOnClickListener {
            startActivity(Intent(this@MainActivity, ConversorTemperatura::class.java))
            finish()
        }

        btnConversorkm.setOnClickListener {
            startActivity(Intent(this@MainActivity, ConversorKM::class.java))
            finish()
        }
        btnChoppWare.setOnClickListener {
            startActivity(Intent(this@MainActivity, ChoppWare::class.java))
            finish()
        }
        btnipva.setOnClickListener {
            startActivity(Intent(this@MainActivity, Ipva::class.java))
            finish()
        }
    }
}
