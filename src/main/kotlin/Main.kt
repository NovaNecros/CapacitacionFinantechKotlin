package org.example

class Alumno(val nombre : String, val apellidoP : String, val apellidoM : String, val id : Int)
{
    var materiaId : Int = 0
    var calificacion : Int = 0

    fun getNombre() : String = this.nombre + " " + this.apellidoP + " " + this.apellidoM

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
            "\nMateria: ${this.getMateria()}\nCalificación: ${this.getCalif()}"
}

class Materia(val nombre : String, val id : Int)
{
    fun getNombre() : String = this.nombre
    fun getId() : Int = this.id
    override fun toString() : String = this.getId().toString() + " " + this.getNombre()
}

class Calificacion(val calif : String)
{
    fun imprimir(materias : MutableList<Materia>, alumnos : MutableList<Alumno>)
    {
        var cont1 : Int = 1
        var cont2 : Int

        for(materia in materias) {
            cont2 = 0
            println(materia)
            for (alumno in alumnos) {
                if (cont1 == alumnos[cont2].getMateria()) {
                    println("\t${alumno}")
                }
                ++cont2
            }
            ++cont1
        }
    }
    override fun toString() : String = "${calif}"
}

fun main()
{

}