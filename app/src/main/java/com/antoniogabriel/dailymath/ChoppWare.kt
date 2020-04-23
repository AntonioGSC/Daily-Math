package com.antoniogabriel.dailymath

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_chopp_ware.*
import kotlinx.android.synthetic.main.activity_conversor_temperatura.*

class ChoppWare : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chopp_ware)

        val listaSexo = arrayListOf("Selecione seu sexo", "Masculino", "Feminino")
        val sexoAdapter = ArrayAdapter(
            this@ChoppWare,
            android.R.layout.simple_spinner_dropdown_item,
            listaSexo
        )
        spnSexo.adapter = sexoAdapter

        btnResultadoAlcool.setOnClickListener {
            if(!isEmpty(edtAlcool) && !isEmpty(edtAlcoolPeso)) {
                val canecas = edtAlcool.text.toString().toDouble()
                val litros = String.format("%.2f", (canecas * 300) / 1000).toDouble()
                val escolha = spnSexo.selectedItem.toString()
                val peso = edtAlcoolPeso.text.toString().toDouble()
                if (escolha == "Masculino") {
                    val aguaCorpo = (peso * 0.7) * 1000
                    val alcoolCorpo = (canecas * 14.2)
                    val concentracao = alcoolCorpo / aguaCorpo
                    val resultado = String.format("%.2f", (concentracao * 0.806) * 1000).toDouble()
                    txtResultadoAlcool1.text = "$litros litros de chopp"
                    txtResultadoAlcool2.text = "$resultado gramas de álcool/ litro de sangue"
                } else if (escolha == "Feminino") {
                    val aguaCorpo = (peso * 0.6) * 1000
                    val alcoolCorpo = (canecas * 14.2)
                    val concentracao = alcoolCorpo / aguaCorpo
                    val resultado = String.format("%.2f", (concentracao * 0.806) * 1000).toDouble()
                    txtResultadoAlcool1.text = "$litros litros de chopp"
                    txtResultadoAlcool2.text = "$resultado gramas de álcool/ litros de sangue"
                } else {
                    Toast.makeText(
                        this@ChoppWare,
                        "Campo Sexo Obrigatório!!",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
            else{
                Toast.makeText(
                    this@ChoppWare,
                    "Campo em branco!!",
                    Toast.LENGTH_LONG).show()
            }
        }

        btnHomeAlcool.setOnClickListener {
            startActivity(Intent(this@ChoppWare, MainActivity::class.java))
            finish()
        }
    }

    private fun isEmpty(editText: EditText): Boolean {
        return if (editText.text.toString().trim { it <= ' ' }.length > 0) false else true
    }
}
