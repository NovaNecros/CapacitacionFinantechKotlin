//Complejidad O(n)
fun sumaCuadrados(n : Int) : Int
{
    var s : Int = 0
    for( i in 1..n)
    {
        s += i*i
    }
    return s
}

//Complejidad O(1)
fun sumaCuadradosVeloz(n : Int) : Int = n*(n+1)*(2*n+1)/6

fun main()
{
    val n : Int = 30
    println("Suma de ${n} cuadrados: ${sumaCuadrados(n)}")
    println("Lo mismo pero más rápido: ${sumaCuadradosVeloz(n)}")
}