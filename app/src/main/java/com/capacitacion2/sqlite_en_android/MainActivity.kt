package com.capacitacion2.sqlite_en_android

import android.app.DatePickerDialog
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

import java.util.Calendar

class MainActivity : AppCompatActivity()
{
    var dataManager : DataManager? = null
    var listaPersonitas : ListView? = null

    override fun onCreate(savedInstanceState : Bundle?)
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

                Toast.makeText(this, "Personita " + fulanito.toString() + " guardada", Toast.LENGTH_LONG).show()
                lectorNombre.text.clear()
                lectorApellidoP.text.clear()
                lectorApellidoM.text.clear()
                calendarioView.date = 0

                for(genero in generos)
                {
                    genero.isChecked = false
                }
                otroGenero.text.clear()

                mostrarPersonitas()
            }
            else
            {
                Snackbar.make(it, resources.getString(R.string.datos_incompletos_ex), Snackbar.LENGTH_SHORT).show()
            }
        })

        calendarioView.setOnDateChangeListener(CalendarView.OnDateChangeListener
        { view, year, month, dayOfMonth ->
            val calendario : Calendar = Calendar.getInstance()
            val yearPresente : Int = calendario.get(Calendar.YEAR)
            var selectorYear : DatePickerDialog = DatePickerDialog(applicationContext,
                {_,selectedYear,_,_ ->
                    calendarioView.date = calendario.apply{ set(Calendar.YEAR, selectedYear) }.timeInMillis
                }, yearPresente, 0, 1)

            selectorYear.show()
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
            listaPersonitas!!.setVerticalScrollBarEnabled(true)
        }
        catch(ex : Exception)
        {
            Toast.makeText(applicationContext, ex.message, Toast.LENGTH_LONG).show()
        }
    }
}