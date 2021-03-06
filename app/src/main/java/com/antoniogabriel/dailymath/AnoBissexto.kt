package com.antoniogabriel.dailymath

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.isEmpty
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_ano_bissexto.*
import kotlinx.android.synthetic.main.activity_par_impar.*

class AnoBissexto : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ano_bissexto)

        btnResultadoAno.setOnClickListener {
            if(!isEmpty(edtAno)) {
                val anoDigitado = edtAno.text.toString().toInt()
                if ((anoDigitado % 4 == 0) || (anoDigitado % 400 == 0)) {
                    txtResultadoAno.text = "Sim"
                } else {
                    txtResultadoAno.text = "Não"
                }
            }
            else{
                Toast.makeText(
                    this@AnoBissexto,
                    "Campo ano em branco!!",
                    Toast.LENGTH_LONG).show()
            }
        }

        btnHomeAno.setOnClickListener {
            startActivity(Intent(this@AnoBissexto, MainActivity::class.java))
            finish()
        }
    }

    private fun isEmpty(editText: EditText): Boolean {
        return if (editText.text.toString().trim { it <= ' ' }.length > 0) false else true
    }
}
