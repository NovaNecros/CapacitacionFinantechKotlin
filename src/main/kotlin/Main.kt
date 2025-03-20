fun main()
{
    for(i in 1..15)
    {
        println()
        for(j in 1..15)
        {
            //imprime los resultados en hexadecimal
            print("${(i*j).toString(16)}\t")
        }
    }
}