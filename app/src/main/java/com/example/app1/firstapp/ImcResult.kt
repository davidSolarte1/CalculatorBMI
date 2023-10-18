package com.example.app1.firstapp

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.app1.R

class ImcResult : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_result)

        val tvName = findViewById<TextView>(R.id.tvName)
        val tvWeight = findViewById<TextView>(R.id.tvWeight)
        val tvHeight = findViewById<TextView>(R.id.tvHeight)
        val tvSex = findViewById<TextView>(R.id.tvSex)
        val tvAge = findViewById<TextView>(R.id.tvAge)


        val name:String = intent.extras?.getString("EXTRA_NAME").orEmpty()
        tvName.text="Nombre: $name"
        val weight:String = intent.extras?.getString("EXTRA_WEIGHT").orEmpty()
        tvWeight.text="Peso: $weight kg"
        val height:String = intent.extras?.getString("EXTRA_HEIGHT").orEmpty()
        val sex:String = intent.extras?.getString("EXTRA_SEX").orEmpty()
        tvSex.text="Sexo: $sex"
        val age:String = intent.extras?.getString("EXTRA_AGE").orEmpty()
        tvAge.text="Edad: $age Años"

        val height2 = height.toDouble()
        val weight2 = weight.toDouble()
        val hMts = height2/100
        tvHeight.text="Estatura: $hMts mts"

        val imc = weight2 / (hMts * hMts)
        val fImc = String.format("%.2f", imc)

        val tvIMC = findViewById<TextView>(R.id.tvIMC)
        tvIMC.text="Tu Imc es: $fImc"



        if(height2<162){
            val tvRec = findViewById<TextView>(R.id.tvRec)
            tvRec.text="Su rango de peso saludable sugerido es de 43 a 58 kg."
        }else if(height2 in 162.0 .. 173.0){
            val tvRec = findViewById<TextView>(R.id.tvRec)
            tvRec.text="Su rango de peso saludable sugerido es de 55 a 74 kg."
        }else if(height2 >= 174.0){
            val tvRec = findViewById<TextView>(R.id.tvRec)
            tvRec.text="Su rango de peso saludable sugerido es de 62 a 83 kg."
        }



        if(imc < 18.5){

            val state = "Tienes un peso bajo"
            val color = "#FFC103"
            val message = "La delgadez puede deberse a diversos factores, tales como genéticos y dietéticos. Independiente de su causa, es importante para tu bienestar mantener un peso saludable."

            showStateImc(state,color,message)

        }else if(imc in 18.5..24.9){
            val state = "Tienes un peso Normal"
            val color = "#00FF01"
            val message = "El equilibrio del organismo -su homeostasis- se obtiene con mayor facilidad si el peso de una persona es normal. Una dieta balanceada y ejercicio ayudan a mantenerse en esta categoría."

            showStateImc(state,color,message)

        }else if(imc in 25.0..29.9){
            val state = "Tienes sobrepeso"
            val color = "#FEFF67"
            val message = "Una mala alimentación y hábitos sedentarios pueden contribuir a acumular grasa en tu cuerpo, lo que puede llevar a problemas médicos en el futuro."

            showStateImc(state,color,message)
            
        }else if(imc in 30.0..39.9){

            val state = "Tienes obesidad"
            val color = "#FE66CB"
            val message = "Cuidado, la obesidad genera complicaciones mayores en el organismo y acorta la vida. Es esencial abordar este estado con una dieta balanceada, ejercicio y, en determinadas ocasiones, con cirugía."

            showStateImc(state,color,message)

        }else if(imc >= 40){
            val state = "Tienes obesidad mórbida"
            val color = "#FE3300"
            val message = "La obesidad mórbida es una condición de salud grave que requiere una atención especial y cuidados adicionales. Si tu índice de masa corporal (IMC) ha alcanzado un nivel de 40 o más, es esencial tomar medidas para abordar esta situación."

            showStateImc(state,color,message)

        }

        val btnReturn = findViewById<Button>(R.id.btnReturn)
        btnReturn.setOnClickListener {
            finish()
        }
    }

    private fun showStateImc(state:String, color:String, msg:String){
        val tvStateIMC = findViewById<TextView>(R.id.tvStateIMC)
        val vState = findViewById<View>(R.id.vState)
        val tvOp =findViewById<TextView>(R.id.tvOp)
        vState.setBackgroundColor(Color.parseColor(color))
        tvStateIMC.text= state
        tvOp.text= msg
    }
}