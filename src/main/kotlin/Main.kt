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
    //TODO
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
    var numeros : Array<Int> = arrayOf(9,6,7,2,5,3)
    var tam : Int = numeros.size

    imprimirDatos(numeros, tam)
    println("Ordenado:")
    insertionSort(numeros, tam)
    imprimirDatos(numeros, tam)

    return
}