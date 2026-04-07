package com.example.laboratorio2

import android.os.Bundle
import android.widget.Button
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var nombre: TextInputEditText
    private lateinit var guardar: Button
    private lateinit var limpiar: Button
    private lateinit var tabla: TableLayout

    private val lista = mutableListOf<String>()

    override fun onCreate(savedInstaceState: Bundle?) {
        super.onCreate(savedInstaceState)
        setContentView(R.layout.activity_main)

        nombre = findViewById(R.id.id_nombre)
        guardar = findViewById(R.id.id_guardar)
        limpiar = findViewById(R.id.id_limpiar)
        tabla = findViewById(R.id.id_table)

        guardar.setOnClickListener {
            val texto = nombre.text.toString()
            if(texto.isNotEmpty()) {
                lista.add(texto)
                agregarFila(texto, lista.size)
                nombre.text?.clear()
            }
        }

        limpiar.setOnClickListener {
            tabla.removeAllViews()
            lista.clear()
            nombre.text?.clear()
        }
    }

    private fun agregarFila(nombre: String, posicion: Int) {
        val fila = TableRow(this)
        val txtNombre = TextView(this)
        txtNombre.text = nombre
        txtNombre.textSize = 18f
        txtNombre.setPadding(20,20,200,20)

        val txtPosicion = TextView(this)
        txtPosicion.text= posicion.toString()
        txtPosicion.textSize = 18f

        fila.addView(txtNombre)
        fila.addView(txtPosicion)

        tabla.addView(fila)
    }
}