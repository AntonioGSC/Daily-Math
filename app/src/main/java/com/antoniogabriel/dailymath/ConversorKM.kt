package com.antoniogabriel.dailymath

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_conversor_k_m.*

class ConversorKM : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversor_k_m)

        btnResultadoKm.setOnClickListener {
            if(!isEmpty(edtKm)) {
                val quilometro = edtKm.text.toString().toFloat()
                val metros = quilometro * 1000
                val centimetros = metros * 100
                val milimetros = centimetros * 10

                txtResultadoKm1.text = "$metros Metros"
                txtResultadoKm2.text = "$centimetros Centímetros"
                txtResultadoKm3.text = "$milimetros Milímetros"
            }
            else{
                Toast.makeText(
                    this@ConversorKM,
                    "Campo distância em branco!!",
                    Toast.LENGTH_LONG).show()
            }
        }

        btnHomeKm.setOnClickListener {
            startActivity(Intent(this@ConversorKM, MainActivity::class.java))
            finish()
        }
    }

    private fun isEmpty(editText: EditText): Boolean {
        return if (editText.text.toString().trim { it <= ' ' }.length > 0) false else true
    }
}
