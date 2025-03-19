
fun sumar(x:Int, y:Int) : Int
{
    return x+y;
}

fun multi(x:Int, y:Int) : Int = x*y


fun main()
{
    val x : Int = 34;
    val y : Int = 42;

    println("\nLa suma de ${x} y ${y} es ${sumar(x,y)}")
    println("El producto de ${x} y ${y} es ${multi(x,y)}")
}