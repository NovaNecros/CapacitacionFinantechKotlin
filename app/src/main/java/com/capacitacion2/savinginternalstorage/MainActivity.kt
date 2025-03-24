package com.capacitacion2.savinginternalstorage

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import android.widget.TextView
import android.widget.EditText
import android.widget.ToggleButton
import android.widget.CompoundButton
import android.view.View
import android.widget.Toast
import android.graphics.drawable.GradientDrawable
import android.view.Gravity
import androidx.core.content.ContextCompat

import android.content.Context
import java.io.FileOutputStream


class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main))
        { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnSave = findViewById<ToggleButton>(R.id.btn_save)
        val tvName = findViewById<TextView>(R.id.tv_name)
        val etName = findViewById<EditText>(R.id.et_name)

        btnSave.visibility = View.VISIBLE
        tvName.visibility = View.VISIBLE
        etName.visibility = View.VISIBLE

        btnSave.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener
        { buttonView, isChecked ->
            if(isChecked)
            {
                if(etName.text.toString() != "")
                {
                    tvName.visibility = View.INVISIBLE
                    etName.visibility = View.INVISIBLE

                    val col = ContextCompat.getColor(getApplicationContext(), R.color.brat)
                    val texto = ContextCompat.getString(getApplicationContext(), R.string.toast_guardado)
                    showToast(texto, col)

                    etName.setText("")
                }
                else
                {
                    val col = ContextCompat.getColor(getApplicationContext(), R.color.rojosangre)
                    val texto = ContextCompat.getString(getApplicationContext(), R.string.toast_vacio)
                    showToast(texto, col)
                    btnSave.isChecked = false
                }
            }
            else
            {
                tvName.visibility = View.VISIBLE
                etName.visibility = View.VISIBLE

                val col = ContextCompat.getColor(getApplicationContext(), R.color.brat)
                val texto = ContextCompat.getString(getApplicationContext(), R.string.toast_borrado)
                showToast(texto, col)
            }
        })
    }

    //muestra un toast personalizado
    private fun showToast(texto : String, color : Int)
    {
        val inflater = layoutInflater
        val layout = inflater.inflate(R.layout.custom_toast, findViewById(R.id.main), false)
        val toast = Toast(applicationContext)
        val contenido = layout.findViewById<TextView>(R.id.textoToast)
        val burbuja = GradientDrawable()

        burbuja.setColor(color)
        burbuja.cornerRadius = 25f
        layout.background = burbuja
        contenido.text = texto
        toast.view = layout
        toast.duration = Toast.LENGTH_SHORT
        toast.setGravity(Gravity.BOTTOM or Gravity.END, 50, 0)
        toast.show()
    }
}