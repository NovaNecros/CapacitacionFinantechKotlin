package com.capacitacion2.sqlite_en_android

import android.content.Context

class Personita(contexto : Context)
{
    private val dataManager = DataManager(contexto)
    var id : Int = 0
    var nombre : String = ""
    var apellidoP : String = ""
    var apellidoM : String = ""
    var generos : String = ""
    var fecha : String = ""

    constructor(contexto : Context, nombre : String, apellidoP : String, apellidoM : String, generos : String, fecha : String)
            : this(contexto)
    {
        this.id = dataManager.getNewID()
        this.nombre = nombre
        this.apellidoP = apellidoP
        this.apellidoM = apellidoM
        this.generos = generos
        this.fecha = fecha
    }

    override fun toString() : String
    {
        return this.nombre
    }
}