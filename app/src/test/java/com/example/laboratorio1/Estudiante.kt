package com.example.laboratorio1

class Estudiante {

    class InformacionEstudiante (

        val NombreEstudiante: String,
        val CarnetEstudiante: String,
        val Asignatura: String
    )

    val Ciclo01 = listOf(
        InformacionEstudiante ("Alexander Josue Rivas Hernandez", "003502026", "Dispositivos Moviles"),
        InformacionEstudiante("Maria Fernanda De Leon", "003502025", "Analisis de Sistemas"),
        InformacionEstudiante("Lourdes Isabel Cabrera ", "00034023", "Dispositivos Moviles"),
        InformacionEstudiante("Sofia Alejandra Fernandez Aguirre", "003512025", "Analisis de Sistemas"),
        InformacionEstudiante("Fernando Ernesto Gonzales Iraheta", "0003602024", "Dispositivos Moviles")
    )

    fun PasarLista() {

        println("Estudiantes que pertenecen a la materia de Dispositivos Moviles")

        for (Estudiantes in Ciclo01) {
            if(Estudiantes.Asignatura == "Dispositivos Moviles") {
                println("Nombre:  ${Estudiantes.NombreEstudiante}" )
                println("Carnet: ${Estudiantes.CarnetEstudiante}")
                println("Asignatura: ${Estudiantes.Asignatura}")
            }
        }
    }
}