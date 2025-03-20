//imprime las tablas de multiplicar en cualquier base
fun tablasBase(base:Int)
{
    for(i in 1..base-1)
    {
        println()
        for(j in 1..base-1)
        {
            print("${(i*j).toString(base)}\t")
        }
    }
}

fun main()
{
    val base : Int = 16
    println("Base: ${base}")
    tablasBase(base)
}