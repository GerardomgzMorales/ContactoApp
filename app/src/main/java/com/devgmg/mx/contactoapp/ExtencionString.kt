package com.devgmg.mx.contactoapp

fun String.isEmail(): Boolean {
    val regex = "[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}".toRegex()
    return this.isNotEmpty() && this.matches(regex)
}

fun String.isNumberPhone() = this.isNotEmpty() && this.matches("\\d{10}".toRegex())

