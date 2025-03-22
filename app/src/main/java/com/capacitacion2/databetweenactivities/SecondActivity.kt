package com.capacitacion2.databetweenactivities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import android.content.Intent
import android.widget.TextView
import android.widget.Button
import android.widget.Toast

class SecondActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.second))
        {
            v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var texto = findViewById<TextView>(R.id.texto2)
        val bundle = intent.extras
        val data = bundle?.getString("userdata")
        texto.text = data.toString()

        val btn2 = findViewById<Button>(R.id.btnAct2)
        btn2.setOnClickListener()
        {
            val intent = Intent(applicationContext, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}