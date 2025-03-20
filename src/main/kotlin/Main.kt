fun bubbleSort(numeros : Array<Int>, n : Int)
{
    //si no intercambia en una iteración, termina
    var intercambio : Boolean = false

    for(i in 0 until n-1)
    {
        intercambio = false

        for(j in 0 until n-1-i)
        {
            if(numeros[j] > numeros[j+1])
            {
                intercambio = true
                val temp : Int = numeros[j]
                numeros[j] = numeros[j+1]
                numeros[j+1] = temp
            }
        }

        if(!intercambio)
        {
            return
        }
    }
}

fun insertionSort(numeros : Array<Int>, n : Int)
{
    for(i in 1 until n)
    {
        var j : Int = i

        while(j>0 && numeros[j-1] > numeros[j])
        {
            val temp : Int = numeros[j]
            numeros[j] = numeros[j-1]
            numeros[j-1] = temp
            --j
        }
    }
}

fun selectionSort(numeros : Array<Int>, n : Int)
{
    for(i in 0 until n)
    {
        var jmin : Int = i

        for(j in i+1 until n)
        {
            if(numeros[j] < numeros[jmin])
            {
                jmin = j
            }
        }

        if(jmin != i)
        {
            val temp : Int = numeros[jmin]
            numeros[jmin] = numeros[i]
            numeros[i] = temp
        }
    }
}

fun quickSort(numeros : Array<Int>, n : Int)
{
    //TODO
}

fun mergeSort(numeros : Array<Int>, n : Int)
{
    //TODO
}

fun imprimirDatos(numeros : Array<Int>, n : Int)
{
    for(i in 0 until n)
    {
        print("${numeros[i]} ")
    }
    println()
}

fun main(args : Array<String>)
{
    val numeros : Array<Int> = arrayOf(9,6,7,2,5,3)
    val tam : Int = numeros.size
    val opcion : Int = 1

    imprimirDatos(numeros, tam)
    println("Ordenado:")

    when(opcion)
    {
        1 -> bubbleSort(numeros, tam)
        2 -> insertionSort(numeros, tam)
        3 -> selectionSort(numeros, tam)
        else -> println(":(")
    }

    imprimirDatos(numeros, tam)

    return
}