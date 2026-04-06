package com.example.laboratorio1

import org.junit.Test

class ComputadoraTest {

    @Test

    fun soporte() {

        val pc = Computadora()
        pc.election = 5
        pc.MainInit()
        pc.OffComputer()
    }
}