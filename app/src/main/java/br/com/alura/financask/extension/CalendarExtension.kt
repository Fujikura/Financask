package br.com.alura.financask.extension

import java.text.SimpleDateFormat
import java.util.*


fun Calendar.formataParaBrasileiro(): String {
    val formataBrasileiro = "dd/MM/yyyy"
    val format = SimpleDateFormat(formataBrasileiro)
    return format.format(this.time)
}