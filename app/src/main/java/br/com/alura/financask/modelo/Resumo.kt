package br.com.alura.financask.modelo

import java.math.BigDecimal

class Resumo(private val transacoes: List<Transacao>) {

    fun receita(): BigDecimal {
        val somaDaReceita = transacoes.filter { transacao -> transacao.tipo == Tipo.RECEITA }
            .sumByDouble { transacao -> transacao.valor.toDouble() }
        return BigDecimal(somaDaReceita)

    }

    fun despesa(): BigDecimal {
        var totalDespesa = BigDecimal.ZERO
        for (transacao: Transacao in transacoes) {
            if (transacao.tipo == Tipo.DESPESA)
                totalDespesa = totalDespesa.plus(transacao.valor)
        }
        return totalDespesa
    }

    fun total(): BigDecimal{
        return receita().subtract(despesa())
    }
}