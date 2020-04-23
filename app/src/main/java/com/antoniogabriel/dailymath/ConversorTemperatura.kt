package com.antoniogabriel.dailymath

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_ano_bissexto.*
import kotlinx.android.synthetic.main.activity_conversor_temperatura.*

class ConversorTemperatura : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversor_temperatura)

        val listaTemperatura = arrayListOf("Selecione a escala", "Celsius", "Kelvin", "Fahrenheit")
        val temperaturaAdapter = ArrayAdapter(
            this@ConversorTemperatura,
            android.R.layout.simple_spinner_dropdown_item,
            listaTemperatura
        )
        spnTemp.adapter = temperaturaAdapter

        btnResultadoTemp.setOnClickListener {
            if(!isEmpty(edtTemp)) {
                val escolha = spnTemp.selectedItem.toString()
                val temperatura = edtTemp.text.toString().toFloat()
                if (escolha == "Celsius") {
                    val tempKelvin = String.format("%.2f", temperatura + 273.15).toDouble()
                    val tempFahrenheit = String.format("%.2f", (temperatura * 1.8) + 32).toDouble()

                    txtResultadoTemp1.text = "Kelvin: $tempKelvin K"
                    txtResultadoTemp2.text = "Fahrenheit: $tempFahrenheit °F"
                } else if (escolha == "Kelvin") {
                    val tempCelsius = String.format("%.2f", temperatura - 273.15).toDouble()
                    val tempFahrenheit = String.format("%.2f", (tempCelsius * 1.8) + 32).toDouble()

                    txtResultadoTemp1.text = "Celsius: $tempCelsius °C"
                    txtResultadoTemp2.text = "Fahrenheit: $tempFahrenheit °F"
                } else if (escolha == "Fahrenheit") {
                    val tempCelsius = String.format("%.2f", (temperatura - 32) / 1.8).toDouble()
                    val tempKelvin = String.format("%.2f", tempCelsius + 273.15).toDouble()

                    txtResultadoTemp1.text = "Celsius: $tempCelsius °C"
                    txtResultadoTemp2.text = "Kelvin: $tempKelvin K"
                } else {
                    Toast.makeText(
                        this@ConversorTemperatura,
                        "Campo Escala Obrigatório!!",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
            else{
                Toast.makeText(
                    this@ConversorTemperatura,
                    "Campo temperatura em branco!!",
                    Toast.LENGTH_LONG).show()
            }
        }
        btnHomeTemp.setOnClickListener {
            startActivity(Intent(this@ConversorTemperatura, MainActivity::class.java))
            finish()
        }
    }

    private fun isEmpty(editText: EditText): Boolean {
        return if (editText.text.toString().trim { it <= ' ' }.length > 0) false else true
    }
}
