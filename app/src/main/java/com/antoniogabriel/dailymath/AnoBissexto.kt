package com.antoniogabriel.dailymath

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_ano_bissexto.*

class AnoBissexto : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ano_bissexto)

        btnResultadoAno.setOnClickListener {
            val anoDigitado = edtAno.text.toString().toInt()
            if((anoDigitado % 4 == 0) || (anoDigitado % 400 == 0)){
                txtResultadoAno.text = "Sim"
            }
            else{
                txtResultadoAno.text = "Não"
            }
        }

        btnHomeAno.setOnClickListener {
            startActivity(Intent(this@AnoBissexto, MainActivity::class.java))
            finish()
        }
    }
}
