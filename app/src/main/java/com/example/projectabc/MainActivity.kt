package com.example.projectabc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edit = findViewById<EditText>(R.id.editText)
        val boton = findViewById<Button>(R.id.botonCalcular)
        val numeroSuerte = findViewById<TextView>(R.id.numeroDeLaSuerte)

        boton.setOnClickListener {
            val userInput = edit.text.toString()

            val numberOfNumbers= userInput.length

            if(numberOfNumbers < 14 || numberOfNumbers > 16 ){
                Toast.makeText(this," El numero ingresado debe tener como maximo 16 caracteres y minimo 14",Toast.LENGTH_LONG).show()
                    return@setOnClickListener
            }else{
                Toast.makeText(this,"Gracias por ingresarlo correctamente",Toast.LENGTH_LONG).show()

            }

            val list = mutableListOf<Int>()
            for (i in userInput){
                list.add(i.toString().toInt())

            }

            val newSorted = list.sorted()
            println("${newSorted}")
                    //   ingresa = 123456789101112
            // sorted  0 1 1 1 1 1 2 2 3 4 5 6 7 8 9

            var aux = newSorted[1]
            var cont = 1
            var max = 0
            var numMax = aux
            for(i in 2 until newSorted.size){
                if(newSorted[i]==aux){
                    cont++
                }
                else{
                    if(cont > max){
                        max = cont
                        numMax = aux
                    }
                    cont = 1
                    aux = newSorted[i]
                }
            }
            println(max)
            println(numMax)

            numeroSuerte.visibility= View.VISIBLE

            numeroSuerte.text= "Numero de la suerte: ${numMax}"
        }
        }
    }
