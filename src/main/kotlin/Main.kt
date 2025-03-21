//phi = 1.618, proporción aúrea
val phi : Double = 0.5*(1.0+Math.sqrt(5.0))
val invrt5 : Double = 1.0/Math.sqrt(5.0)

//Recursion: tiempo - O(phi^n), memoria O(1)
fun fibonacci(n : Int) : Int
{
    return if(n <= 1) {n}
    else fibonacci(n-1)+fibonacci(n-2)
}

//Programación dinámica: tiempo - O(n), memoria O(n)
fun fibonacciDinamico(n : Int, fiboMem : MutableList<Int>) : Int
{
    if(fiboMem.isEmpty())
    {
        fiboMem.add(0)
        fiboMem.add(1)
    }

    if(fiboMem.size <= n)
    {
        fiboMem.add(fibonacciDinamico(n-1, fiboMem)
                + fibonacciDinamico(n-2, fiboMem))
    }

    return fiboMem[n]
}

//Fórmula de Binet: Tiempo - O(1), Memoria - O(1)
fun fibonacciBinet(n : Int) : Int =
    Math.round(Math.pow(phi, n.toDouble())*invrt5).toInt()

fun main()
{
    print("\nn:\t")
    val n : Int = (readlnOrNull() ?: "").toInt()

    println("\nRecursión O(phi^n):")
    for(i in 0 until n)
    {
        print("${fibonacci(i)}, ")
    }
    print("${fibonacci(n)}\n")


    println("\nProgramación Dinámica O(n):")
    var fiboMem = mutableListOf<Int>()
    fibonacciDinamico(n, fiboMem)
    println(fiboMem.toString())


    println("\nFórmula de Binet O(1):")
    println("F${n} = ${fibonacciBinet(n)}")
}