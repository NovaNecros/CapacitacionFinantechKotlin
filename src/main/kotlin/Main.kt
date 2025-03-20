class Auto(val marca:String, val modelo:String)
{
    var distancia:Int = 0
    var gasolina:Int = 0 //permite que el coche avance

    fun avanzar()
    {
        if(gasolina>0) //si no hay gasolina, no avanza
        {
            ++distancia
            --gasolina //descarga gasolina
        }
    }

    fun avanzar(x:Int)
    {
        if(gasolina >= x)
        {
            distancia += x
            gasolina -= x //descarga gasolina
        }
        else if(gasolina > 0) //si no le alcanza para avanzar x pero tiene gasolina
        {
            avanzar(this.gasolina) //avanza hasta agotar la gasolina
        }
    }

    fun cargarGasolina(x:Int)
    {
        gasolina += x
    }

    override fun toString() : String = "${marca} - ${modelo} - Distancia: ${distancia} - Gasolina: ${gasolina}"
}

fun main()
{
    var carrito : Auto = Auto("VM", "Sedan")
    var carrote : Auto = Auto("Ferrari", "Clasico")
    var carros = listOf(carrito, carrote)
    var coches = mutableListOf<Auto>()

    carrito.cargarGasolina(75)
    carrote.cargarGasolina(500)

    println()
    for(auto in carros)
    {
        println(auto)
    }

    carrito.avanzar(100)
    carrote.avanzar(200)

    println()
    for(auto in carros)
    {
        println(auto)
    }

    coches.add(carrito)
    coches.add(carrote)
    coches.add(Auto("Tsuru", "Nissan"))

    println()
    for(auto in coches)
    {
        println(auto)
    }

    coches.removeAt(0)
    coches[1].cargarGasolina(5)
    coches[1].avanzar(150)

    println()
    for(auto in coches)
    {
        println(auto)
    }
}