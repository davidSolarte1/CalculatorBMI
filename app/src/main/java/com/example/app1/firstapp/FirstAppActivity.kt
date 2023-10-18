package com.example.app1.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.app1.R

class FirstAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_app)
    }
}