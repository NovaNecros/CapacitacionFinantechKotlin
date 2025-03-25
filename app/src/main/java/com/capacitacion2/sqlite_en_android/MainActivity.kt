package com.capacitacion2.sqlite_en_android

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CalendarView
import android.widget.EditText
import android.widget.ListView
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity()
{
    var dataManager : DataManager = null
    var botonGuardar = findViewById<Button>(R.id.boton_guardar)
    var lectorNombre = findViewById<EditText>(R.id.lector_nombre)
    var lectorApellidoP = findViewById<EditText>(R.id.lector_apellido_p)
    var lectorApellidoM = findViewById<EditText>(R.id.lector_apellido_m)
    var masculino = findViewById<CheckBox>(R.id.masculino)
    var femenino = findViewById<CheckBox>(R.id.femenino)
    var nobinario = findViewById<CheckBox>(R.id.nobinario)
    var otroGenero = findViewById<EditText>(R.id.otro_genero)
    var fecha = findViewById<CalendarView>(R.id.fecha)
    var listaPersonitas = findViewById<ListView>(R.id.lista_personitas)

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

        botonGuardar.setOnClickListener(View.OnClickListener
        {
            var nombre: String = lectorNombre.getText().toString()
            var apellidoP: String = lectorApellidoP.getText().toString()
            var apellidoM: String = lectorApellidoM.getText().toString()
            var generosUsuario = mutableListOf<String>()
            var curDate: String = fecha.date.toString()
            var generos = arrayOf(masculino, femenino, nobinario)

            for (genero in generos) {
                if (genero.isChecked) {
                    generosUsuario.add(genero.text.toString())
                }
            }
            if (otroGenero.text.toString().isNotEmpty()) {
                generosUsuario.add(otroGenero.text.toString())
            }

            if(generosUsuario.isEmpty())
            {
                Snackbar.make(it, "Debes seleccionar al menos un género", Snackbar.LENGTH_SHORT).show()
            }

            if(nombre.isNotEmpty() && apellidoP.isNotEmpty() && apellidoM.isNotEmpty() && curDate.isNotEmpty())
            {
                var fulanito = Personita(nombre, apellidoP, apellidoM, generosUsuario, curDate)
                dataManager.guardarPersonita(fulanito)
                Toast.makeText(this, "Personita "+ fulanito.toString() +" guardada", Toast.LENGTH_LONG).show()
                lectorNombre.text.clear()
                lectorApellidoP.text.clear()
                lectorApellidoM.text.clear()
                fecha.date = 0

                for(genero in generos)
                {
                    genero.isChecked = false
                }
                otroGenero.text.clear()

                mostrarPersonitas()
            }
            else
            {
                Snackbar.make(it, "Debes llenar todos los campos", Snackbar.LENGTH_SHORT).show()
            }
        })
    }

    override fun onPause()
    {
        super.onPause()
        dataManager.guardarPersonitas()
    }

    override fun onResume()
    {
        super.onResume()
        dataManager.leerPersonitas()
    }

    fun mostrarPersonitas()
    {

    }
}