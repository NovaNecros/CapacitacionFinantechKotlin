package com.capacitacion2.sqlite_en_android

class Personita()
{
    var id : Int = 0
    var nombre : String = ""
    var apellidoP : String = ""
    var apellidoM : String = ""
    var generos : String = ""
    var fecha : String = ""

    constructor(nombre : String, apellidoP : String, apellidoM : String, generos : String, fecha : String)
            : this()
    {
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