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
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class SecondActivity : AppCompatActivity()
{
    var dataManager : DataManager? = null
    var listaPersonitas : ListView? = null

    override fun onCreate(savedInstanceState : Bundle?)
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

        val botonGuardar = findViewById<Button>(R.id.boton_guardar)
        val lectorNombre = findViewById<EditText>(R.id.lector_nombre)
        val lectorApellidoP = findViewById<EditText>(R.id.lector_apellido_p)
        val lectorApellidoM = findViewById<EditText>(R.id.lector_apellido_m)
        val masculino = findViewById<CheckBox>(R.id.masculino)
        val femenino = findViewById<CheckBox>(R.id.femenino)
        val nobinario = findViewById<CheckBox>(R.id.nobinario)
        val otroGenero = findViewById<EditText>(R.id.lector_otro_genero)
        val calendarioView = findViewById<CalendarView>(R.id.fecha_calendario)

        dataManager = DataManager(this)
        listaPersonitas = findViewById(R.id.lista_personitas)
        mostrarPersonitas()

        botonGuardar.setOnClickListener(View.OnClickListener
        {
            val nombre : String = lectorNombre.getText().toString()
            val apellidoP : String = lectorApellidoP.getText().toString()
            val apellidoM : String = lectorApellidoM.getText().toString()
            val generosUsuario = mutableListOf<String>()
            val cumFecha : String = calendarioView.date.toString()
            val generos = arrayOf(masculino, femenino, nobinario)

            for(genero in generos)
            {
                if(genero.isChecked)
                {
                    generosUsuario.add(genero.text.toString())
                }
            }
            if(otroGenero.text.toString().isNotEmpty())
            {
                generosUsuario.add(otroGenero.text.toString())
            }

            if(generosUsuario.isEmpty())
            {
                Snackbar.make(it, resources.getString(R.string.no_genero_ex), Snackbar.LENGTH_SHORT).show()
            }
            else if(nombre.isNotEmpty() && apellidoP.isNotEmpty() && cumFecha.isNotEmpty())
            {
                val fulanito = Personita(nombre, apellidoP, apellidoM, generosUsuario.toString(), cumFecha)
                dataManager!!.guardarPersonita(fulanito)

                Toast.makeText(this, "Personita ${fulanito} guardada", Toast.LENGTH_LONG).show()
                lectorNombre.text.clear()
                lectorApellidoP.text.clear()
                lectorApellidoM.text.clear()
                calendarioView.date = System.currentTimeMillis()

                for(genero in generos)
                {
                    genero.isChecked = false
                }
                otroGenero.text.clear()
            }
            else
            {
                Toast.makeText(this, resources.getString(R.string.datos_incompletos_ex), Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onPause()
    {
        dataManager!!.cerrar()
        super.onPause()
    }

    override fun onResume()
    {
        dataManager!!.abrir()
        super.onResume()
    }

    fun mostrarPersonitas()
    {
        try
        {
            val personitas = dataManager!!.leerPersonitas()
            val adaptador = ArrayAdapter<Personita>(applicationContext, android.R.layout.simple_list_item_1, personitas)
            listaPersonitas!!.adapter = adaptador
            listaPersonitas!!.isVerticalScrollBarEnabled = true
        }
        catch(ex : Exception)
        {
            Toast.makeText(applicationContext, ex.message, Toast.LENGTH_LONG).show()
        }
    }
}