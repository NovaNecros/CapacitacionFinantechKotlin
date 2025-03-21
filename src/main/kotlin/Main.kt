fun volumenCubo(lado : Double) : Double = lado*lado*lado
fun areaCubo(lado : Double) : Double = 6*lado*lado

fun areaTriangulo(base : Double, altura : Double) : Double = 0.5*base*altura
fun areaTriangulo(lado1 : Double, lado2 : Double, lado3 : Double) : Double
{
    val S : Double = 0.5*(lado1 + lado2 + lado3)
    return Math.sqrt(S*(S-lado1)*(S-lado2)*(S-lado3))
}

fun celsiusToFahrenheit(c : Double) : Double = c*1.8 + 32
fun celsiusToKelvin(c : Double) : Double = c + 273.16
fun celsiusToRankine(c : Double) : Double = 1.8*c + 491.67

fun fahrenheitToCelsius(f : Double) : Double = (f-32)/1.8
fun fahrenheitToKelvin(f : Double) : Double = (f+459.67)/1.8
fun fahrenheitToRankine(f : Double) : Double = f + 459.67

fun kelvinToCelsius(k : Double) : Double = k - 273.16
fun kelvinToFahrenheit(k : Double) : Double = (k-273.16)*1.8 + 32
fun kelvinToRankine(k : Double) : Double = 1.8*k

fun rankineToCelsius(r : Double) : Double = (r-491.67)/1.8
fun rankineToFahrenheit(r : Double) : Double = r - 459.67
fun rankineToKelvin(r : Double) : Double = r/1.8


fun main()
{
    val lado : Double = 5.0
    println("Lado del cubo: ${lado}")
    println("Volumen de cubo: ${volumenCubo(lado)}")
    println("Area de cubo: ${areaCubo(lado)}\n\n")


    val base : Double = 3.0
    val altura : Double = 4.0
    val hipotenusa : Double = 5.0
    println("Lados: ${base}, ${altura}, ${hipotenusa} (es triángulo rectángulo)")
    println("Área (b*h/2): ${areaTriangulo(base, altura)}")
    println("Área (fórmula de Heron): ${areaTriangulo(base, altura, hipotenusa)}\n\n")


    val c : Double = 21.0
    println("Temperatura: ${c} °C")
    println("${celsiusToFahrenheit(c)} °F")
    println("${celsiusToKelvin(c)} K")
    println("${celsiusToRankine(c)} °R\n")

    val f : Double = 21.0
    println("Temperatura: ${f} °F")
    println("${fahrenheitToCelsius(f)} °C")
    println("${fahrenheitToKelvin(f)} K")
    println("${fahrenheitToRankine(f)} °R\n")

    val k : Double = 21.0
    println("Temperatura: ${k} K")
    println("${kelvinToCelsius(k)} °C")
    println("${kelvinToFahrenheit(k)} °F")
    println("${kelvinToRankine(f)} °R\n")

    val r : Double = 21.0
    println("Temperatura: ${r} °R")
    println("${rankineToCelsius(r)} °C")
    println("${rankineToFahrenheit(r)} °F")
    println("${rankineToKelvin(r)} K")
}