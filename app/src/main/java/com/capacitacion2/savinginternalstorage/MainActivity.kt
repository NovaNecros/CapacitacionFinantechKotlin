package com.capacitacion2.savinginternalstorage

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import android.content.SharedPreferences
import android.widget.TextView
import android.widget.EditText
import android.widget.ToggleButton
import android.widget.CompoundButton
import android.view.View
import android.widget.Toast
import android.graphics.drawable.GradientDrawable
import android.view.Gravity
import androidx.core.content.ContextCompat


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
        val tvPhone = findViewById<TextView>(R.id.tv_phone)
        val etName = findViewById<EditText>(R.id.et_name)
        val etPhone = findViewById<EditText>(R.id.et_phone)
        val tvSavedName = findViewById<TextView>(R.id.saved_name)
        val tvSavedPhone = findViewById<TextView>(R.id.saved_phone)
        var userInformation = getSharedPreferences("userPrefs", MODE_PRIVATE)

        btnSave.visibility = View.VISIBLE
        tvName.visibility = View.VISIBLE
        tvPhone.visibility = View.VISIBLE
        etName.visibility = View.VISIBLE
        etPhone.visibility = View.VISIBLE
        tvSavedName.visibility = View.INVISIBLE
        tvSavedPhone.visibility = View.INVISIBLE

        btnSave.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener
        { buttonView, isChecked ->
            if(isChecked)
            {
                //valida que el usuario introdujo los datos correctamente
                if(etName.text.toString() != "" && etPhone.text.toString() != "") {
                    val prefEditor: SharedPreferences.Editor = userInformation.edit()
                    prefEditor.putString("name", etName.text.toString())
                    prefEditor.putString("phone", etPhone.text.toString())
                    prefEditor.apply()

                    var un : String? = userInformation.getString("name", "XXX")
                    var up : String? = userInformation.getString("phone", "XXX")

                    tvSavedName.text = un
                    tvSavedPhone.text = up

                    tvName.visibility = View.INVISIBLE
                    tvPhone.visibility = View.INVISIBLE
                    etName.visibility = View.INVISIBLE
                    etPhone.visibility = View.INVISIBLE
                    tvSavedName.visibility = View.VISIBLE
                    tvSavedPhone.visibility = View.VISIBLE

                    val col = ContextCompat.getColor(getApplicationContext(), R.color.brat)
                    val texto = ContextCompat.getString(getApplicationContext(), R.string.toast_guardado)
                    showToast(texto, col)

                    etName.setText("") //borra los datos del editText después de guardarlos
                    etPhone.setText("")
                }
                else //si faltó algun dato regresa el togglebutton a su estado inicial
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
                tvPhone.visibility = View.VISIBLE
                etName.visibility = View.VISIBLE
                etPhone.visibility = View.VISIBLE
                tvSavedName.visibility = View.INVISIBLE
                tvSavedPhone.visibility = View.INVISIBLE

                val col = ContextCompat.getColor(getApplicationContext(), R.color.brat)
                val texto = ContextCompat.getString(getApplicationContext(), R.string.toast_borrado)
                showToast(texto, col)
            }
        })
    }

    //muestra un toast personalizado
    private fun showToast(texto: String, color: Int)
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