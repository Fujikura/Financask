package br.com.alura.financask.modelo

import java.math.BigDecimal
import java.util.*

class Transacao(valor: BigDecimal,
                categoria: String,
                data: Calendar) {

    private val valor = valor
    private val categoria = categoria
    private val data = data

    fun getValor(): BigDecimal {
        return this.valor
    }

    fun getCategoria(): String{
        return this.categoria
    }

    fun getData(): Calendar{
        return this.data
    }

}