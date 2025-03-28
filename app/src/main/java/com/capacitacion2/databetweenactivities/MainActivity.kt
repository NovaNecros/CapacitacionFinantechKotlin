/*Esta clase lee la información y la envía a la segunda actividad*/

package com.capacitacion2.databetweenactivities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import android.content.Intent
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main))
        {
            v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val eText = findViewById<EditText>(R.id.eText)
        val btn1 = findViewById<Button>(R.id.btnAct1)
        btn1.setOnClickListener()
        {
            var data = eText.text.toString()
            val intent = Intent(applicationContext, SecondActivity::class.java)
            intent.putExtra("userdata", data) //manda el input a la segunda actividad
            startActivity(intent)
        }
    }
}