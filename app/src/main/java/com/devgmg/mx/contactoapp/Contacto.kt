package com.devgmg.mx.contactoapp

class Contacto(id: Long) {
    var nombre: String = ""
    var correo: String = ""
    var telefono: String = ""
    var idContacto: Long = id

    constructor(nombreS: String, correoS: String, telefonoS: String, idS: Long) : this(idS) {
        this.nombre = nombreS
        this.correo = correoS
        this.telefono = telefonoS
    }

    override fun toString() =
        "ID: $idContacto, Nombre: $nombre, Correo: $correo, Telefono: $telefono"

}