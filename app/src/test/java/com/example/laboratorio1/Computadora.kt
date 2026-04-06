package com.example.laboratorio1


class Computadora {

    var Processor : String = "Intel Core i7 12th"
    var RAM: Int = 8
    var StorageComputer: Int= 512
    var Operative_System : String = "Windows 11 "
    var Graphic_Target : String = "NVIDIA GEFORCE RTX 3050"
    var on_computer : Boolean = false
    var election : Int = 0

    var OperativeSystem = arrayOf(
        "Windows 11",
        "Linux Ubuntu",
        "Linux Fedora",
        "Linux Debian",
        "Linux Mint",
        "Chrome OS",
        "Solaris",
        "FreeBSD",
        "Haiku"
    )

    var GraphicsTarget = arrayOf(
        "NVIDIA GeForce RTX 5090",
        "NVIDIA GeForce RTX 5080",
        "AMD Radeon RX 9070",
        "AMD Radeon RX 7900",
        "Intel Arc A770",
        "Asus Prime"
    )

    var SoftwarePrograms = arrayOf(
        "Notion 2026",
        "Facebook 2024",
        "Steam 2023",
        "Spotify 2026",
        "ChatGPT 2024",
        "Visual  Studio Code 2026",
        "Whatsapp 2025",
        "Android Studio 2026",
        "Netflix 2022"
    )

    fun OnComputer() {
        on_computer = true
        println("La computadora se ha inicializado exitosamente")
    }

    fun OffComputer() {
        on_computer= false
        println("La computadora se ha apagado exitosamente")
    }

    fun ChangeRam(newRam: Int) {
        RAM = newRam
        println("La RAM ha sido actualizada correctamente a $RAM GB")
    }

    fun ChangeStorage(new_storage: Int) {
        StorageComputer = new_storage
        println("El almacenamiento de la computadora ha sido ampliado a $StorageComputer GB")
    }

    fun ChangeOperativeSystem(new_so: String) {
        Operative_System = new_so
        println("El Sistema Operativo nuevo es : $Operative_System")
    }

    fun ChangeGraphicTarget(new_target: String) {
        Graphic_Target = new_target
        println("La nueva tarjeta grafica de la computadora es : $Graphic_Target")
    }

    fun ViewSoftwarePrograms () {
        println("Programas instalados del año 2026: ")

        for (programs in SoftwarePrograms) {
            if(programs.contains("2026")) {
                println(programs)
            }
        }
    }

    fun MainInit  () {

        println("-------------Bienvenido a tu soporte tecnico-----------------")
        println("1.Soporte de RAM para computadora \n" +
                "2.Ampliar almacenamiento del sistema \n" +
                "3.Cambiar sistema operativo \n" +
                "4.Soporte de Tarjeta Grafica para computadora\n" +
                "5.Ver programas lista de programas instalados")
        println("-------------------------------------------------------------")
        print("Seleccionar opción: $election \n\n")

        when(election) {
            1-> ChangeRam(16)
            2-> ChangeStorage(256)
            3-> ChangeOperativeSystem(OperativeSystem[2])
            4->ChangeGraphicTarget(GraphicsTarget[3])
            5->ViewSoftwarePrograms()
            else -> println("Seleccion invalida ")
        }
    }
}

