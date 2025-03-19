/*EL SIGUIENTE CÓDIGO ES COMPLETAMENTE EXPERIMENTAL
* NADA TIENE UN PROPÓSITO */

fun main()
{
    var contador : Int = 0
    val pi : String = "e"; //asigno un valor de string como val

    contador = 5
    println("Hola Mundo ${contador}\n")
    println("El valor de pi es $pi")

    val x = 3
    val y : Int = 4
    val z : Int = 6 //pruebo cambiar var por val

    val a = arrayOf(3,6,7,8,9,2)

    println("El valor de x es $x")
    println("El valor de y es $y")

    println("\n\nLos elementos del arreglo son:")
    for(ai in a)
    {
        print("$ai ") //intento imprimir t o d o el arreglo en un solo renglon
    }

    println("\n\nCiclo en un rango:")
    for(i in 0..5)
    {
        print("$i ")
    }

    println("\n\nCiclo en un rango inverso:")
    for(i in (0..5).reversed())
    {
        print("$i ")
    }


    println("\n\nDime tu edad:")
    val opcion : String = readlnOrNull() ?: ""
    val edad = opcion.toInt()

    if(edad >= 18)
    {
        println("Eres grande")
    }
    else
    {
        println("Eres joven")
    }
}