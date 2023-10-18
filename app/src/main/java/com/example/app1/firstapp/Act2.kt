package com.example.app1.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.widget.AppCompatEditText
import com.example.app1.R

class Act2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_act2)
        val btnSaludar = findViewById<Button>(R.id.btnSaludar)
        val etName = findViewById<EditText>(R.id.etName)

        btnSaludar.setOnClickListener{

            val name = etName.text.toString()
            if(name.isNotEmpty()){
                Log.i("Frist", "Se hizo click... $name")
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("EXTRA_NAME", name)

                startActivity(intent)
            }

        }
    }
}