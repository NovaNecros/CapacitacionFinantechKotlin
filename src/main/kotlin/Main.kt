package org.example

class Alumno(val nombre : String, val apellidoP : String, val apellidoM : String, val id : Int)
{
    var materiaId : Int = 0
    var calificacion : Int = 0

    fun getNombreAlumno() : String = this.nombre + " " + this.apellidoP + " " + this.apellidoM

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

    override fun toString() : String = "\tNombre: ${this.getNombreAlumno()}" +
            "\n\tMateria: ${this.getMateria()}\n\tCalificación: ${this.getCalif()}"
}

class Materia(val nombre : String, val id : Int)
{
    fun getNombreMateria() : String = this.nombre
    fun getIdMateria() : Int = this.id
    override fun toString() : String = this.getIdMateria().toString() + " " + this.getNombreMateria()
}

class Calificacion(val calif : String)
{
    fun imprimir(materias : MutableList<Materia>, alumnos : MutableList<Alumno>)
    {
        var cont1 : Int = 1
        var cont2 : Int

        for(materia in materias) {
            cont2 = 0
            println("\n${materia}\n")
            for (alumno in alumnos) {
                if (cont1 == alumnos[cont2].getMateria()) {
                    println("${alumno}\n")
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
    var alumnos = mutableListOf<Alumno>()
    var materias = mutableListOf<Materia>()
    var calificacion = Calificacion("1")

    alumnos.add(Alumno("Morgan", "Jolly", "Martínez", 0))
    alumnos.add(Alumno("abigail", "sánchez", "lópez", 1))
    alumnos.add(Alumno("Nancy", "Prado", "Martínez", 2))
    alumnos.add(Alumno("Michelle", "Pani", "Navarro", 3))
    alumnos.add(Alumno("Mariana", "Morfín", "Márquez", 4))
    alumnos.add(Alumno("Natalia", "Jolly", "Martínez", 5))

    materias.add(Materia("Análisis y Diseño de Algoritmos", 1))
    materias.add(Materia("Ecuaciones Diferenciales Parciales", 2))
    materias.add(Materia("Dibujitos", 3))

    alumnos[0].setMateria(1)
    alumnos[1].setMateria(1)
    alumnos[2].setMateria(2)
    alumnos[3].setMateria(3)
    alumnos[4].setMateria(2)
    alumnos[5].setMateria(2)

    alumnos[0].setCalif(10)
    alumnos[1].setCalif(10)
    alumnos[2].setCalif(5)
    alumnos[3].setCalif(8)
    alumnos[4].setCalif(9)
    alumnos[5].setMateria(9)

    calificacion.imprimir(materias, alumnos)
}