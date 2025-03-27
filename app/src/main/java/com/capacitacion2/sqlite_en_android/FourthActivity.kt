package com.capacitacion2.sqlite_en_android

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import android.widget.ListView
import android.widget.Button
import android.view.View

import android.content.Intent
import android.widget.ArrayAdapter

class FourthActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fourth)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.fourth))
        { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val listaPersonitas = findViewById<ListView>(R.id.lista_personitas)
        val dataManager = DataManager(this)
        val botonRegresar = findViewById<Button>(R.id.btn_back)

        try
        {
            val personitas = dataManager.leerPersonitas()
            val adaptador = CustomAdapter(applicationContext, personitas)
            listaPersonitas.adapter = adaptador
            listaPersonitas.isVerticalScrollBarEnabled = true
        }
        catch(ex : Exception)
        {
            val view = findViewById<View>(android.R.id.content)
            val texto : String = ex.message.toString()
            val color : Int = resources.getColor(R.color.rojosangre)
            SnackbarUtil.showSnackbar(applicationContext, view, texto, color)
        }

        botonRegresar.setOnClickListener(View.OnClickListener
        {
            intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        })
    }
}