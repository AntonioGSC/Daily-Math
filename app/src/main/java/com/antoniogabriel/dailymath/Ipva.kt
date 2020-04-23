package com.antoniogabriel.dailymath

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_conversor_temperatura.*
import kotlinx.android.synthetic.main.activity_ipva.*

class Ipva : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ipva)

        val listaEstados = arrayListOf("Selecione o Estado", "AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RO", "RS", "RR", "SC", "SE", "SP", "TO")
        val estadosAdapter = ArrayAdapter(
            this@Ipva,
            android.R.layout.simple_spinner_dropdown_item,
            listaEstados
        )
        spnIpva.adapter = estadosAdapter

        btnResultadoIpva.setOnClickListener {
            if(!isEmpty(edtIpva)) {
                val escolha = spnIpva.selectedItem.toString()
                val valorCarro = edtIpva.text.toString().toDouble()

                when (escolha) {
                    "SC", "ES", "SE", "PB", "AC", "TO" -> {
                        val IPVA = String.format("%.2f", valorCarro * 0.02).toDouble()
                        txtResultadoIpva.text = "R$ $IPVA"
                    }
                    "AL", "PE", "RN", "CE", "PI", "MA", "BA", "PA", "MS", "GO" -> {
                        val IPVA = String.format("%.2f", valorCarro * 0.025).toDouble()
                        txtResultadoIpva.text = "R$ $IPVA"
                    }
                    "RS", "SP", "AP", "AM", "RR", "RO", "MT", "DF" -> {
                        val IPVA = String.format("%.2f", valorCarro * 0.03).toDouble()
                        txtResultadoIpva.text = "R$ $IPVA"
                    }
                    "PR" -> {
                        val IPVA = String.format("%.2f", valorCarro * 0.035).toDouble()
                        txtResultadoIpva.text = "R$ $IPVA"
                    }
                    "RJ", "MG" -> {
                        val IPVA = String.format("%.2f", valorCarro * 0.04).toDouble()
                        txtResultadoIpva.text = "R$ $IPVA"
                    }
                    else -> {
                        Toast.makeText(
                            this@Ipva,
                            "Campo estado em branco!!",
                            Toast.LENGTH_LONG).show()
                    }
                }
            }
            else{
                Toast.makeText(
                    this@Ipva,
                    "Campo veículo em branco!!",
                    Toast.LENGTH_LONG).show()
            }
        }

        btnHomeIpva.setOnClickListener {
            startActivity(Intent(this@Ipva, MainActivity::class.java))
            finish()
        }
    }

    private fun isEmpty(editText: EditText): Boolean {
        return if (editText.text.toString().trim { it <= ' ' }.length > 0) false else true
    }
}
