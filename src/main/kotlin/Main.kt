fun bubbleSort(numeros : Array<Int>, n : Int)
{
    //TODO
}

fun imprimirDatos(numeros : Array<Int>, n : Int)
{
    for(i in 0 until n)
    {
        print(numeros[i])
    }
    println()
}

fun main(args : Array<String>)
{
    var numeros :Array<Int> = arrayOf(9,6,7,2,5,3)
    var tam = numeros.size

    imprimirDatos(numeros, tam)
    println("BubbleSort:")
    bubbleSort(numeros, tam)
    imprimirDatos(numeros, tam)

    return
}