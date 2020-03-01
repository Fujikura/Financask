package br.com.alura.financask.modelo

import java.math.BigDecimal
import java.util.*

class Transacao(val valor: BigDecimal,
                val tipo: Tipo,
                val categoria: String = "Indefinida",
                val data: Calendar = Calendar.getInstance())
