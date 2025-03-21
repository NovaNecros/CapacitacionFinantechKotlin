package org.example

class Alumno(val nombre : String, val apellidoP : String,
             val apellidoM : String, val id : Int)
{
    var materiaId : Int = 0
    var calificacion : Int = 0

    fun getNombre() : String = this.nombre + " " + this.apellidoP +
            " " + this.apellidoM

    fun setMateria(materiaId : Int)
    {
        this.materiaId = materiaId
    }

    fun getMateria() : Int = this.materiaId

    fun setCalif(calif : Int)
    {
        this.calificacion = calif
    }

    fun getCalif() : Int = this.calificacion

    override fun toString() : String = "Nombre: ${this.getNombre()}" +
            "\nMateria: ${this.getMateria()}\n" +
            "Calificación: ${this.getCalif()}"
}

fun main()
{

}