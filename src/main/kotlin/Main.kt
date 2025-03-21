fun volumenCubo(x : Int) : Int
{
    return x*x*x
}

fun areaTriangulo(x : Int, y : Int) : Int
{
    return x*y/2
}

fun centiToFarenheit(x : Int) : Int
{
    return x*9/5 + 32
}

fun main()
{
    println("Volumen de cubo: ${volumenCubo(5)}")
    println("Area de Triángulo: ${areaTriangulo(4,5)}")
    println("Temperatura en Farenheit: ${centiToFarenheit(4)}")
}