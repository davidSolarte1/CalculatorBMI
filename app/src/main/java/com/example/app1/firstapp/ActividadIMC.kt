package com.example.app1.firstapp

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import com.example.app1.R

class ActividadIMC : AppCompatActivity() {
    private var sex:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad_imc)
        val btnCalc = findViewById<Button>(R.id.btnCalc)
        val etName = findViewById<EditText>(R.id.etName)
        val etWeight = findViewById<EditText>(R.id.etWeight)
        val etHeight = findViewById<EditText>(R.id.etHeight)
        val btnMale = findViewById<ImageButton>(R.id.btnMale)
        val btnFemale = findViewById<ImageButton>(R.id.btnFemale)
        val etAge = findViewById<EditText>(R.id.etAge)

        btnMale.setOnClickListener {
            sex = "Masculino"
            btnMale.setBackgroundColor(Color.parseColor("#9FE4BB"))
            btnFemale.setBackgroundColor(Color.parseColor("#FFFFFF"))
            Toast.makeText(this, "Sexo $sex", Toast.LENGTH_SHORT).show()
        }
        btnFemale.setOnClickListener {
            sex = "Femenino"
            btnFemale.setBackgroundColor(Color.parseColor("#9FE4BB"))
            btnMale.setBackgroundColor(Color.parseColor("#FFFFFF"))
            Toast.makeText(this, "Sexo $sex", Toast.LENGTH_SHORT).show()
        }

        btnCalc.setOnClickListener {
            Log.i("sex", "$sex")
            val name = etName.text.toString()
            val weight = etWeight.text.toString().trim()
            val height = etHeight.text.toString().trim()
            val age = etAge.text.toString().trim()


            if (name.isEmpty()){
                Toast.makeText(this, "Por favor ingresa tu nombre", Toast.LENGTH_SHORT).show()
            }else if (weight.isEmpty()){
                Toast.makeText(this, "Por favor, ingrese su peso", Toast.LENGTH_SHORT).show()
            }else if (height.isEmpty()) {
                Toast.makeText(this, "Por favor, ingrese su estatura", Toast.LENGTH_SHORT).show()
            }else  if (sex == null){
                Toast.makeText(this, "Por favor, seleccione su sexo", Toast.LENGTH_SHORT).show()
            }else if (age.isEmpty()) {
                Toast.makeText(this, "Por favor, ingrese su edad", Toast.LENGTH_SHORT).show()
            }else{

                val intent = Intent(this, ImcResult::class.java)
                intent.putExtra("EXTRA_NAME", name)
                intent.putExtra("EXTRA_WEIGHT", weight)
                intent.putExtra("EXTRA_HEIGHT", height)
                intent.putExtra("EXTRA_SEX", sex)
                intent.putExtra("EXTRA_AGE", age)
                startActivity(intent)


            }



        }
    }
}