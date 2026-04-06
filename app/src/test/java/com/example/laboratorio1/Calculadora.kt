package com.example.laboratorio1

class Calculadora {

    val marca: String = "HyperCalc"
    val tiempo_vida: Int = 15
    var precio : Double = 35.90

    fun sumar (valor1: Int, valor2 : Int): Int{

        var total : Int

        total = valor1 + valor2

        return total
    }

    fun restar (valor_1: Int, valor_2: Int) : Int{

        var total: Int

        total = valor_1 - valor_2

       return  total
    }

    fun multiplicar (operacion1: Int , operacion2: Int) : Int {

        var total: Int

        total = operacion1 * operacion2

        return total
    }

    fun dividir (operacion_1: Int, operacion_2 : Int): Int {

        var total: Int

        if(operacion_2 == 0 ) {
            println("Error: No puedes dividir entre 0")
            return 0
        } else {
            total = operacion_1/operacion_2
            return total
        }
    }


}