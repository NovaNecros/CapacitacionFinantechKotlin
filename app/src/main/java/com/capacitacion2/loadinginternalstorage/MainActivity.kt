package com.capacitacion2.loadinginternalstorage

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
import android.widget.FrameLayout
import androidx.core.view.setPadding
import com.google.android.material.snackbar.Snackbar

import java.io.FileOutputStream
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.StringBuilder

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
                if(!etName.text.toString().isEmpty())
                {
                    tvName.visibility = View.INVISIBLE
                    etName.visibility = View.INVISIBLE

                    val fileName : String = ContextCompat.getString(getApplicationContext(), R.string.filename)
                    val dataToSave : String = etName.text.toString()

                    val fos : FileOutputStream = openFileOutput(fileName, MODE_PRIVATE)
                    fos.write(dataToSave.toByteArray())
                    fos.close()

                    val view = findViewById<View>(android.R.id.content)
                    val texto = ContextCompat.getString(getApplicationContext(), R.string.toast_guardado)
                    val col = ContextCompat.getColor(getApplicationContext(), R.color.brat)
                    showSnackbar(view, texto, col)
                    //showToast(texto, col)

                    etName.setText("")
                }
                else
                {
                    val view = findViewById<View>(android.R.id.content)
                    val col = ContextCompat.getColor(getApplicationContext(), R.color.rojosangre)
                    val texto = ContextCompat.getString(getApplicationContext(), R.string.toast_vacio)
                    showSnackbar(view, texto, col)
                    btnSave.isChecked = false
                }
            }
            else
            {
                tvName.visibility = View.VISIBLE
                etName.visibility = View.VISIBLE
            }
        })
    }

    private fun showSnackbar(view : View, texto : String, col : Int)
    {
        val snackbar = Snackbar.make(view, texto, Snackbar.LENGTH_LONG)
        val msj = snackbar.view.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
        val layoutParams = snackbar.view.layoutParams as FrameLayout.LayoutParams

        snackbar.setBackgroundTint(col)
        snackbar.view.setPadding(0, 0, 0, 0)

        msj.textSize = 24f
        msj.gravity = Gravity.CENTER_HORIZONTAL
        msj.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white))

        layoutParams.gravity = Gravity.TOP or Gravity.CENTER_HORIZONTAL
        layoutParams.setMargins(0, 250, 0, 0)
        layoutParams.width = FrameLayout.LayoutParams.WRAP_CONTENT
        layoutParams.height = FrameLayout.LayoutParams.WRAP_CONTENT
        snackbar.view.layoutParams = layoutParams

        snackbar.show()
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
        toast.setGravity(Gravity.TOP, 0, 200)
        toast.show()
    }
}