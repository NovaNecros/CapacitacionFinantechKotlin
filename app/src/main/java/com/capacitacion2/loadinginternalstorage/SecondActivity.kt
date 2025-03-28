/*En esta clase se muestra la información guardada*/

package com.capacitacion2.loadinginternalstorage

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import android.widget.TextView
import android.widget.ImageView
import android.widget.Button
import android.view.View
import android.widget.Toast
import android.graphics.drawable.GradientDrawable
import android.view.Gravity
import androidx.core.content.ContextCompat

import android.widget.FrameLayout
import com.google.android.material.snackbar.Snackbar

import java.io.BufferedReader
import java.io.InputStreamReader

class SecondActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.second))
        { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnLoad = findViewById<Button>(R.id.btn_load)
        val btnBack = findViewById<Button>(R.id.btn_back)
        val textoGuardado = findViewById<TextView>(R.id.texto_guardado)
        val gatoElegante = findViewById<ImageView>(R.id.sirgato)

        textoGuardado.visibility = View.INVISIBLE
        gatoElegante.visibility = View.INVISIBLE

        btnLoad.setOnClickListener(View.OnClickListener
        { v ->
            val eol : String = System.lineSeparator()
            var input:BufferedReader? = null

            input = BufferedReader(InputStreamReader(openFileInput(getString(R.string.filename))))
            val builder = StringBuilder()
            val line = input.readLine()
            builder.append(line+eol)
            textoGuardado.text = builder.toString()

            val view = findViewById<View>(android.R.id.content)
            val texto : String = getString(R.string.toast_cargado)
            val color : Int = ContextCompat.getColor(applicationContext, R.color.brat)
            showSnackbar(view, texto, color)

            btnLoad.visibility = View.INVISIBLE
            textoGuardado.visibility = View.VISIBLE
            gatoElegante.visibility = View.VISIBLE
        })

        //regresa a pedir información al usuario
        btnBack.setOnClickListener(View.OnClickListener
        {
            intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        })
    }

    //snackbar como alternativa a los Toast personalizados
    private fun showSnackbar(view : View, texto : String, col : Int)
    {
        val snackbar = Snackbar.make(view, texto, Snackbar.LENGTH_LONG)
        val msj = snackbar.view.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
        val layoutParams = snackbar.view.layoutParams as FrameLayout.LayoutParams

        snackbar.setBackgroundTint(col)
        snackbar.view.setPadding(0, 0, 0, 0)

        msj.textSize = 24f
        msj.gravity = Gravity.CENTER_HORIZONTAL //no sirve T___T
        msj.setTextColor(ContextCompat.getColor(applicationContext, R.color.white))

        layoutParams.gravity = Gravity.TOP or Gravity.CENTER_HORIZONTAL
        layoutParams.setMargins(0, 200, 0, 0)
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