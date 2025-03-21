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

//esquema de partición de Hoare
fun particion(numeros : Array<Int>, lo : Int, hi : Int) : Int
{
    val pivote : Int = numeros[lo]
    var i : Int = lo - 1
    var j : Int = hi + 1

    while(true)
    {
        do { ++i } while(numeros[i] < pivote)
        do { --j } while(numeros[j] > pivote)
        if(i >= j) return j

        val temp : Int = numeros[j]
        numeros[j] = numeros[i]
        numeros[i] = temp
    }
}

//lamada recursiva a quicksort
fun quickSort(numeros: Array<Int>, lo : Int, hi : Int)
{
    if(lo>=0 && hi>=0 && hi>lo)
    {
        val p : Int = particion(numeros, lo, hi)
        quickSort(numeros, lo, p)
        quickSort(numeros, p+1, hi)
    }
}

//llamada sencilla a quicksort
fun quickSort(numeros : Array<Int>, n : Int)
{
    quickSort(numeros, 0, n-1)
}

//esquema top-down
fun merge(numeros : Array<Int>, ini : Int, mid : Int, fin : Int)
{
    val n1 : Int = mid - ini + 1
    val n2 : Int = fin - mid
    var ind : Int = ini
    var ind1 : Int = 0
    var ind2 : Int = 0
    var L : Array<Int> = Array(n1) {0}
    var R : Array<Int> = Array(n2) {0}

    for(i in 0 until n1)
    {
        L[i] = numeros[ini + i]
    }
    for(i in 0 until n2)
    {
        R[i] = numeros[mid + 1 + i]
    }

    while(ind1<n1 && ind2<n2)
    {
        if(L[ind1] <= R[ind2])
        {
            numeros[ind] = L[ind1]
            ++ind1
        }
        else
        {
            numeros[ind] = R[ind2]
            ++ind2
        }
        ++ind
    }

    while(ind1<n1)
    {
        numeros[ind] = L[ind1]
        ++ind
        ++ind1
    }

    while(ind2<n2)
    {
        numeros[ind] = R[ind2]
        ++ind
        ++ind2
    }
}

//llamada recursiva a mergesort
fun mergeSort(numeros : Array<Int>, ini : Int, fin : Int)
{
    val mid : Int = ini + (fin - ini) / 2
    if(ini<fin)
    {
        mergeSort(numeros, ini, mid)
        mergeSort(numeros, mid+1, fin)
        merge(numeros, ini, mid, fin)
    }
}

//llamada sencilla a mergesort
fun mergeSort(numeros : Array<Int>, n : Int)
{
    mergeSort(numeros, 0, n-1)
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
    val opcion : Int = 5

    imprimirDatos(numeros, tam)

    when(opcion) //para elegir fácilmente cuál algoritmo probar
    {
        1 -> {
                println("BubbleSort:")
                bubbleSort(numeros, tam)
             }
        2 -> {
                println("InsertionSort:")
                insertionSort(numeros, tam)
             }
        3 -> {
                println("SelectionSort:")
                selectionSort(numeros, tam)
             }
        4 -> {
                println("QuickSort:")
                quickSort(numeros, tam)
             }
        5 -> {
                println("MergeSort:")
                mergeSort(numeros, tam)
             }
        else -> println(":(")
    }

    imprimirDatos(numeros, tam)

    return
}