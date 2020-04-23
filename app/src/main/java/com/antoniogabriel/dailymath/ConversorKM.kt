package com.antoniogabriel.dailymath

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_conversor_k_m.*

class ConversorKM : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversor_k_m)

        btnResultadoKm.setOnClickListener {
            val quilometro = edtKm.text.toString().toFloat()
            val metros = quilometro * 1000
            val centimetros = metros * 100
            val milimetros = centimetros * 10

            txtResultadoKm1.text = "$metros Metros"
            txtResultadoKm2.text = "$centimetros Centímetros"
            txtResultadoKm3.text = "$milimetros Milímetros"
        }

        btnHomeKm.setOnClickListener {
            startActivity(Intent(this@ConversorKM, MainActivity::class.java))
            finish()
        }
    }
}
