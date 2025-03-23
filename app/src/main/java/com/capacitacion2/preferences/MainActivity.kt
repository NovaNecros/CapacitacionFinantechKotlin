package com.capacitacion2.preferences

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import android.content.Intent
import android.content.SharedPreferences
import android.widget.TextView
import android.widget.EditText
import android.widget.Button
import android.view.View


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

        val btnSave = findViewById<Button>(R.id.btn_save)
        val etName = findViewById<EditText>(R.id.et_name)
        val etPhone = findViewById<EditText>(R.id.et_phone)
        val tvName = findViewById<TextView>(R.id.saved_name)
        val tvPhone = findViewById<TextView>(R.id.saved_phone)
        var userInformation = getSharedPreferences("userPrefs", MODE_PRIVATE)

        btnSave.setOnClickListener(View.OnClickListener
        {
            val prefEditor : SharedPreferences.Editor = userInformation.edit()
            prefEditor.putString("name", etName.text.toString())
            prefEditor.putString("phone", etPhone.text.toString())
            prefEditor.apply()

            var un : String? = userInformation.getString("name", "XXX")
            var up : String? = userInformation.getString("phone", "XXX")
            tvName.text = un
            tvPhone.text = up
        })
    }
}