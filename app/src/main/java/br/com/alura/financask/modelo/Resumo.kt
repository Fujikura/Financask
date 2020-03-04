package br.com.alura.financask.modelo

import java.math.BigDecimal

class Resumo(private val transacoes: List<Transacao>) {

    fun receita(): BigDecimal {
        val somaDaReceita = transacoes.filter { transacao -> transacao.tipo == Tipo.RECEITA }
            .sumByDouble { transacao -> transacao.valor.toDouble() }
        return BigDecimal(somaDaReceita)

    }

    fun despesa(): BigDecimal {
        val somaDaDespesa = transacoes.filter { transacao -> transacao.tipo == Tipo.DESPESA }
            .sumByDouble { transacao -> transacao.valor.toDouble() }
        return BigDecimal(somaDaDespesa)
    }

    fun total(): BigDecimal{
        return receita().subtract(despesa())
    }
}