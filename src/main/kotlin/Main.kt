fun bubbleSort(numeros : Array<Int>, n : Int)
{
    for(i in 0 until n-1)
    {
        for(j in 0 until n-1-i)
        {
            if(numeros[j] > numeros[j+1])
            {
                val temp = numeros[j]
                numeros[j] = numeros[j+1]
                numeros[j+1] = temp
            }
        }
    }
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