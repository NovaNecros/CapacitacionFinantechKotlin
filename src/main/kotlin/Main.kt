
fun sumar(x:Double, y:Double) : Double = x+y

fun multi(x:Double, y:Double) : Double = x*y

//raiz cuadrada de un número
fun raiz(x:Double) : Double = Math.sqrt(x)

//Calcula el promedio de dos números
fun mediaAritmetica(x:Double, y:Double) : Double
{
    return multi(0.5, sumar(x,y))
}

//Multiplica dos números y saca la raíz cuadrada del resultado
fun mediaGeometrica(x:Double, y:Double) : Double
{
    return raiz(multi(x,y))
}


fun main()
{
    val x : Double = 16.0;
    val y : Double = 4.0;

    println("\nLa suma de ${x} y ${y} es ${sumar(x,y)}")
    println("El producto de ${x} y ${y} es ${multi(x,y)}")
    println("La raíz de ${x} es: ${raiz(x)}")
    println("La raíz de ${y} es: ${raiz(y)}")
    println("La media aritmética de ${x} y ${y} es ${mediaAritmetica(x,y)}")
    println("La media geométrica de ${x} y ${y} es ${mediaGeometrica(x,y)}")
}