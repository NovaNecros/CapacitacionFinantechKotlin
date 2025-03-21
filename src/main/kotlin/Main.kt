fun fibonacci(n : Int) : Int
{
    return if(n == 0 || n == 1) {1}
    else fibonacci(n-1)+fibonacci(n-2)
}

fun main()
{
    var temp : Int
    var x : Int = 1
    val limite : Int

    println("Ingrese número límite de recursión")
    val opcion : String = readlnOrNull() ?: ""
    limite = opcion.toInt()

    while(x <= limite)
    {
        temp = fibonacci(x)
        println("F${x} = ${temp}")
        ++x
    }

    return
}