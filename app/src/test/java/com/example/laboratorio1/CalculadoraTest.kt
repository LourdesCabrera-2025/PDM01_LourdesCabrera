package com.example.laboratorio1

import org.junit.Test

class CalculadoraTest {
    @Test
    fun prueba () {

        val c = Calculadora()

        println(" Información de calculadora :   ${c.marca}, ${c.tiempo_vida}, ${c.precio} ")
        println(" pruebas: ")
        println(" suma: ${c.sumar(5,3)} \n" +
                " resta: ${c.restar(8, 3)} \n" +
                " mmultiplicar: ${c.multiplicar(5, 7)} \n" +
                " dividir : ${c.dividir(16, 2)}")




    }
}