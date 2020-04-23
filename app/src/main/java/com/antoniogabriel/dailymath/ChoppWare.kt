package com.antoniogabriel.dailymath

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_chopp_ware.*

class ChoppWare : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chopp_ware)

        btnResultadoAlcool.setOnClickListener {
            val canecas = edtAlcool.text.toString().toDouble()
            val litros = String.format("%.2f", (canecas * 300)/1000).toDouble()

            txtResultadoAlcool1.text = "$litros litros de chopp"
        }

        btnHomeAlcool.setOnClickListener {
            startActivity(Intent(this@ChoppWare, MainActivity::class.java))
            finish()
        }
    }
}
