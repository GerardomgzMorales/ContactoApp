package com.devgmg.mx.contactoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var contador: Long = 1L

    private lateinit var txtNombre: EditText
    private lateinit var txtCorreo: EditText
    private lateinit var txtTelephony: EditText
    private var btnGuardar: Button? = null
    private lateinit var txtlistaC: TextView

    private val listaContacto = ArrayList<Contacto>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Tomamos los valores de la Vista
        cargarElementos()

        //Comando BTN
        btnGuardar?.setOnClickListener {
            agregarContacto()
            if (listaContacto.size > 0) {
                agregarLista()
            }
        }
    }

    private fun cargarElementos() {
        txtNombre = findViewById(R.id.txtNombre)
        txtCorreo = findViewById(R.id.txtCorreos)
        txtTelephony = findViewById(R.id.txtNumeros)
        btnGuardar = findViewById(R.id.btnGuarda)
        txtlistaC = findViewById(R.id.listaUsuarios)
    }

    private fun agregarContacto() {
        val contacto = Contacto(
            txtNombre.text.toString(),
            txtCorreo.text.toString(),
            txtTelephony.text.toString(),
            contador++
        )
        if (contacto.nombre.isEmpty() || !contacto.correo.isEmail() || !contacto.telefono.isNumberPhone()) {
            Toast.makeText(
                this,
                R.string.mensajeToast,
                Toast.LENGTH_SHORT
            ).show()
        } else {
            listaContacto.add(contacto)
        }
        txtNombre.setText("")
        txtCorreo.setText("")
        txtTelephony.setText("")
    }

    private fun agregarLista() {
        var allContactos = ""
        listaContacto.forEach {
            allContactos += " $it\n\n"
        }
        txtlistaC.text = allContactos
    }


}