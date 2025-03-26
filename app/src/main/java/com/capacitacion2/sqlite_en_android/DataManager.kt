package com.capacitacion2.sqlite_en_android

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataManager(contexto : Context)
{
    val dbHelper : SQLiteOpenHelper = DBHelper(contexto)
    var baseDatos : SQLiteDatabase = dbHelper.writableDatabase

    fun abrir()
    {
        baseDatos = dbHelper.writableDatabase
    }

    fun cerrar()
    {
        baseDatos.close()
    }

    fun borrar()
    {
        dbHelper.onUpgrade(baseDatos, 1, 1)
    }

    fun guardarPersonita(fulanito : Personita)
    {
        val valores = ContentValues()
        valores.put("nombre", fulanito.nombre)
        valores.put("apellidoP", fulanito.apellidoP)
        valores.put("apellidoM", fulanito.apellidoM)
        valores.put("fecha", fulanito.fecha)
        valores.put("genero", fulanito.generos.toString())

        baseDatos.insert("personitas", null, valores)
    }

    fun leerPersonitas() : Array<Personita>
    {
        val personitas = mutableListOf<Personita>()
        val columnas = arrayOf("nombre", "apellidoP", "apellidoM", "genero", "fecha")
        val cursor : Cursor = baseDatos.query("personitas", columnas, null, null, null, null, null)

        while(cursor.moveToNext())
        {
            val fulanito = Personita()

            fulanito.nombre = cursor.getString(0)
            fulanito.apellidoP = cursor.getString(1)
            fulanito.apellidoM = cursor.getString(2)
            fulanito.generos = cursor.getString(3)
            fulanito.fecha = cursor.getString(4)

            personitas.add(fulanito)
        }

        cursor.close()

        return personitas.toTypedArray()
    }
}