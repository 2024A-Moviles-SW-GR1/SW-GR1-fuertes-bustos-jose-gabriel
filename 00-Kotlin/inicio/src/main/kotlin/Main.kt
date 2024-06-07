import java.util.*

fun main() {
    val inmutable: String = "Adrian"
    // Todas las variables de Kotlin se pueden usar en Java
    var mutable: String = "Vicente"
    mutable = "Adrian"
    // Buscar crear variables inmutables de preferencia

    val ejemploVariable = " Eduardo Mosquera "
    println(ejemploVariable.trim())

    val sueldo: Double = 1.2

    val fechaNacimiento: Date = Date()

    // Para usar switch también hay when
    val estadoCivil = "C"
    when (estadoCivil) {
        "C" -> {
            println("Casado")
        }
        "S" -> {
            println("Soltero")
        }
        else -> {
            println("No sabemos")
        }
    }

    val esSoltero = (estadoCivil == "S")
    val coqueteo = if (esSoltero) "Si" else "No"
    println("Coqueteo: $coqueteo")

    // Llamar a la función calcularSueldo con diferentes parámetros
    println(calcularSueldo(10.00))
    println(calcularSueldo(10.00, 15.99, 20.00))
    println(calcularSueldo(10.00, bonoEspecial = 20.00))
    println(calcularSueldo(bonoEspecial = 20.00, sueldo = 10.00, tasa = 14.00))

    val sumaUno = Suma(1, 1)
    val sumaDos = Suma(1, null)
    val sumaTres = Suma(null, 1)
    val sumaCuatro = Suma(null, null)
    println("Resultado de sumaUno: ${sumaUno.sumar()}")
    println("Resultado de sumaDos: ${sumaDos.sumar()}")
    println("Resultado de sumaTres: ${sumaTres.sumar()}")
    println("Resultado de sumaCuatro: ${sumaCuatro.sumar()}")

    println(Suma.pi)
    println(Suma.elevarAlCuadrado(2))
    println(Suma.historialSumas)
    println("Hola Mundo " + mutable + ejemploVariable.trim())

    val arregloEstatico: Array<Int> = arrayOf(1, 2, 3)
    println(arregloEstatico.contentToString())

    val arregloDinamico: ArrayList<Int> = arrayListOf(
        1, 2, 3, 4, 5, 6, 7, 8, 9
    )
    println(arregloDinamico)

    arregloDinamico.add(11)
    arregloDinamico.add(12)
    println(arregloDinamico)

    // Uso correcto de forEach con una lambda
    arregloDinamico.forEach { valorActual ->
        println("Valor Actual: $valorActual")
    }

    // Otra forma de uso de forEach con it
    arregloDinamico.forEach {
        println("Valor actual (it): $it")
    }
}

fun imprimirNombre(nombre: String) {
    println("Nombre: $nombre")
}

fun calcularSueldo(sueldo: Double, tasa: Double = 12.00, bonoEspecial: Double? = null): Double {
    return if (bonoEspecial == null) {
        sueldo * (100 / tasa)
    } else {
        sueldo * (100 / tasa) * bonoEspecial
    }
}

abstract class Numeros(
    protected val numeroUno: Int,
    protected val numeroDos: Int
) {
    init {
        println("Inicializando Numeros: $numeroUno y $numeroDos")
    }
}

class Suma(
    unoParametro: Int,
    dosParametro: Int
) : Numeros(unoParametro, dosParametro) {
    val soyPublicoExplicito: String = "EXPLICITO "
    val soyPublicoImplicito: String = "Implicito"

    init {
        println("Inicializando Suma: $numeroUno y $numeroDos")
    }

    fun sumar(): Int {
        val total = numeroUno + numeroDos
        Companion.agregarHistorial(total)
        return total
    }

    companion object {
        val pi = 3.14
        val historialSumas = arrayListOf<Int>()

        fun elevarAlCuadrado(num: Int): Int {
            return num * num
        }

        fun agregarHistorial(valorTotalSuma: Int) {
            historialSumas.add(valorTotalSuma)
        }
    }

    constructor(uno: Int?, dos: Int) : this(uno ?: 0, dos)

    constructor(uno: Int, dos: Int?) : this(uno, dos ?: 0)

    constructor(uno: Int?, dos: Int?) : this(uno ?: 0, dos ?: 0)
}






