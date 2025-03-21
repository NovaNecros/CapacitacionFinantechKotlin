fun volumenCubo(lado : Double) : Double = lado*lado*lado
fun areaCubo(lado : Double) : Double = 6*lado*lado

fun areaTriangulo(base : Double, altura : Double) : Double = 0.5*base*altura
fun areaTriangulo(lado1 : Double, lado2 : Double, lado3 : Double) : Double
{
    val S : Double = 0.5*(lado1 + lado2 + lado3)
    val A2 : Double = S*(S-lado1)*(S-lado2)*(S-lado3)

    return Math.sqrt(A2)

}

fun centiToFarenheit(c : Double) : Double = c*1.8 + 32
fun centiToKelvin(c : Double) : Double = c + 273.16
fun centiToRankine(c : Double) : Double = 1.8*c + 491.67
fun farenheitToCelsius(f : Double) : Double = 0.0
fun farenheitToKelvin(f : Double) : Double = 0.0
fun farenheitToRankine(f : Double) : Double = f + 459.67
fun kelvinToCelsius(k : Double) : Double = k - 273.15
fun kelvinToFarenheit(k : Double) : Double = 0.0
fun kelvinToRankine(k : Double) : Double = 0.0
fun rankineToCelsius(r : Double) : Double = 0.9
fun rankineToFarenheit(r : Double) : Double = r - 459-67
fun rankineToKelvin(r : Double) : Double = 0.0


fun main()
{
    println("Volumen de cubo: ${volumenCubo(5.0)}")
    println("Area de Triángulo: ${areaTriangulo(4.0,5.0)}")
    println("Temperatura en Farenheit: ${centiToFarenheit(4.0)}")
}