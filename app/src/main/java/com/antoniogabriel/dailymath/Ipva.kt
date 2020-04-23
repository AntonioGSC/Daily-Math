package com.antoniogabriel.dailymath

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
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
            val escolha = spnIpva.selectedItem.toString()
            val valorCarro = edtIpva.text.toString().toDouble()

            when(escolha){
                "SC", "ES", "SE", "PB", "AC", "TO" -> {
                    val IPVA = valorCarro * 0.02
                    txtResultadoIpva.text = "R$ $IPVA"
                }
                "AL", "PE", "RN", "CE", "PI", "MA", "BA", "PA", "MS", "GO" -> {
                    val IPVA = valorCarro * 0.025
                    txtResultadoIpva.text = "R$ $IPVA"
                }
                "RS", "SP", "AP", "AM", "RR", "RO", "MT", "DF" -> {
                    val IPVA = valorCarro * 0.03
                    txtResultadoIpva.text = "R$ $IPVA"
                }
                "PR" -> {
                    val IPVA = valorCarro * 0.035
                    txtResultadoIpva.text = "R$ $IPVA"
                }
                "RJ", "MG" -> {
                    val IPVA = valorCarro * 0.04
                    txtResultadoIpva.text = "R$ $IPVA"
                }
                else -> {
                    txtResultadoIpva.text = "Selecione um Estado"
                }
            }
        }

        btnHomeIpva.setOnClickListener {
            startActivity(Intent(this@Ipva, MainActivity::class.java))
            finish()
        }
    }
}
