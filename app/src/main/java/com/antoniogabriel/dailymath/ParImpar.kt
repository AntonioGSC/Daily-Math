package com.antoniogabriel.dailymath

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_par_impar.*

class ParImpar : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_par_impar)

        btnResultadoPar.setOnClickListener {
            val numero = edtParImpar.text.toString().toInt()
            val calculo = numero % 2
            if(calculo == 0){
                txtResultadoPar.text = "Par"
            }
            else {
                txtResultadoPar.text = "Ímpar"
            }
        }

        btnHome.setOnClickListener {
            startActivity(Intent(this@ParImpar, MainActivity::class.java))
            finish()
        }
    }
}
