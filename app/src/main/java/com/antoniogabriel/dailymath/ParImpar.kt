package com.antoniogabriel.dailymath

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_par_impar.*
import java.lang.RuntimeException
import kotlin.text.isBlank as isBlank1
import kotlin.text.isNullOrBlank as isNullOrBlank1

class ParImpar : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_par_impar)

        btnResultadoPar.setOnClickListener {
            if(!isEmpty(edtParImpar)){
                val numero = edtParImpar.text.toString().toInt()
                val calculo = numero % 2
                if(calculo == 0){
                    txtResultadoPar.text = "Par"
                }
                else {
                    txtResultadoPar.text = "Ímpar"
                }
            }
            else{
                Toast.makeText(
                    this@ParImpar,
                    "Campo número em branco!!",
                    Toast.LENGTH_LONG).show()
            }
        }

        btnHome.setOnClickListener {
            startActivity(Intent(this@ParImpar, MainActivity::class.java))
            finish()
        }
    }

    private fun isEmpty(editText: EditText): Boolean {
        return if (editText.text.toString().trim { it <= ' ' }.length > 0) false else true
    }
}


